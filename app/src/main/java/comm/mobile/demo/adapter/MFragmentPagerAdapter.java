package comm.mobile.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class MFragmentPagerAdapter extends FragmentPagerAdapter{

    protected FragmentManager fm;
    protected List<Fragment> fragments;

    public MFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fm=fm;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment= (Fragment) super.instantiateItem(container, position);
        fm.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        fm.beginTransaction().hide(fragments.get(position)).commit();
    }

    public void addAll(List<Fragment> fms){
        if(fragments==null){
            fragments=new ArrayList<>();
        }
        fragments.addAll(fms);
        notifyDataSetChanged();
    }

}
