package chinanurse.cn.nurse.NursePage;

import android.app.Activity;
import android.view.View;

import chinanurse.cn.nurse.Base.Basepage;
import chinanurse.cn.nurse.R;

/**
 * Created by Administrator on 2016/6/12.
 */
public class Nurse_SecondPage extends Basepage {
    public Nurse_SecondPage(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view=View.inflate(mactivity, R.layout.nurse_firstfragment_secondpage,null);
        return view;
    }

    @Override
    public void initData() {

    }
}
