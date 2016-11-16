package comm.mobile.demo.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import comm.mobile.demo.R;
import comm.mobile.demo.bean.LiveEntity;

/**
 * Created by Administrator on 2016/11/15.
 */
public class LiveAdapter extends BaseAdapter{

    private List<Object> datas;
    private LayoutInflater inflate;
    private Context context;

    private static final int TYPE_UP=0;
    private static final int TYPE_DOWN=1;


    public LiveAdapter(Context context) {
        this.inflate=LayoutInflater.from(context);
        this.context = context;
        datas=new ArrayList<>();
    }

    @Override
    public int getCount() {
        return datas.size();
    }


    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(getItem(position) instanceof LiveEntity.ResultBean.RecommandRadioListBean){
            return TYPE_UP;
        }else {
            return TYPE_DOWN;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        ViewHolder1 holder1;
        switch (getItemViewType(i)) {
            case TYPE_UP:
                if(view == null){
                    view=inflate.inflate(R.layout.item_live,viewGroup,false);
                    holder=new ViewHolder(view);
                    view.setTag(holder);
                }else {
                    if(view.getTag() instanceof ViewHolder){
                        holder= (ViewHolder) view.getTag();
                    }else {
                        view=inflate.inflate(R.layout.item_live,viewGroup,false);
                        holder=new ViewHolder(view);
                        view.setTag(holder);
                    }
                }
                LiveEntity.ResultBean item= (LiveEntity.ResultBean) getItem(i);
                LiveEntity.ResultBean.RecommandRadioListBean bean = item.getRecommandRadioList().get(0);
                LiveEntity.ResultBean.RecommandRadioListBean bean1 = item.getRecommandRadioList().get(1);
                LiveEntity.ResultBean.RecommandRadioListBean bean2 = item.getRecommandRadioList().get(2);

                holder.textView.setText(bean.getRname());
                holder.textView1.setText(bean1.getRname());
                holder.textView2.setText(bean2.getRname());

                Picasso.with(context).load(Uri.parse(bean.getPicPath())).error(R.drawable.image_default).into(holder.image);
                Picasso.with(context).load(Uri.parse(bean1.getPicPath())).error(R.drawable.image_default).into(holder.image1);
                Picasso.with(context).load(Uri.parse(bean2.getPicPath())).error(R.drawable.image_default).into(holder.image2);

                break;
            case TYPE_DOWN:

                if(view == null){
                    view=inflate.inflate(R.layout.item_live1,viewGroup,false);
                    holder1=new ViewHolder1(view);
                    view.setTag(holder1);
                }else {
                    if(view.getTag() instanceof ViewHolder1){
                        holder1= (ViewHolder1) view.getTag();
                    }else {
                        view=inflate.inflate(R.layout.item_live1,viewGroup,false);
                        holder1=new ViewHolder1(view);
                        view.setTag(holder1);
                    }
                }

                LiveEntity.ResultBean item1= (LiveEntity.ResultBean) getItem(i);
                LiveEntity.ResultBean.TopRadioListBean listBean = item1.getTopRadioList().get(0);
                LiveEntity.ResultBean.TopRadioListBean listBean1 = item1.getTopRadioList().get(1);
                LiveEntity.ResultBean.TopRadioListBean listBean2 = item1.getTopRadioList().get(2);

                holder1.text.setText(listBean.getRname());
                holder1.text1.setText(listBean1.getRname());
                holder1.text2.setText(listBean2.getRname());

                holder1.textView.setText(listBean.getRadioPlayCount()/1000+"万人");
                holder1.textView1.setText(listBean1.getRadioPlayCount()/1000+"万人");
                holder1.textView2.setText(listBean2.getRadioPlayCount()/1000+"万人");

                holder1.name.setText(listBean.getProgramName());
                holder1.name1.setText(listBean1.getProgramName());
                holder1.name2.setText(listBean2.getProgramName());

                Picasso.with(context).load(Uri.parse(listBean.getRadioCoverLarge())).error(R.drawable.image_default).into(holder1.imageView);
                Picasso.with(context).load(Uri.parse(listBean1.getRadioCoverLarge())).error(R.drawable.image_default).into(holder1.imageView1);
                Picasso.with(context).load(Uri.parse(listBean2.getRadioCoverLarge())).error(R.drawable.image_default).into(holder1.imageView2);

                break;
        }

        return view;
    }

    public void addAll(Object dd) {
        datas.add(dd);
        notifyDataSetChanged();
    }

    public void addAll1(Object dd) {
        datas.add(dd);
        notifyDataSetChanged();
    }

    class ViewHolder{

        private TextView textView,textView1,textView2;
        private ImageView image,image1,image2;
        public ViewHolder(View view){
            textView= (TextView) view.findViewById(R.id.item_live_textView);
            textView1= (TextView) view.findViewById(R.id.item_live_textView1);
            textView2= (TextView) view.findViewById(R.id.item_live_textView2);
            image= (ImageView) view.findViewById(R.id.item_live_imageView);
            image1= (ImageView) view.findViewById(R.id.item_live_imageView1);
            image2= (ImageView) view.findViewById(R.id.item_live_imageView2);
        }

    }

    class ViewHolder1{
        private TextView text,text1,text2,name,name1,name2,textView,textView1,textView2;
        private ImageView imageView,imageView1,imageView2;
        public ViewHolder1(View view){
            text= (TextView) view.findViewById(R.id.item_live1_textView);
            text1= (TextView) view.findViewById(R.id.item_live1_textView1);
            text2= (TextView) view.findViewById(R.id.item_live1_textView2);
            name= (TextView) view.findViewById(R.id.item_live1_textViewName);
            name1= (TextView) view.findViewById(R.id.item_live1_textViewName1);
            name2= (TextView) view.findViewById(R.id.item_live1_textViewName2);
            textView= (TextView) view.findViewById(R.id.item_live1_textViewPeople);
            textView1= (TextView) view.findViewById(R.id.item_live1_textViewPeople1);
            textView2= (TextView) view.findViewById(R.id.item_live1_textViewPeople2);
            imageView= (ImageView) view.findViewById(R.id.item_live1_imageView);
            imageView1= (ImageView) view.findViewById(R.id.item_live1_imageView1);
            imageView2= (ImageView) view.findViewById(R.id.item_live1_imageView2);
        }
    }
}
