package comm.mobile.demo.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by n on 2016/10/11.
 */
public class InnerViewPager extends ViewPager {

    /** 触摸时按下的点 **/
    PointF downPoint = new PointF();
    /** 触摸时当前的点 **/
    PointF curPoint = new PointF();

    OnSingleTouchListener onSingleTouchListener;


    public InnerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InnerViewPager(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        // 当拦截触摸事件到达此位置的时候，返回true，
        // 说明将onTouch拦截在此控件，进而执行此控件的onTouchEvent
        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        // 每次进行onTouch事件都记录当前的按下的坐标
        curPoint.x = arg0.getX();
        curPoint.y = arg0.getY();

        if (arg0.getAction() == MotionEvent.ACTION_DOWN) {
            // 记录按下时坐标
            downPoint.x = arg0.getX();
            downPoint.y = arg0.getY();
            // 通知父ViewPager现在进行的是本控件的操作
            getParent().requestDisallowInterceptTouchEvent(true);
        }

        if (arg0.getAction() == MotionEvent.ACTION_MOVE) {
            // 同上
            getParent().requestDisallowInterceptTouchEvent(true);
        }

        if (arg0.getAction() == MotionEvent.ACTION_UP) {
            // 在up时判断是否按下和松手的坐标为一个点
            // 如果是一个点，将执行点击事件
            if (downPoint.x == curPoint.x && downPoint.y == curPoint.y) {
                onSingleTouch();
                return false;
            }
        }
        return super.onTouchEvent(arg0);
    }

    /**
     * 单击
     */
    public void onSingleTouch() {
        if (onSingleTouchListener != null) {
            onSingleTouchListener.onSingleTouch();
        }
    }

    /**
     * 点击事件内部接口
     */
    public interface OnSingleTouchListener {
        public void onSingleTouch();
    }

    public void setOnSingleTouchListener(OnSingleTouchListener onSingleTouchListener) {
        this.onSingleTouchListener = onSingleTouchListener;
    }
}
