package chinanurse.cn.nurse.HttpConn;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import chinanurse.cn.nurse.UrlPath.UrlPath;

/**
 * Created by Administrator on 2016/6/6.
 */
public class HttpConnect {

    //是否连接网络
    public static boolean isConnnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != connectivityManager) {
            NetworkInfo networkInfo[] = connectivityManager.getAllNetworkInfo();

            if (null != networkInfo) {
                for (NetworkInfo info : networkInfo) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        Log.e("检查网络", "the net is ok");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
    获取新闻分类列表
     */
    public static String conn_new_first() {
        String parh = UrlPath.news_firstpage + "&parentid=1";
        String result = getHttp(parh);
        return result;
    }
    /*
    获取文章资讯列表
    */

    public static String getNewslist(String channelid) {
        String parh = UrlPath.news_list + "channelid=" + channelid;
        String result = getHttp(parh);
        Log.e("result", result);
        return result;
    }

    /*
    获取新闻界面资讯文章的相关文章
     */
    public static String getNewslistAbout(String refid){
      String path=UrlPath.news_list_about+refid;
        String result=getHttp(path);
        return result;
    }
    /*
    获取新闻界面资讯文章的相关文章
     */
    public static String getNewsTitleImage(String typeid){
        String path=UrlPath.news_list_about+typeid;
        String result=getHttp(path);
        return result;
    }
    /*
    连接网络工具类
     */
    public static String getHttp(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(3000);
            int code = con.getResponseCode();
            if (code == 200) {
                InputStream in = con.getInputStream();
               return getHttpMethod(in);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getHttpMethod(InputStream in){

        ByteArrayOutputStream bu = new ByteArrayOutputStream();
        byte[] buffe = new byte[1024];
        int lin;
        try {
            while ((lin = in.read(buffe)) != -1) {
                bu.write(buffe, 0, lin);
            }
            in.close();
            bu.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = new String((bu.toByteArray()));
        return result;
    }



    /**
     //     * 网络可用状态下，通过post方式向server端发送请求，并返回响应数据
     //     *
     //     * @param market_uri
     //     *            请求网址
     //     * @param nameValuePairs
     //     *            参数信息
     //     * @param context
     //     *            上下文
     //     * @return 响应数据
     //     */
    public static String getResponseForPost(String market_uri, List<NameValuePair> nameValuePairs, Context context) {
        if (isConnnected(context)) {
            if (null == market_uri || "".equals(market_uri)) {
                return null;
            }
            HttpPost request = new HttpPost(market_uri);
            try {
                request.setEntity(new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8));
                return getRespose(request);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            } catch (RuntimeException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     //     * 响应客户端请求
     //     *
     //     * @param //
     //     *            客户端请求get/post
     //     * @return 响应数据
     //     */
    private static String getRespose(HttpUriRequest request) {
        try {
            HttpResponse httpResponse = new DefaultHttpClient().execute(request);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK == statusCode) {
                return EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (ConnectTimeoutException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
