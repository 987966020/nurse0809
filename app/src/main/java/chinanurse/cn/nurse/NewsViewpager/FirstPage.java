package chinanurse.cn.nurse.NewsViewpager;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.viewpagerindicator.CirclePageIndicator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import chinanurse.cn.nurse.Base.Basepage;
import chinanurse.cn.nurse.HttpConn.HttpConnect;
import chinanurse.cn.nurse.HttpConn.request.StudyRequest;
import chinanurse.cn.nurse.Other.SetListview;
import chinanurse.cn.nurse.R;
import chinanurse.cn.nurse.UrlPath.NetBaseConstant;
import chinanurse.cn.nurse.adapter.News_Down_Adapter;
import chinanurse.cn.nurse.adapter.News_Title_Adapter;
import chinanurse.cn.nurse.bean.FirstPageNews;

public class FirstPage extends Basepage {


    private static final int FIRTPAGETITLE = 3;
    private static final int FIRSTPAGELIST = 4;
    private ViewPager news_fisr_vp;
    private List<ImageView> imageList;
    private CirclePageIndicator circlePageIndicator;
    private TextView news_first_title;
    private ListView news_first_lv;
    private SharedPreferences sp;
    //解析图片第三方初始化
    private ImageLoader imageLoader = ImageLoader.getInstance();

    private ArrayList<String> image_url;
    private ArrayList<FirstPageNews.FirstNewsData> fndlist = new ArrayList<>();
    private News_Title_Adapter vp_Adapter;
    private News_Down_Adapter lv_Adapter;
    private String title_image_name;

    private String title_slide = "1";
    private String channelid = "4";

