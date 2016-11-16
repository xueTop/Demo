package comm.mobile.demo.fragment.found;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import comm.mobile.demo.MyApp;
import comm.mobile.demo.R;
import comm.mobile.demo.adapter.AnchorAdapter;
import comm.mobile.demo.bean.AnchorEntity;
import comm.mobile.demo.uri.AppInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnchorFragment extends Fragment {

    private PullToRefreshListView refresh;
    private AnchorAdapter adapter;

    public AnchorFragment() {
        // Required empty public constructor
    }

    public static AnchorFragment newInstance() {
        Bundle args = new Bundle();
        AnchorFragment fragment = new AnchorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_anchor, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        refresh= (PullToRefreshListView) rootView.findViewById(R.id.fragment_anchor_refreshListView);
        adapter=new AnchorAdapter(getContext());
        refresh.setAdapter(adapter);
        loadData();
        refresh.setMode(PullToRefreshBase.Mode.BOTH);
        refresh.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            /**
             * 滑动监听，加载更多
             * @param refreshView
             */
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                    if(refresh.isHeaderShown()){
                        adapter.clear();
                        page=1;
                        loadData();
                        hideHintMsg(refresh);
                    }else {
                        page++;
                        loadData();
                        hideHintMsg(refreshView);
                    }
            }
        });

        refresh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * item 点击事件
             * @param adapterView
             * @param view
             * @param i
             * @param l
             */
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    /**
     * 网络请求数据
     */
    private int page=1;
    private void loadData() {
        StringRequest qust=new StringRequest(String.format(AppInterface.ANCH_URL,page), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson=new Gson();
                AnchorEntity anchorEntity = gson.fromJson(response, AnchorEntity.class);
                List<AnchorEntity.ListBean> list = anchorEntity.getList();
                adapter.addAll(list);
            }
        },null);

        qust.setTag("anchor");
        MyApp.getApp().getRequestQueue().add(qust);
    }

    @Override
    public void onDestroy() {
        MyApp.getApp().getRequestQueue().cancelAll("anchor");
        super.onDestroy();
    }

    protected void hideHintMsg(final PullToRefreshBase<?> refreshView) {
        //一个防止因刷新时间过短而使提示信息不会消息的方法
        refreshView.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshView.onRefreshComplete();
            }
        },500);
    }

}
