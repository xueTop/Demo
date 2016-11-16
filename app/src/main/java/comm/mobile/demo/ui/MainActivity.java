package comm.mobile.demo.ui;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import comm.mobile.demo.R;
import comm.mobile.demo.fragment.DownLoadFragment;
import comm.mobile.demo.fragment.FoundFragment;
import comm.mobile.demo.fragment.MenuFragment;
import comm.mobile.demo.fragment.MyFragment;
import comm.mobile.demo.fragment.SubscriptionFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout frameLayout;
    private RadioGroup radioGroup;

    private SlidingMenu slidingMenu;

    private FragmentManager manage;
    private FragmentTransaction transaction;

    private List<Fragment> fragments;
    private FoundFragment foundFragment;
    private SubscriptionFragment subscriptionFragment;
    private MenuFragment menuFragment;
    private DownLoadFragment downLoadFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();

        initView();

        initSlidingMenu();


        manage=getSupportFragmentManager();

        transaction=manage.beginTransaction();

        for(int i=0;i<fragments.size();i++){
            transaction.add(frameLayout.getId(),fragments.get(i));
            if(i == 0){
                transaction.show(fragments.get(i));
            }else {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.commit();
    }

    private void initSlidingMenu() {

        slidingMenu=new SlidingMenu(this);

        slidingMenu.attachToActivity(this,SlidingMenu.SLIDING_WINDOW);

        slidingMenu.setMode(SlidingMenu.LEFT);

        slidingMenu.setMenu(R.layout.sliding_left);

        slidingMenu.setBehindOffset(getResources().getDisplayMetrics().widthPixels/3);

        slidingMenu.setBehindScrollScale(0.5f);

        slidingMenu.setTouchModeAbove(SlidingMenu.LEFT);

        slidingMenu.setBehindCanvasTransformer(new SlidingMenu.CanvasTransformer() {
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
                float percent=percentOpen*0.5f+0.5f;
                canvas.scale(percent,percent,0,canvas.getHeight()/2);
            }
        });

        //9.设置MainActivity的滑动动画
        //修改源码，自定义的方法，同setBehindCanvasTransformer
        slidingMenu.setAboveCanvasTransformer(new SlidingMenu.CanvasTransformer() {

            /**
             * 菜单滑动由小变大(percentOpen=100%)
             * @param canvas the canvas:画布，通过canvas绘制出来
             * @param percentOpen the percent open：百分比，菜单打开的百分比
             */
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
                //p->pivot:中心点
                /**
                 * 前两个参数缩放百分比，
                 * 后两个缩放中心点位置
                 */
                float percent=1-percentOpen*0.5f;
                canvas.scale(percent,percent,canvas.getWidth()/2,canvas.getHeight()/2);
            }
        });
    }

    private void initView() {
        frameLayout= (FrameLayout) findViewById(R.id.activity_main_frameLayout);
        radioGroup= (RadioGroup) findViewById(R.id.activity_main_radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
    }
    private void initFragment() {
        fragments=new ArrayList<>();
        fragments.add(foundFragment.newInstance());
        fragments.add(subscriptionFragment.newInstance());
        fragments.add(menuFragment.newInstance());
        fragments.add(downLoadFragment.newInstance());
        fragments.add(myFragment.newInstance());
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.activity_main_radioButtonFound:
                showFragmentAtPosition(0);
                break;
            case R.id.activity_main_radioButtonSubscription:
                showFragmentAtPosition(1);
                break;
            case R.id.activity_main_myRadioButtonMenu:
                showFragmentAtPosition(2);
                break;
            case R.id.activity_main_radioButtonDownLoad:
                showFragmentAtPosition(3);
                break;
            case R.id.activity_main_radioButtonMy:
                showFragmentAtPosition(4);
                break;
        }
    }

    private void showFragmentAtPosition(int position){
        transaction=manage.beginTransaction();
        for(int i=0;i<fragments.size();i++){
            if(i == position){
                transaction.show(fragments.get(i));
            }else {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.commit();
    }

}
