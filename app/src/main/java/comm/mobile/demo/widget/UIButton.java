package comm.mobile.demo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/11/16.
 */
public class UIButton extends View {

    private Paint paint;

    public UIButton(Context context) {
        this(context,null);
    }

    public UIButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();

        RectF r1 = new RectF();
        r1.left = 50;
        r1.right = 200;
        r1.top = 50 ;
        r1.bottom = 150;

    //新建矩形r2
        RectF r2 = new RectF();
        r2.left = 50;
        r2.right = 250;
        r2.top = 200 ;
        r2.bottom = 300;

    //画出矩形r1
        canvas.drawRect(r1,paint);
    //画出圆角矩形r2
        canvas.drawRoundRect(r2, 10, 10, paint);

    }

    private void initPaint() {
        paint=new Paint();
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
    }



}
