package comm.mobile.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class FoundFragmnetPagerAdapter extends MFragmentPagerAdapter {

    private List<String> titles;

    public FoundFragmnetPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public void addAll(List<Fragment> fms, List<String> tts) {
        if(fragments==null){
            fragments=new ArrayList<>();
        }
        if(titles==null){
            titles=new ArrayList<>();
        }
        fragments.addAll(fms);
        titles.addAll(tts);
        notifyDataSetChanged();
    }

}
