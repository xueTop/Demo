package comm.mobile.demo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import comm.mobile.demo.R;
import comm.mobile.demo.adapter.FoundFragmnetPagerAdapter;
import comm.mobile.demo.bean.TabEntity;
import comm.mobile.demo.config.AppConfig;
import comm.mobile.demo.fragment.found.AnchorFragment;
import comm.mobile.demo.fragment.found.CategoryFragment;
import comm.mobile.demo.fragment.found.LiveFragment;
import comm.mobile.demo.fragment.found.RankingFragment;
import comm.mobile.demo.fragment.found.RecommendFragment;
import comm.mobile.demo.uri.AppInterface;
import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> fragments;
    private List<TabEntity> tabs;
    private List<String> titles;

    private FoundFragmnetPagerAdapter adapter;

    public FoundFragment() {
        // Required empty public constructor
    }

    public static FoundFragment newInstance() {
        Bundle args = new Bundle();
        FoundFragment fragment = new FoundFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_found, container, false);
        initView(rootView);
        initData();
        return rootView;

    }


    private void initView(View rootView) {

        tabs=new ArrayList<>();
        viewPager= (ViewPager) rootView.findViewById(R.id.fragment_found_viewPager);
        tabLayout= (TabLayout) rootView.findViewById(R.id.fragment_found_tabLayout);
        viewPager.setPageTransformer(true,new DepthPageTransformer());

    }

    private void initData() {
        OkHttpUtils.get()
                .url(AppInterface.TAB_URL)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {

                    }

                    @Override
                    public void onResponse(String s, int i) {
                        try {
                            JSONObject jsonObject = new org.json.JSONObject(s);
                            JSONObject dataObject=jsonObject.optJSONObject("tabs");
                            JSONArray jsonArray=dataObject.optJSONArray("list");
                            for (int i1 = 0; i1 < jsonArray.length(); i1++) {
                                JSONObject tabObject= (JSONObject) jsonArray.opt(i1);
                                TabEntity tabEntity=new TabEntity();
                                tabEntity.setTitle(tabObject.optString("title"));
                                tabEntity.setContentType(tabObject.optString("contentType"));
                                tabs.add(tabEntity);
                            }
                            initFragments();
                            tabLayout.setTabMode(TabLayout.MODE_FIXED);
                            adapter=new FoundFragmnetPagerAdapter(getChildFragmentManager());
                            viewPager.setAdapter(adapter);
                            adapter.addAll(fragments,titles);
                            tabLayout.setupWithViewPager(viewPager);
                            viewPager.setCurrentItem(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
    }



    private void initFragments() {

        fragments=new ArrayList<>();
        titles=new ArrayList<>();
        for (int i = 0; i < tabs.size(); i++) {
            String title=tabs.get(i).getTitle();
            titles.add(title);
            switch (i) {
                case AppConfig.recommend:
                    fragments.add(RecommendFragment.newInstance());
                    break;
                case AppConfig.category:
                    fragments.add(CategoryFragment.newInstance());
                    break;
                case AppConfig.live:
                    fragments.add(LiveFragment.newInstance());
                    break;
                case AppConfig.ranking:
                    fragments.add(RankingFragment.newInstance());
                    break;
                case AppConfig.anchor:
                    fragments.add(AnchorFragment.newInstance());
                    break;
            }

        }
    }
}
