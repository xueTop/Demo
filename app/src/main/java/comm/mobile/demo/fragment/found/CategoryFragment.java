package comm.mobile.demo.fragment.found;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import comm.mobile.demo.R;
import comm.mobile.demo.adapter.CategoryAdapter;
import comm.mobile.demo.bean.CategoryEntity;
import comm.mobile.demo.uri.AppInterface;
import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    private PullToRefreshListView refreshListView;
    private CategoryAdapter adapter;
    private ImageView image;
    private List<CategoryEntity> cate=new ArrayList<>();
    private View headView;

    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance() {

        Bundle args = new Bundle();
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_category, container, false);
        initView(rootView);
        return rootView;
    }

    private void initHeadView() {
        headView=LayoutInflater.from(getContext()).inflate(R.layout.item_head_cate,refreshListView.getRefreshableView(),false);
        image= (ImageView) headView.findViewById(R.id.item_head_cate_imageView);
        Picasso.with(getContext())
                .load(Uri.parse("http://fdfs.xmcdn.com/group25/M0A/40/4C/wKgJNlgpi9vS8PqbAAXb8yLvEHk745.jpg"))
                .error(R.drawable.myspin_image_default_album_s)
                .into(image);
        refreshListView.getRefreshableView().addHeaderView(headView);
    }

    private void initView(View rootView) {
        refreshListView= (PullToRefreshListView) rootView.findViewById(R.id.fragment_category_refreshListView);
        initHeadView();
        adapter=new CategoryAdapter(getContext());
        refreshListView.setAdapter(adapter);
        loadData();
    }

    private void loadData() {

        OkHttpUtils.get()
                .url(AppInterface.CATE_URL)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {

                    }

                    @Override
                    public void onResponse(String s, int i) {
                        try {
                            JSONObject jsonObject=new JSONObject(s);
                            JSONArray list = jsonObject.optJSONArray("list");
                            for (int i1 = 0; i1 < list.length(); i1++) {
                                JSONObject entityObject= (JSONObject) list.opt(i1);
                                CategoryEntity entity=new CategoryEntity();
                                entity.setTitle(entityObject.optString("title"));
                                entity.setCoverPath(entityObject.optString("coverPath"));
                                cate.add(entity);
                            }

                            Log.d("flag", "onResponse: "+cate.size());

                            adapter.addAll(cate);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        Log.d("flag", "loadData: "+123);

//        StringRequest stringResquest=new StringRequest(AppInterface.CATE_URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.d("flag", "onResponse: "+response);
//                List<CategoryEntity.ListBean> categoryEntities = JSON.parseArray(response, CategoryEntity.ListBean.class);
//                Log.d("flag1", "onResponse: "+categoryEntities.size());
//                adapter.addAll(categoryEntities);
//            }
//        },null);
//        stringResquest.setTag("cate");
//        MyApp.getApp().getRequestQueue().add(stringResquest);

    }

    @Override
    public void onDestroy() {
        //MyApp.getApp().getRequestQueue().cancelAll("cate");
        super.onDestroy();
    }

}
