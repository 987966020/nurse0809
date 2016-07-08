package chinanurse.cn.nurse.HttpConn.request;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import chinanurse.cn.nurse.HttpConn.HttpConnect;
import chinanurse.cn.nurse.UrlPath.UrlPath;

/**
 * Created by wzh on 2016/6/19.
 */
public class StudyRequest {
    private Context mContext;
    private Handler handler;

    public StudyRequest(Context context, Handler handler) {
        super();
        this.mContext = context;
        this.handler = handler;

//    public void facilityList() {
//        new Thread() {
//            Message msg = Message.obtain();
//
//            public void run() {
//                String data = "";
////                String result_data = NetUtil.getResponse(WebAddress.FACILITY_LIST, data);
////                try {
////                    JSONObject obj = new JSONObject(result_data);
////                    msg.what = CommunalInterfaces.FACILITY_LIST;
////                    msg.obj = obj;
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                } finally {
////                    handler.sendMessage(msg);
////                }
////            }
////        }.start();
//    }
    }

    /**
     * 获取首页轮播图片
     *
     * @param typeid
     * @param KEY
     */
    public void getHttpImage(final String typeid,final int KEY) {
        new Thread() {
            Message msg = Message.obtain();

            public void run() {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("g","apps"));
                params.add(new BasicNameValuePair("m","index"));
                params.add(new BasicNameValuePair("typeid",typeid));
                String result = HttpConnect.getResponseForPost(UrlPath.news_title_list, params, mContext);
                Log.i("result","------------->"+result);
                msg.what = KEY;
                msg.obj = result;
                handler.sendMessage(msg);
            };
        }.start();
    }
    /**
     *获取资讯文章列表
     * @param channelid
     * @param KEY
     */
    public void getNewsList (final String channelid,final int KEY){
        new Thread(){
            Message msg = Message.obtain();

            @Override
            public void run() {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("channelid",channelid));
                String result = HttpConnect.getResponseForPost(UrlPath.news_list,params,mContext);
                msg.what = KEY;
                msg.obj = result;
                handler.sendMessage(msg);
                Log.i("resultlist", "------------->" + result);
            }
        }.start();
    }
    /**
     *获取新闻相关文章列表
     * @param refid
     * @param KEY
     */
    public void getNewsListAbout (final String refid,final int KEY){
        new Thread(){
            Message msg = Message.obtain();

            @Override
            public void run() {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("refid",refid));
                String result = HttpConnect.getResponseForPost(UrlPath.news_list_about,params,mContext);
                msg.what = KEY;
                msg.obj = result;
                handler.sendMessage(msg);
                Log.i("resultlistabout","------------->"+result);
            }
        }.start();
    }
}
