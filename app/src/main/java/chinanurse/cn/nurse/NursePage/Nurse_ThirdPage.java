package chinanurse.cn.nurse.NursePage;

import android.app.Activity;
import android.view.View;

import chinanurse.cn.nurse.Base.Basepage;
import chinanurse.cn.nurse.R;

/**
 * Created by Administrator on 2016/6/12.
 */
public class Nurse_ThirdPage extends Basepage {
    public Nurse_ThirdPage(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view=View.inflate(mactivity, R.layout.nurse_firstfragment_thirdpage,null);
        return view;
    }

    @Override
    public void initData() {

    }
}
