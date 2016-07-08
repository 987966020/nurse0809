package chinanurse.cn.nurse.NewsViewpager;

import android.app.Activity;
import android.view.View;

import chinanurse.cn.nurse.Base.Basepage;
import chinanurse.cn.nurse.R;

public class AbroadFirstPage extends Basepage {


    public AbroadFirstPage(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view=View.inflate(mactivity, R.layout.abroad_first,null);
        return view;
    }

    @Override
    public void initData() {

    }
}
