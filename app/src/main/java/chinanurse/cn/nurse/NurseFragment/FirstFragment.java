package chinanurse.cn.nurse.NurseFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import chinanurse.cn.nurse.Base.Basepage;
import chinanurse.cn.nurse.NursePage.Nurse_FifthPage;
import chinanurse.cn.nurse.NursePage.Nurse_FirstPage;
import chinanurse.cn.nurse.NursePage.Nurse_FourthPage;
import chinanurse.cn.nurse.NursePage.Nurse_SecondPage;
import chinanurse.cn.nurse.NursePage.Nurse_ThirdPage;
import chinanurse.cn.nurse.R;

/**
 * Created by Administrator on 2016/6/12.
 */
public class FirstFragment extends Fragment {
    String[] title = {"全部", "精华", "内科", "外科", "妇产科"};
    private TabPageIndicator nurse_indicator;
    private ViewPager nurse_vp;
    private List<Basepage> baseList;
    private ListView nurse_listview;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        baseList = new ArrayList<>();
        baseList.add(new Nurse_FirstPage(getActivity()));
        baseList.add(new Nurse_SecondPage(getActivity()));
        baseList.add(new Nurse_ThirdPage(getActivity()));
        baseList.add(new Nurse_FourthPage(getActivity()));
        baseList.add(new Nurse_FifthPage(getActivity()));
        nurse_vp.setAdapter(new MyAdapter());
        nurse_indicator.setVisibility(View.VISIBLE);
        nurse_indicator.setViewPager(nurse_vp);
        nurse_listview.setAdapter(new LvAdapter());
        //解决listview与scroview冲突
        setListViewHeightBasedOnChildren(nurse_listview);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = View.inflate(getContext(), R.layout.nurse_fisr_fragment, null);
        //初始化标题栏
        nurse_indicator = (TabPageIndicator) mView.findViewById(R.id.nurse_indicator);
        //初始化viewpager
        nurse_vp = (ViewPager) mView.findViewById(R.id.nurse_vp);
        //初始化listview
        nurse_listview = (ListView) mView.findViewById(R.id.nurse_firstfrag_lv);
        return mView;
    }

    /*
    设置viewpager适配器
     */

    public class MyAdapter extends PagerAdapter {
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public int getCount() {
            return baseList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //填充布局
            Basepage basenurse = baseList.get(position);
            container.addView(basenurse.mRootView);
            return basenurse.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    /*
    设置listview适配器
     */
    public class LvAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //填充布局
            View view = View.inflate(getContext(), R.layout.nurse_firstfrag_lv_item, null);
            return view;
        }
    }

    /*
       解决scrollview下listview显示不全
     */
    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }
}
