package comm.mobile.demo.fragment.found;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.List;

import comm.mobile.demo.MyApp;
import comm.mobile.demo.R;
import comm.mobile.demo.adapter.LiveAdapter;
import comm.mobile.demo.bean.LiveEntity;
import comm.mobile.demo.uri.AppInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends Fragment {

    private ListView listview;
    private LiveAdapter adapter;

    public LiveFragment() {
        // Required empty public constructor
    }

    public static LiveFragment newInstance() {
        Bundle args = new Bundle();
        LiveFragment fragment = new LiveFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_live, container, false);
        initView(rootView);
        loadData();
        return rootView;
    }

    private void initView(View rootView) {
        listview= (ListView) rootView.findViewById(R.id.fragment_live_listView);
        adapter=new LiveAdapter(getContext());
        listview.setAdapter(adapter);
    }

    private void loadData() {

        StringRequest request1=new StringRequest(AppInterface.LIVE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    List<LiveEntity.ResultBean.RecommandRadioListBean> been =
                            JSON.parseArray(response, LiveEntity.ResultBean.RecommandRadioListBean.class);
                    Log.d("flag", "been.size():"+been.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        },null);

        request1.setTag("live");
        MyApp.getApp().getRequestQueue().add(request1);
    }

    @Override
    public void onDestroy() {
        MyApp.getApp().getRequestQueue().cancelAll("live");
        super.onDestroy();
    }
}