    private String result;
    private int num;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case FIRSTPAGELIST:
                    if (msg.obj != null){
                        String result = (String) msg.obj;
                        JSONObject jsonObject;
                        try {
                            jsonObject = new JSONObject(result);
                            if ("success".equals(jsonObject.optString("status"))) {
                                JSONArray array = jsonObject.getJSONArray("data");
                                if (array != null||array.length()>0){
                                    for (int i = 0; i < array.length(); i++) {
                                        SharedPreferences.Editor editor = sp.edit();
                                        JSONObject data = (JSONObject) array.get(i);
                                        FirstPageNews.FirstNewsData fnd = new FirstPageNews.FirstNewsData();
                                        fnd.setStr_title(data.getString("post_title"));
                                        fnd.setStr_content(data.getString("post_excerpt"));
                                        fnd.setStr_time(data.getString("post_date"));
                                        fnd.setStr_read(data.getString("post_hits"));
                                        fnd.setStr_img(NetBaseConstant.NET_PIC_PREFIX + data.getString("thumb"));
                                        fnd.setStr_source(data.getString("post_source"));
                                        fnd.setObject_id(data.getString("object_id"));
                                        fnd.setPost_like(data.getString("post_like"));
                                        fnd.setTerm_id(data.getString("term_id"));
                                        fnd.setPath(NetBaseConstant.NET_WEB_VIEW + data.getString("object_id"));
                                        fndlist.add(fnd);
//                                //保存文章标题
//                                editor.putString("content_title", str_title);
//                                //保存只有日期，没有时间
//                                editor.putString("content_date", t[0]);
//                                //保存阅读量
//                                editor.putString("content_read", str_read);
//                                //保存来源
//                                editor.putString("content_source", data.getString("post_source"));
//                                //保存点赞量
//                                editor.putInt("content_like", data.getJSONArray("likes").length());
//                                editor.commit();
                                        //保存文章标题
                                        editor.putString("content_title", fnd.getStr_title());
                                        //保存只有日期，没有时间
                                        editor.putString("content_date", fnd.getStr_time());
                                        //保存阅读量
                                        editor.putString("content_read", fnd.getStr_read());
                                        //保存来源
                                        editor.putString("content_source", data.getString("post_source"));
                                        //保存点赞量
                                        editor.putInt("content_like", data.getJSONArray("likes").length());
                                        editor.commit();
                                    }
                                    //设置listview
                                    lv_Adapter = new News_Down_Adapter(mactivity,fndlist,0);
                                    news_first_lv.setAdapter(lv_Adapter);
                                    //解决listview与scroview冲突事件
                                    SetListview.setListViewHeightBasedOnChildren(news_first_lv);
                                }else{

                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }else{

                    }

                case FIRTPAGETITLE:
                    if (msg.obj != null){
                        String result = (String) msg.obj;
                        JSONObject obj;
                        try {
                            obj = new JSONObject(result);
                            if ("success".equals(obj.optString("status"))){
                                JSONArray jasonarray = obj.getJSONArray("data");
                                if (jasonarray != null||jasonarray.length()>0){
                                    JSONObject json;
                                    for (int i = 0;i<jasonarray.length();i++){
                                        json = jasonarray.optJSONObject(i);

                                        String strURL = NetBaseConstant.NET_PIC_PREFIX+json.getString("slide_pic");
                                        //Bitmap img = getUrlImage(strURL);
                                        Log.i("URL", "----------------&&" + strURL);
                                        //imglistfirst.add(img);
                                        title_image_name = json.getString("slide_name");
                                        news_first_title.setText(title_image_name);
                                        image_url.add(strURL);
                                        showImage();
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }
    };

    private void showImage() {
        //设置iamageview集合
        imageList = new ArrayList<>();
        // 给imageview添加资源
        for(int i=0;i<image_url.size();i++){
            ImageView image = new ImageView(mactivity);
            imageLoader.displayImage(image_url.get(i),image);
            imageList.add(image);
        }
        //给viewpager添加适配器
        vp_Adapter = new News_Title_Adapter(mactivity,imageList);
        news_fisr_vp.setAdapter(vp_Adapter);
//        news_fisr_vp.setAdapter(new vp_Adapter());
        //指示器和viewpager关联起来
        circlePageIndicator.setViewPager(news_fisr_vp);
        //设置指示器快照模式
        circlePageIndicator.setSnap(true);
        //当重新进入页面后，将小圆点位置归零
        circlePageIndicator.onPageSelected(0);
        //进入界面默认标题
//        news_first_title.setText("标题1");
        //设置指示器跳转监听器
        circlePageIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                //当指示器跳转时，标题随着改变
//                news_first_title.setText(title[position]);
//                news_first_title.setText(title_image_name);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    public FirstPage(Activity activity) {
        super(activity);
    }
    @Override
    public View initView() {
        image_url = new ArrayList<>();
        View view = View.inflate(mactivity, R.layout.activity_first_page, null);
        sp = mactivity.getSharedPreferences("data", Context.MODE_PRIVATE);
        news_fisr_vp = (ViewPager) view.findViewById(R.id.news_first_vp);
//        imageLoader.init(ImageLoaderConfiguration.createDefault(mactivity));
        circlePageIndicator = (CirclePageIndicator) view.findViewById(R.id.news_first_indicator);
        news_first_title = (TextView) view.findViewById(R.id.tv_title);
        news_first_lv = (ListView) view.findViewById(R.id.news_first_lv);
        return view;
    }
    @Override
    public void initData() {
        if (HttpConnect.isConnnected(mactivity)){
            new StudyRequest(mactivity,handler).getNewsList(channelid,FIRSTPAGELIST);
        }else{
            Toast.makeText(mactivity, R.string.net_erroy, Toast.LENGTH_SHORT).show();
        }
        if(HttpConnect.isConnnected(mactivity)){
            new StudyRequest(mactivity,handler).getHttpImage(title_slide,FIRTPAGETITLE);
        }else{
            Toast.makeText(mactivity,  R.string.net_erroy, Toast.LENGTH_SHORT).show();
        }

    }
}
