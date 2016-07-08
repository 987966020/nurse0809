package chinanurse.cn.nurse.MinePage.Myrecruit;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import chinanurse.cn.nurse.MinePage.fans_and_attention.FansFragment;
import chinanurse.cn.nurse.R;

public class Myrecruit extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout back;
    private RelativeLayout left,center,right;
    private TextView text_left,text_center,text_right;
    private View line_left,line_center,line_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrecruit);
        back= (LinearLayout) findViewById(R.id.myrecruit_back);
        left= (RelativeLayout) findViewById(R.id.myrecruit_left);
        center= (RelativeLayout) findViewById(R.id.myrecruit_center);
        right= (RelativeLayout) findViewById(R.id.myrecruit_right);
        text_left= (TextView) findViewById(R.id.text_left);
        text_center= (TextView) findViewById(R.id.text_center);
        text_right= (TextView) findViewById(R.id.text_right);
        line_left=findViewById(R.id.line_left);
        line_center=findViewById(R.id.line_center);
        line_right=findViewById(R.id.line_right);
        left.setOnClickListener(this);
        center.setOnClickListener(this);
        right.setOnClickListener(this);
        back.setOnClickListener(this);
        FragmentManager fm=getFragmentManager();
        FragmentTransaction t=fm.beginTransaction();
        GetresumeFragment f=new GetresumeFragment();
        t.replace(R.id.fm_content, f);
        t.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myrecruit_back:
                finish();
                break;
            case R.id.myrecruit_left:
                init();
                text_left.setTextColor(getResources().getColor(R.color.indicator));
                line_left.setBackgroundColor(getResources().getColor(R.color.indicator));
                FragmentManager fm1=getFragmentManager();
                FragmentTransaction t1=fm1.beginTransaction();
                GetresumeFragment f1=new GetresumeFragment();
                t1.replace(R.id.fm_content, f1);
                t1.commit();
                break;
            case R.id.myrecruit_center:
                init();
                text_center.setTextColor(getResources().getColor(R.color.indicator));
                line_center.setBackgroundColor(getResources().getColor(R.color.indicator));
                FragmentManager fm2=getFragmentManager();
                FragmentTransaction t2=fm2.beginTransaction();
                RecruitlistFragment f2=new RecruitlistFragment();
                t2.replace(R.id.fm_content, f2);
                t2.commit();
                break;
            case R.id.myrecruit_right:
                init();
                text_right.setTextColor(getResources().getColor(R.color.indicator));
                line_right.setBackgroundColor(getResources().getColor(R.color.indicator));
                FragmentManager fm3=getFragmentManager();
                FragmentTransaction t3=fm3.beginTransaction();
                IdentityFragment f3=new IdentityFragment();
                t3.replace(R.id.fm_content, f3);
                t3.commit();
                break;
        }
    }
    public void init(){
        text_left.setTextColor(getResources().getColor(R.color.gray4));
        text_center.setTextColor(getResources().getColor(R.color.gray4));
        text_right.setTextColor(getResources().getColor(R.color.gray4));
        line_left.setBackgroundColor(getResources().getColor(R.color.white));
        line_center.setBackgroundColor(getResources().getColor(R.color.white));
        line_right.setBackgroundColor(getResources().getColor(R.color.white));
    }
}
