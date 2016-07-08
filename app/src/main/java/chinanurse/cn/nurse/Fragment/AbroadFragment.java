package chinanurse.cn.nurse.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import chinanurse.cn.nurse.Base.Basepage;
import chinanurse.cn.nurse.NewsViewpager.AbroadFirstPage;
import chinanurse.cn.nurse.NewsViewpager.AbroadSecondPage;
import chinanurse.cn.nurse.NewsViewpager.AbroadThirdPage;
import chinanurse.cn.nurse.NewsViewpager.FirstPage;
import chinanurse.cn.nurse.NewsViewpager.FourthPage;
import chinanurse.cn.nurse.NewsViewpager.SecondPage;
import chinanurse.cn.nurse.NewsViewpager.ThirdPage;
import chinanurse.cn.nurse.R;

/**
 * Created by Administrator on 2016/6/2.
 */
public class AbroadFragment extends Fragment {
    private TabPageIndicator mTab;
    private ViewPager mViewpager;

    String[] title={"出国动态","成功案例","出国百宝箱"};
    private List<Basepage> mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View mView=View.inflate(getContext(), R.layout.abroadfragment,null);
        mTab = (TabPageIndicator) mView.findViewById(R.id.news_indicator);
        mViewpager = (ViewPager) mView.findViewById(R.id.news_viewpager);
        return mView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //viewpager子布局设置List
        mActivity = new ArrayList<>();
        //添加子布局
        mActivity.add(new AbroadFirstPage(getActivity()));
        mActivity.add(new AbroadSecondPage(getActivity()));
        mActivity.add(new AbroadThirdPage(getActivity()));
        mViewpager.setAdapter(new MyAdapter());
        //viewpager设置适配器
        mTab.setViewPager(mViewpager);

    }
    /*
    为viewpager设置适配器
     */
    public class MyAdapter extends PagerAdapter {

        public CharSequence getPageTitle(int position){
            return title[position];
        }
        @Override
        public int getCount() {
            return mActivity.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //return super.instantiateItem(container, position);
            Basepage basepage=mActivity.get(position);
            container.addView(basepage.mRootView);
            return basepage.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
