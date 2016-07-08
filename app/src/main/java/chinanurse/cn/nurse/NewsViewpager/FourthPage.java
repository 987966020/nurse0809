package chinanurse.cn.nurse.NewsViewpager;

import android.app.Activity;
import android.view.View;

import chinanurse.cn.nurse.Base.Basepage;
import chinanurse.cn.nurse.R;

public class FourthPage extends Basepage {


    public FourthPage(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view=View.inflate(mactivity, R.layout.news_conference,null);
        return view;
    }

    @Override
    public void initData() {

    }
}
