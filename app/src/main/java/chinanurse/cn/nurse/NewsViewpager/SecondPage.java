package chinanurse.cn.nurse.NewsViewpager;

import android.app.Activity;
import android.view.View;

import chinanurse.cn.nurse.Base.Basepage;
import chinanurse.cn.nurse.R;

public class SecondPage extends Basepage {

    public SecondPage(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view=View.inflate(mactivity, R.layout.activity_second_page,null);
        return view;
    }

    @Override
    public void initData() {

    }
}
