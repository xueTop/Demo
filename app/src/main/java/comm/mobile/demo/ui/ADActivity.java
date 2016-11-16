package comm.mobile.demo.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import comm.mobile.demo.R;

public class ADActivity extends AppCompatActivity {

    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        imageview= (ImageView) findViewById(R.id.activity_ad_imageView);

        //initView();
        initData();

    }

    private void initData() {

        Picasso.with(this)
                .load(Uri.parse("http://fdfs.xmcdn.com/group22/M00/36/74/wKgJLlglh9qT1rtRAAGYerlorxQ168.jpg"))
                .error(R.drawable.myspin_image_default_album_s)
                .placeholder(R.drawable.myspin_image_default_album_s)
                .into(imageview);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(4000);
                    startActivity(new Intent(ADActivity.this,MainActivity.class));
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

//    private void initView() {
//        OkHttpUtils.get()
//                .url(AppInterface.AD_URL)
//                .build()
//                .execute(new StringCallback()
//                {
//            @Override
//            public void onError(Call call, Exception e, int i) {
//
//            }
//
//            @Override
//            public void onResponse(String s, int i) {
//                try {
//                    JSONObject jsobject=new JSONObject(s);
//                    JSONArray jsonArray = jsobject.optJSONArray("data");
//                    for (int i1 = 0; i1 < jsonArray.length(); i1++) {
//                        JSONObject picObject= (JSONObject) jsonArray.opt(i1);
//                        ADEntity adEntity = new ADEntity();
//                        adEntity.setCover(picObject.getString("cover"));
//                        ad.add(adEntity);
//                    }
//                    Log.d("flag", "长度： "+ad.size());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

}
