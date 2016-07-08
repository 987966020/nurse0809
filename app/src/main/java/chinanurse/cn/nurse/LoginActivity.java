package chinanurse.cn.nurse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class LoginActivity extends AppCompatActivity {

    private RadioGroup mRadioGroup;
    private FrameLayout mFrame;
    private RadioButton mRadiobutton;
    private Button bu_login;
    private Button bu_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mRadioGroup = (RadioGroup) findViewById(R.id.login_radio);
        mFrame = (FrameLayout) findViewById(R.id.login_frag);
        mRadiobutton = (RadioButton) findViewById(R.id.login_mlogin);
        //默认登录按钮被选中
        mRadiobutton.setChecked(true);
        //默认加载登录界面
        initView(R.layout.login_login);
        //登录按钮
        login();
        //设置RadioGroup的点击事件，进行切换界面
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    //切换登录按钮，
                    case R.id.login_mlogin:
                        //切换登录界面
                        initView(R.layout.login_login);
                        login();
                        break;
                    case R.id.login_mregist:
                        //切换注册界面
                        initView(R.layout.login_regist);
                        break;
                }
            }
        });


    }

    /*
    *Framlayout添加布局
     */
    public void initView(int mLayout) {
        View mView = View.inflate(getApplication(), mLayout, null);
        mFrame.removeAllViews();
        mFrame.addView(mView);
        //登录按钮初始化呢
        bu_login = (Button) mView.findViewById(R.id.login_regist_login);
        //注册按钮初始化
        bu_regist = (Button) mView.findViewById(R.id.login_regist_submit);
    }

    public void login() {
        bu_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
