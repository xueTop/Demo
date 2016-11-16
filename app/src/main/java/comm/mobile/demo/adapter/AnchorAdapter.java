package comm.mobile.demo.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import comm.mobile.demo.R;
import comm.mobile.demo.bean.AnchorEntity;

/**
 * Created by Administrator on 2016/11/16.
 */
public class AnchorAdapter extends MBaseAdapter<AnchorEntity.ListBean> {

    public AnchorAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return getDatas().size();
    }

    @Override
    public AnchorEntity.ListBean getItem(int i) {
        return getDatas().get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view=getInflater().inflate(R.layout.item_anchor,viewGroup,false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }

        AnchorEntity.ListBean item=getItem(i);
        viewHolder.textView.setText(item.getTitle());
        viewHolder.textView1.setText(item.getList().get(0).getNickname());
        viewHolder.textView2.setText(item.getList().get(1).getNickname());
        viewHolder.textView3.setText(item.getList().get(2).getNickname());

        Picasso.with(context).load(Uri.parse(item.getList().get(0).getSmallLogo())).error(R.drawable.image_default)
                .into(viewHolder.imageView);
        Picasso.with(context).load(Uri.parse(item.getList().get(1).getSmallLogo())).error(R.drawable.image_default)
                .into(viewHolder.imageView1);
        Picasso.with(context).load(Uri.parse(item.getList().get(2).getSmallLogo())).error(R.drawable.image_default)
                .into(viewHolder.imageView2);

        return view;
    }

    public void addAll(List<AnchorEntity.ListBean> dd) {
        getDatas().addAll(dd);
        notifyDataSetChanged();
    }

    class ViewHolder{
        private TextView textView,textView1,textView2,textView3;
        private ImageView imageView,imageView1,imageView2;
        public ViewHolder(View view){
            textView= (TextView) view.findViewById(R.id.item_anchor_textViewOutTitle);
            textView1= (TextView) view.findViewById(R.id.item_anchor_trackTitle);
            textView2= (TextView) view.findViewById(R.id.item_anchor_trackTitle1);
            textView3= (TextView) view.findViewById(R.id.item_anchor_trackTitle2);
            imageView= (ImageView) view.findViewById(R.id.item_anchor_coverMiddle);
            imageView1= (ImageView) view.findViewById(R.id.item_anchor_coverMiddle1);
            imageView2= (ImageView) view.findViewById(R.id.item_anchor_coverMiddle2);
        }
    }

}
