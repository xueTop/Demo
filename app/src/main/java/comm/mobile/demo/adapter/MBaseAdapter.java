package comm.mobile.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public abstract class MBaseAdapter<T> extends BaseAdapter {

    private List<T> datas;
    private LayoutInflater inflater;
    protected Context context;

    public LayoutInflater getInflater() {
        return inflater;
    }

    public List<T> getDatas() {
        return datas;
    }

    public MBaseAdapter(Context context){
        inflater=LayoutInflater.from(context);
        datas=new ArrayList<>();
        this.context=context;
    }

    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public T getItem(int i) {
        return datas==null?null:datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void clear(){
        if(datas!=null){
            datas.clear();
        }
        notifyDataSetChanged();
    }

}
