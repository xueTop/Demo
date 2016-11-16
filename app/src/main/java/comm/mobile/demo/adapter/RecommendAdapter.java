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
import comm.mobile.demo.bean.Recommend;

/**
 * Created by Administrator on 2016/11/10.
 */
public class RecommendAdapter extends BaseAdapter {

    private static final int TYPE1=0;
    private static final int TYPE2=1;
    private LayoutInflater inflater;
    private Context context;
    private List<Object> datas;

    public RecommendAdapter(Context context) {
        this.inflater=LayoutInflater.from(context);
        this.context=context;
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
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int result=0;
        if(datas.get(position) instanceof Recommend.EditorRecommendAlbumsBean){
            result=TYPE1;
        }else if(datas.get(position) instanceof Recommend.SpecialColumnBean){
            result=TYPE2;
        }


        return result;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder1 holder1;
        ViewHolder2 holder2;

        switch (getItemViewType(i)) {
            case TYPE1:
                Recommend.EditorRecommendAlbumsBean item= (Recommend.EditorRecommendAlbumsBean) getItem(i);
                if(view == null){
                    view=inflater.inflate(R.layout.item_recommend1,viewGroup,false);
                    holder1=new ViewHolder1(view);
                    view.setTag(holder1);
                }else {
                    if(view.getTag() instanceof  ViewHolder1){
                        holder1= (ViewHolder1) view.getTag();
                    }else {
                        view=inflater.inflate(R.layout.item_recommend1,viewGroup,false);
                        holder1=new ViewHolder1(view);
                        view.setTag(holder1);
                    }
                }

                holder1.outTitle.setText(item.getTitle());
                Recommend.EditorRecommendAlbumsBean.ListBean ed = item.getList().get(0);
                Recommend.EditorRecommendAlbumsBean.ListBean ed1 = item.getList().get(1);
                Recommend.EditorRecommendAlbumsBean.ListBean ed2 = item.getList().get(2);
                //1
                holder1.title.setText(ed.getTitle());
                holder1.trackTitle.setText(ed.getTrackTitle());
                String coverURL=ed.getCoverLarge();
                if(coverURL != null){
                   Picasso
                           .with(context)
                           .load(Uri.parse(coverURL))
                           .error(R.drawable.myspin_image_default_album_s)
                           .placeholder(R.drawable.myspin_image_default_album_s)
                           .into(holder1.cover);
                }
                //2
                holder1.title1.setText(ed1.getTitle());
                holder1.trackTitle1.setText(ed1.getTrackTitle());
                String coverURL1=ed1.getCoverLarge();
                if(coverURL1 != null){
                    Picasso
                            .with(context)
                            .load(Uri.parse(coverURL1))
                            .error(R.drawable.myspin_image_default_album_s)
                            .placeholder(R.drawable.myspin_image_default_album_s)
                            .into(holder1.cover1);
                }
                //3
                holder1.title2.setText(ed2.getTitle());
                holder1.trackTitle2.setText(ed2.getTrackTitle());
                String coverURL2=ed2.getCoverLarge();
                if(coverURL2 != null){
                    Picasso
                            .with(context)
                            .load(Uri.parse(coverURL2))
                            .error(R.drawable.myspin_image_default_album_s)
                            .placeholder(R.drawable.myspin_image_default_album_s)
                            .into(holder1.cover2);
                }
                break;

            case TYPE2:

                Recommend.SpecialColumnBean item1= (Recommend.SpecialColumnBean) getItem(i);

                if(view == null){
                    view=inflater.inflate(R.layout.item_recommend2,viewGroup,false);
                    holder2=new ViewHolder2(view);
                    view.setTag(holder2);
                }else {
                    if(view.getTag() instanceof  ViewHolder2){
                        holder2= (ViewHolder2) view.getTag();
                    }else {
                        view=inflater.inflate(R.layout.item_recommend2,viewGroup,false);
                        holder2=new ViewHolder2(view);
                        view.setTag(holder2);
                    }
                }

                Recommend.SpecialColumnBean.ListBean listBean = item1.getList().get(0);
                Recommend.SpecialColumnBean.ListBean listBean1 = item1.getList().get(1);
                holder2.outTitle.setText(item1.getTitle());
                //1
                holder2.title.setText(listBean.getTitle());
                holder2.subTitle.setText(listBean.getSubtitle());
                holder2.footnote.setText(listBean.getFootnote());
                String pathURL=listBean.getCoverPath();
                if(pathURL != null){
                    Picasso
                            .with(context)
                            .load(Uri.parse(pathURL))
                            .error(R.drawable.myspin_image_default_album_s)
                            .placeholder(R.drawable.myspin_image_default_album_s)
                            .into(holder2.coverPath);
                }
                //2
                holder2.title1.setText(listBean1.getTitle());
                holder2.subTitle1.setText(listBean1.getSubtitle());
                holder2.footnote1.setText(listBean1.getFootnote());
                String pathURL1=listBean1.getCoverPath();
                if(pathURL1 != null){
                    Picasso
                            .with(context)
                            .load(Uri.parse(pathURL1))
                            .error(R.drawable.myspin_image_default_album_s)
                            .placeholder(R.drawable.myspin_image_default_album_s)
                            .into(holder2.coverPath1);
                }

                break;
        }
        return view;
    }

    public void addAll(Recommend.EditorRecommendAlbumsBean list) {
        datas.add(list);
    }

    public void addAll1(Recommend.SpecialColumnBean list1) {
        datas.add(list1);
    }


    class ViewHolder1{

        private TextView outTitle,title,trackTitle,title1,trackTitle1,title2,trackTitle2;
        private ImageView cover,cover1,cover2;

        public ViewHolder1(View view){
            outTitle= (TextView) view.findViewById(R.id.item_recommend1_textViewOutTitle);
            title= (TextView) view.findViewById(R.id.item_recommend1_title);
            trackTitle= (TextView) view.findViewById(R.id.item_recommend1_trackTitle);
            cover= (ImageView) view.findViewById(R.id.item_recommend1_coverMiddle);
            title1= (TextView) view.findViewById(R.id.item_recommend1_title1);
            trackTitle1= (TextView) view.findViewById(R.id.item_recommend1_trackTitle1);
            cover1= (ImageView) view.findViewById(R.id.item_recommend1_coverMiddle1);
            title2= (TextView) view.findViewById(R.id.item_recommend1_title2);
            trackTitle2= (TextView) view.findViewById(R.id.item_recommend1_trackTitle2);
            cover2= (ImageView) view.findViewById(R.id.item_recommend1_coverMiddle2);
        }
    }

    class ViewHolder2{

        private TextView outTitle,title,subTitle,footnote,title1,subTitle1,footnote1;
        private ImageView coverPath,coverPath1;

        public ViewHolder2(View view) {
            outTitle = (TextView) view.findViewById(R.id.item_recommend2_textViewTitle);
            title= (TextView) view.findViewById(R.id.item_recommend2_title);
            subTitle= (TextView) view.findViewById(R.id.item_recommend2_subtitle);
            footnote= (TextView) view.findViewById(R.id.item_recommend2_footnote);
            coverPath= (ImageView) view.findViewById(R.id.item_recommend2_CoverPath);
            title1= (TextView) view.findViewById(R.id.item_recommend2_title1);
            subTitle1= (TextView) view.findViewById(R.id.item_recommend2_subtitle1);
            footnote1= (TextView) view.findViewById(R.id.item_recommend2_footnote1);
            coverPath1= (ImageView) view.findViewById(R.id.item_recommend2_CoverPath1);
        }
    }

}
