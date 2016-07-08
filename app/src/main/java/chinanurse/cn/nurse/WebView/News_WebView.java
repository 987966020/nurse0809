package chinanurse.cn.nurse.WebView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import chinanurse.cn.nurse.HttpConn.HttpConnect;
import chinanurse.cn.nurse.HttpConn.request.StudyRequest;
import chinanurse.cn.nurse.Other.SetListview;
import chinanurse.cn.nurse.R;
import chinanurse.cn.nurse.UrlPath.NetBaseConstant;
import chinanurse.cn.nurse.adapter.News_Down_Adapter;
import chinanurse.cn.nurse.bean.FirstPageNews;
import chinanurse.cn.nurse.bean.FirstPageNews.FirstNewsData;
//import chinanurse.cn.nurse.bean.FirstPageNews.FirstNewsData;

public class News_WebView extends Activity implements View.OnClickListener {
    private static final int FIRSTPAGELIST_ABOUT = 1;
    private Activity mactivity;
    private WebView webView;
    private ListView web_list;
    private TextView web_title, web_from, web_read, web_time, web_like, web_back;
    private Intent intent;
    private String result;
    private String refid = "1";
    private static final int ISREFRESH = 2;
    private String title,time,read,source,like,webId,webview;
    //    private ArrayList<String> title_list;
//    private ArrayList<String> read_list;
//    private ArrayList<String> time_list;
//    private ArrayList<String> content_list;
//    private ArrayList<String> picture_list;
    private ArrayList<FirstPageNews.FirstNewsData> News_list = new ArrayList<>();
    private FirstNewsData fndData;
    private News_Down_Adapter news_down_adapter;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case FIRSTPAGELIST_ABOUT:
                if (msg.obj != null) {
                    String result = (String) msg.obj;
                    News_list.clear();
                    try {
                        JSONObject json = new JSONObject(result);
                        //提取status数值
                        String status = json.getString("status");
                        //判断status数值，如果等于success，进行相关处理
                        if (status.equals("success")) {
                            //提取data数组
                            JSONArray data = json.getJSONArray("data");
                            for (int i = 0; i < data.length(); i++) {
                                FirstPageNews.FirstNewsData firstEntity = new FirstPageNews.FirstNewsData();
                                JSONObject data_json = data.getJSONObject(i);
                                //获取data中文章头标题并保存如list中
                                firstEntity.setStr_title(data_json.getString("post_title"));
                                firstEntity.setStr_time(data_json.getString("post_date"));
                                firstEntity.setStr_read(data_json.getString("post_hits"));//阅读量
                                firstEntity.setStr_content(data_json.getString("post_excerpt"));//内容
                                firstEntity.setStr_img(NetBaseConstant.NET_PIC_PREFIX+ data_json.getString("thumb"));
                                firstEntity.setStr_source(data_json.getString("post_source"));
                                firstEntity.setObject_id(data_json.getString("object_id"));
                                firstEntity.setPost_like(data_json.getString("post_like"));
                                firstEntity.setTerm_id(data_json.getString("term_id"));
                                firstEntity.setPath(NetBaseConstant.NET_WEB_VIEW + data_json.getString("object_id"));
                                News_list.add(firstEntity);
//                        title_list.add(data_json.getString("post_title"));
                                //获取文章阅读量并保存如list中
//                        read_list.add(data_json.getString("post_hits"));
                                //获取文章发表时间
//                        String str_time = data_json.getString("post_date");
                                //将发表时间中日期和时间剥离开
//                        String t[] = str_time.split(" ");
                                //将发表时间保存如数组
//                        time_list.add(t[1]);
                                //获取文章主体内容地址并保存如list中
//                        content_list.add(data_json.getString("post_excerpt"));
                                //获取文章图片地址并保存如list中
//                        picture_list.add("http://nurse.xiaocool.net/" + data_json.getString("thumb"));
                            }
                            //listview添加适配器
                            news_down_adapter = new News_Down_Adapter(mactivity,News_list,1);
                            web_list.setAdapter(news_down_adapter);
                            news_down_adapter.notifyDataSetChanged();
                            //解决listview与scroview冲突事件
                            SetListview.setListViewHeightBasedOnChildren(web_list);
                        } else {
                            Toast.makeText(getApplicationContext(), R.string.net_erroy, Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(News_WebView.this,R.string.no_information,Toast.LENGTH_SHORT).show();
                }
                    break;
                case ISREFRESH:
                    web_title.setText(title);//设置文章标题
                    web_from.setText(source);//设置文章来源
                    web_read.setText(read);//设置文章阅读量
                    web_time.setText(time);//设置文章时间
                    web_like.setText(like);//设置文章点赞量
                    if (HttpConnect.isConnnected(mactivity)){
                        new StudyRequest(mactivity,handler).getNewsListAbout(webId,FIRSTPAGELIST_ABOUT);
                    }else{
                        Toast.makeText(mactivity,R.string.net_erroy,Toast.LENGTH_SHORT).show();
                    }
                    refreshWebView();

                    break;
            }
        }
    };

