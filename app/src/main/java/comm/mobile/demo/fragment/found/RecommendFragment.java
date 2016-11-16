package comm.mobile.demo.fragment.found;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import comm.mobile.demo.MyApp;
import comm.mobile.demo.R;
import comm.mobile.demo.adapter.RecommendAdapter;
import comm.mobile.demo.bean.Recommend;
import comm.mobile.demo.uri.AppInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {

    private PullToRefreshListView refreshListView;
    private RecommendAdapter adapter;

    public RecommendFragment() {

    }

    public static RecommendFragment newInstance() {
        Bundle args = new Bundle();
        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_recommend, container, false);
        initView(rootView);
        initData();
        return rootView;
    }

    private void initData() {

        StringRequest request=new StringRequest(AppInterface.RECO_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Recommend recommend = JSON.parseObject(response, Recommend.class);

                Recommend.EditorRecommendAlbumsBean list = recommend.getEditorRecommendAlbums();
                Recommend.SpecialColumnBean list1 = recommend.getSpecialColumn();

                adapter.addAll(list);
                adapter.addAll1(list1);

            }},null);

        request.setTag("recom");

        MyApp.getApp().getRequestQueue().add(request);

    }

    private void loadMore(){
        StringRequest request1=new StringRequest(AppInterface.RECO_URL1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


            }},null);

        request1.setTag("recom1");

        MyApp.getApp().getRequestQueue().add(request1);
    }


    private void initView(View rootView) {

        refreshListView= (PullToRefreshListView) rootView.findViewById(R.id.fragment_recommend_refreshListView);
        initHeadView();
        adapter=new RecommendAdapter(getContext());
        refreshListView.setAdapter(adapter);
        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);
    }

    private void initHeadView() {
        View headView= LayoutInflater.from(getActivity()).inflate(R.layout.item_head_reco,refreshListView.getRefreshableView(),false);

    }

    @Override
    public void onDestroy() {
        MyApp.getApp().getRequestQueue().cancelAll("recom1");
        MyApp.getApp().getRequestQueue().cancelAll("recom");
        super.onDestroy();
    }

}
