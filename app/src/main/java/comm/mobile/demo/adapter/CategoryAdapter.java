package comm.mobile.demo.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import comm.mobile.demo.R;
import comm.mobile.demo.bean.CategoryEntity;

/**
 * Created by Administrator on 2016/11/15.
 */
public class CategoryAdapter extends MBaseAdapter<CategoryEntity>{

    private static final int TYPE=0;
    private static final int TYPE1=1;

    private List<CategoryEntity> list;
    private Context context;

    public CategoryAdapter(Context context) {
        super(context);
        this.context=context;
        list=new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size()/3-1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public CategoryEntity getItem(int i) {
        return list.get(i-1);
    }

    @Override
    public int getItemViewType(int position) {
        if((position+1)%2 != 0){
            return TYPE1;
        }else {
            return TYPE;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder1 viewHolder1;
        ViewHolder viewHolder;
        switch (getItemViewType(i)) {
            case TYPE1:
                if(view == null){
                    view=getInflater().inflate(R.layout.item_category,viewGroup,false);
                    viewHolder=new ViewHolder(view);
                    view.setTag(viewHolder);
                }else{
                    if(view.getTag() instanceof ViewHolder){
                        viewHolder= (ViewHolder) view.getTag();
                    }else {
                        view=getInflater().inflate(R.layout.item_category,viewGroup,false);
                        viewHolder=new ViewHolder(view);
                        view.setTag(viewHolder);
                    }
                }
                viewHolder.text.setText(getItem(3*(i+1)-2).getTitle());
                viewHolder.text1.setText(getItem(3*(i+1)-1).getTitle());
                viewHolder.text2.setText(getItem(3*(i+1)).getTitle());
                viewHolder.text3.setText(getItem(3*(i+1)+1).getTitle());
                Picasso.with(context)
                        .load(Uri.parse(getItem(3*(i+1)-2)
                                .getCoverPath()))
                        .error(R.drawable.image_default)
                        .into(viewHolder.image);
                Picasso.with(context)
                        .load(Uri.parse(getItem(3*(i+1)-1)
                                .getCoverPath()))
                        .error(R.drawable.image_default)
                        .into(viewHolder.image1);
                Picasso.with(context)
                        .load(Uri.parse(getItem(3*(i+1))
                                .getCoverPath()))
                        .error(R.drawable.image_default)
                        .into(viewHolder.image2);
                Picasso.with(context)
                        .load(Uri.parse(getItem(3*(i+1)+1)
                                .getCoverPath()))
                        .error(R.drawable.image_default)
                        .into(viewHolder.image3);

                break;
            case TYPE:

                if(view == null){
                    view=getInflater().inflate(R.layout.item_category1,viewGroup,false);
                    viewHolder1=new ViewHolder1(view);
                    view.setTag(viewHolder1);
                }else{
                    if(view.getTag() instanceof ViewHolder1){
                        viewHolder1= (ViewHolder1) view.getTag();
                    }else {
                        view=getInflater().inflate(R.layout.item_category1,viewGroup,false);
                        viewHolder1=new ViewHolder1(view);
                        view.setTag(viewHolder1);
                    }
                }
                viewHolder1.text.setText(getItem(3*(i+1)-1).getTitle());
                viewHolder1.text1.setText(getItem(3*(i+1)).getTitle());
                Picasso.with(context)
                        .load(Uri.parse(getItem(3*(i+1)-1)
                                .getCoverPath()))
                        .error(R.drawable.image_default)
                        .into(viewHolder1.image);
                Picasso.with(context)
                        .load(Uri.parse(getItem(3*(i+1))
                                .getCoverPath()))
                        .error(R.drawable.image_default)
                        .into(viewHolder1.image1);
                break;
        }
        return view;
    }

    public void addAll(List<CategoryEntity> dd) {
        list.addAll(dd);
        notifyDataSetChanged();
    }

    class ViewHolder{
        private TextView text,text1,text2,text3;
        private ImageView image,image1,image2,image3;
        public ViewHolder(View view){
            text= (TextView) view.findViewById(R.id.item_category_textView);
            text1= (TextView) view.findViewById(R.id.item_category_textView1);
            text2= (TextView) view.findViewById(R.id.item_category_textView2);
            text3= (TextView) view.findViewById(R.id.item_category_textView3);
            image= (ImageView) view.findViewById(R.id.item_category_imageView);
            image1= (ImageView) view.findViewById(R.id.item_category_imageView1);
            image2= (ImageView) view.findViewById(R.id.item_category_imageView2);
            image3= (ImageView) view.findViewById(R.id.item_category_imageView3);
        }
    }

    class ViewHolder1{
        private TextView text,text1;
        private ImageView image,image1;
        public ViewHolder1(View view){
            text= (TextView) view.findViewById(R.id.item_category1_textView);
            text1= (TextView) view.findViewById(R.id.item_category1_textView1);
            image= (ImageView) view.findViewById(R.id.item_category1_imageView);
            image1= (ImageView) view.findViewById(R.id.item_category1_imageView1);
        }
    }

}
