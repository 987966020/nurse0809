package chinanurse.cn.nurse.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TabPageIndicator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import chinanurse.cn.nurse.Base.Basepage;
import chinanurse.cn.nurse.HttpConn.HttpConnect;
import chinanurse.cn.nurse.NewsViewpager.FirstPage;
import chinanurse.cn.nurse.NewsViewpager.FourthPage;
import chinanurse.cn.nurse.NewsViewpager.SecondPage;
import chinanurse.cn.nurse.NewsViewpager.ThirdPage;
import chinanurse.cn.nurse.R;

/**
 * Created by Administrator on 2016/6/2.
 */
public class NewsFragment extends Fragment {

    public TabPageIndicator mTab;
    public ViewPager mViewpager;


    private List<Basepage> mBasepage;//4个viewpager集合
    private List<String> Title;//头标题集合

    private String result_title;//网络获取的标题数据

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    String mTitle = (String) msg.obj;
                    Log.i("newfragment","------------------>"+mTitle);
                    try {
                        //解析JSON数据
                        JSONObject mJson = new JSONObject(mTitle);
                        //。。获取data数组
                        JSONArray mJarray = mJson.getJSONArray("data");
                        for (int i = 0; i < mJarray.length(); i++) {
                            JSONObject temp = (JSONObject) mJarray.get(i);
                            //将数组信息放入头标题集合中
                            Title.add(temp.getString("name"));
                        }
                        //viewpager设置适配器
                        mViewpager.setAdapter(new MyAdapter());
                        //将标题栏与viewpager关联起来
                        mTab.setVisibility(View.VISIBLE);
                        mTab.setViewPager(mViewpager);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View mView = View.inflate(getContext(), R.layout.newsfragment, null);
        mTab = (TabPageIndicator) mView.findViewById(R.id.news_indicator);//初始化标题栏
        mViewpager = (ViewPager) mView.findViewById(R.id.news_viewpager);//初始化Viewpager
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //viewpager子布局设置List
        mBasepage = new ArrayList<>();
        Title = new ArrayList<>();
        //向list添加子布局
        mBasepage.add(new FirstPage(getActivity()));
        mBasepage.add(new SecondPage(getActivity()));
        mBasepage.add(new ThirdPage(getActivity()));
        mBasepage.add(new FourthPage(getActivity()));
        //获取网络资源
        getNews_title();
    }

    /*
    为viewpager设置适配器
     */
    public class MyAdapter extends PagerAdapter {
        //返回头标题集合的数据，
        public CharSequence getPageTitle(int position) {
            return Title.get(position);
        }

        @Override
        public int getCount() {
            return mBasepage.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //return super.instantiateItem(container, position);
            Basepage basepage = mBasepage.get(position);
            container.addView(basepage.mRootView);
            basepage.initData();
            return basepage.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    /*
    获取新闻列表
     */
    public void getNews_title() {
        //开启子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取网络返回的数据
                result_title = HttpConnect.conn_new_first();
                //发送消息机制
                Message message = Message.obtain();
                message.what = 0;
                message.obj = result_title;
                handler.sendMessage(message);
            }
        }) {

        }.start();
    }
}