    private void refreshWebView() {
            //WebView加载web资源
//        fndData.getPath()
            webView.loadUrl(webview);
            Log.i("webview","-------------->"+webview);
            //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    // TODO Auto-generated method stub
                    //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                    view.loadUrl(url);
                    return true;
                }
            });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__web_view);
        mactivity = this;
        //初始化intent，提取其中传递的值
        intent = getIntent();
        fndData = (FirstNewsData) intent.getSerializableExtra("fndinfo");
        webView = (WebView) findViewById(R.id.web_webview);
        web_list = (ListView) findViewById(R.id.web_lv);
        //初始化返回按钮
        web_back = (TextView) findViewById(R.id.web_back);
        web_back.setOnClickListener(this);
        //初始化文章来源地
        web_from = (TextView) findViewById(R.id.web_from);
        //初始化文章阅读量
        web_read = (TextView) findViewById(R.id.web_read);
        //初始化文章标题
        web_title = (TextView) findViewById(R.id.web_title);
        //初始化文章时间
        web_time = (TextView) findViewById(R.id.web_time);
        //初始化文章点赞量
        web_like = (TextView) findViewById(R.id.web_ok);
        if (fndData != null){
            web_title.setText(fndData.getStr_title().toString());//设置文章标题
            web_from.setText(fndData.getStr_source().toString());//设置文章来源
            web_read.setText(fndData.getStr_read().toString());//设置文章阅读量
            web_time.setText(fndData.getStr_time().toString());//设置文章时间
            web_like.setText(fndData.getPost_like().toString());//设置文章点赞量
        }else{
            Toast.makeText(mactivity,"没有新内容",Toast.LENGTH_SHORT).show();
        }
        web_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //标题
                title = News_list.get((int) id).getStr_title().toString();
                //来源
                source = News_list.get((int) id).getStr_source().toString();
                //阅读量
                read = News_list.get((int) id).getStr_read().toString();
                //发布时间
                time = News_list.get((int) id).getStr_time().toString();
                //点赞量
                like = News_list.get((int) id).getPost_like().toString();
                //获取当前页面的id值
                webId = News_list.get((int) id).getTerm_id().toString();
                //获取webview地址
                webview = News_list.get((int) id).getPath().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = Message.obtain();
                        msg.what=ISREFRESH;
                        handler.sendMessage(msg);
                    }
                }).start();
            }
        });
        //内嵌浏览器
        gotoweb();
        //开启子线程，获取网络数据
        getAboutList();
    }

    /*
    开启子线程，获取网络数据
     */
    public void getAboutList() {
        if (HttpConnect.isConnnected(mactivity)){
            new StudyRequest(mactivity,handler).getNewsListAbout(fndData.getTerm_id(),FIRSTPAGELIST_ABOUT);
        }else{
            Toast.makeText(mactivity,R.string.net_erroy,Toast.LENGTH_SHORT).show();
        }
    }

    /*
   内嵌浏览器
     */
    private void gotoweb() {
        //WebView加载web资源
//        fndData.getPath()
         webView.loadUrl(fndData.getPath());
        Log.i("webview","-------------->"+fndData.getPath());
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }
    /*
    返回按钮点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击返回按钮,finish()掉本页面，显示上一页
            case R.id.web_back:
                finish();
                break;
        }
    }
}
