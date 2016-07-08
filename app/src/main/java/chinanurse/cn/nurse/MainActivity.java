package chinanurse.cn.nurse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import chinanurse.cn.nurse.Fragment.AbroadFragment;
import chinanurse.cn.nurse.Fragment.MineFragment;
import chinanurse.cn.nurse.Fragment.NewsFragment;
import chinanurse.cn.nurse.Fragment.NurseFragment;
import chinanurse.cn.nurse.Fragment.StudyFragment;

public class MainActivity extends AppCompatActivity {


    private RadioGroup mRadio;
    private RadioButton mRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadio = (RadioGroup) findViewById(R.id.group);
        mRadioButton = (RadioButton) findViewById(R.id.rb1);
        //设置默认选择
        mRadioButton.setChecked(true);
        //初始化布局
        initFragment(new NewsFragment());
        //设置RadioGroup的点击事件
        mRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        initFragment(new NewsFragment());
                        break;
                    case R.id.rb2:
                        initFragment(new StudyFragment());
                        break;
                    case R.id.rb3:
                        initFragment(new AbroadFragment());
                        break;
                    case R.id.rb4:
                        initFragment(new NurseFragment());
                        break;
                    case R.id.rb5:
                        initFragment(new MineFragment());
                        break;
                }
            }
        });
    }
    /**
     * 初始化fragment
     **/
    public void initFragment(Fragment mFragment){

        android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_fragment, mFragment);
        ft.commit();

    }
}
