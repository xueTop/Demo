package comm.mobile.demo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/11/10.
 */
public class MyApp extends Application {

    private static MyApp app;
    private RequestQueue requestQueue;

    public static MyApp getApp() {
        return app;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        initVolley();
    }

    private void initVolley() {
        requestQueue= Volley.newRequestQueue(this);
    }

}
