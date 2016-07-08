package chinanurse.cn.nurse.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

import chinanurse.cn.nurse.R;
import chinanurse.cn.nurse.WebView.News_WebView;
import chinanurse.cn.nurse.bean.FirstPageNews;
import chinanurse.cn.nurse.imageload.MyApplication;

/**
 * Created by Administrator on 2016/6/22.
 */
public class News_Down_Adapter extends BaseAdapter{
    //解析图片第三方初始化
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private Activity mactivity;
    private ArrayList<FirstPageNews.FirstNewsData> fndlist;
    private int typeid;

    public News_Down_Adapter(Activity mactivity,ArrayList<FirstPageNews.FirstNewsData> fndlist,int typeid) {
        this.fndlist = fndlist;
        this.mactivity = mactivity;
        this.typeid = typeid;
    }

    @Override
    public int getCount() {
        return fndlist.size();
    }

    @Override
    public Object getItem(int position) {
        return fndlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        int layoutType = getItemViewType(position);
        CommonViewHolder commonHolder = null;
        LayoutInflater inflater = null;
        if (convertView == null) {
            switch (typeid) {
                case 0:
                    inflater = (LayoutInflater) mactivity.getSystemService(mactivity.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.news_first_lv_item, null);
                    commonHolder = new CommonViewHolder();
                    commonHolder.lv_title = (TextView) convertView.findViewById(R.id.lv_titile);
                    commonHolder.lv_refad = (TextView) convertView.findViewById(R.id.lv_read);
                    commonHolder.lv_time = (TextView) convertView.findViewById(R.id.lv_time);
                    commonHolder.lv_content = (TextView) convertView.findViewById(R.id.lv_content);
                    commonHolder.lv_image = (ImageView) convertView.findViewById(R.id.lv_image);
                    commonHolder.lv_LL_title = (LinearLayout) convertView.findViewById(R.id.linearlayout_title_list);
                    break;
                case 1:
                    inflater = (LayoutInflater) mactivity.getSystemService(mactivity.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.news_first_lv_item, null);
                    commonHolder = new CommonViewHolder();
                    commonHolder.lv_title = (TextView) convertView.findViewById(R.id.lv_titile);
                    commonHolder.lv_refad = (TextView) convertView.findViewById(R.id.lv_read);
                    commonHolder.lv_time = (TextView) convertView.findViewById(R.id.lv_time);
                    commonHolder.lv_content = (TextView) convertView.findViewById(R.id.lv_content);
                    commonHolder.lv_image = (ImageView) convertView.findViewById(R.id.lv_image);
                    commonHolder.lv_LL_title = (LinearLayout) convertView.findViewById(R.id.linearlayout_title_list);
                    break;
                }
            }else{
            commonHolder = (CommonViewHolder) convertView.getTag();
        }
        switch (typeid){
            case 0:
                commonHolder.lv_title.setText(fndlist.get(position).getStr_title().toString()+"");
                commonHolder.lv_refad.setText(fndlist.get(position).getStr_read().toString()+"");
                commonHolder.lv_time.setText(fndlist.get(position).getStr_time().toString()+"");
                commonHolder.lv_content.setText(fndlist.get(position).getStr_content().toString()+"");
                //不加这一句会提示：ImageLoader must be init with configuration before 且不显示图片
                MyApplication.imageLoader.init(ImageLoaderConfiguration.createDefault(mactivity));
                //imglist.get(i)为网络图片路径，lv_image为imageview
                ImageLoader.getInstance().displayImage(fndlist.get(position).getStr_img().toString(),commonHolder.lv_image);
                commonHolder.lv_LL_title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getBundle(position,"fndinfo",News_WebView.class,"新闻信息");
                    }
                });
                break;
            case 1:
                commonHolder.lv_title.setText(fndlist.get(position).getStr_title().toString()+"");
                commonHolder.lv_refad.setText(fndlist.get(position).getStr_read().toString()+"");
                commonHolder.lv_time.setText(fndlist.get(position).getStr_time().toString()+"");
                commonHolder.lv_content.setText(fndlist.get(position).getStr_content().toString()+"");
                //不加这一句会提示：ImageLoader must be init with configuration before 且不显示图片
                MyApplication.imageLoader.init(ImageLoaderConfiguration.createDefault(mactivity));
                //imglist.get(i)为网络图片路径，lv_image为imageview
                ImageLoader.getInstance().displayImage(fndlist.get(position).getStr_img().toString(),commonHolder.lv_image);
                break;
        }

        return convertView;
    }
    @SuppressWarnings("rawtypes")
    public void getBundle(final int position, String key, Class clazz, String str) {
        FirstPageNews.FirstNewsData fndData = fndlist.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable(key, fndData);
        Intent intent = new Intent(mactivity, clazz);
        intent.putExtras(bundle);
        mactivity.startActivity(intent);
    }
    static class CommonViewHolder{
        private TextView lv_title,lv_refad,lv_time,lv_content;
        private ImageView lv_image;
        private LinearLayout lv_LL_title;
    }
}
