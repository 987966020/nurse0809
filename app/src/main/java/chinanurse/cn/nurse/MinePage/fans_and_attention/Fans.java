package chinanurse.cn.nurse.MinePage.fans_and_attention;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import chinanurse.cn.nurse.R;

public class Fans extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout back;
    private RelativeLayout fans,attention;
    private TextView title_left,title_right,line_left,line_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fans);
        back= (LinearLayout) findViewById(R.id.fans_back);
        fans= (RelativeLayout) findViewById(R.id.fans);
        attention= (RelativeLayout) findViewById(R.id.attention);
        title_left= (TextView) findViewById(R.id.title_left);
        title_right= (TextView) findViewById(R.id.title_right);
        line_left= (TextView) findViewById(R.id.line_left);
        line_right= (TextView) findViewById(R.id.line_right);
        back.setOnClickListener(this);
        fans.setOnClickListener(this);
        attention.setOnClickListener(this);
        FragmentManager fm=getFragmentManager();
        FragmentTransaction t=fm.beginTransaction();
        FansFragment f1=new FansFragment();
        t.replace(R.id.fm_content, f1);
        t.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fans_back:
                finish();
                break;
            case R.id.fans:
                //设置字体颜色和对应的下划线颜色
                title_left.setTextColor(getResources().getColor(R.color.indicator));
                line_left.setBackgroundColor(getResources().getColor(R.color.indicator));
                line_right.setBackgroundColor(getResources().getColor(R.color.white));
                title_right.setTextColor(getResources().getColor(R.color.mine_gray_unselected));
                FragmentManager fm=getFragmentManager();
                FragmentTransaction t=fm.beginTransaction();
                FansFragment f1=new FansFragment();
                t.replace(R.id.fm_content, f1);
                t.commit();
                break;
            case R.id.attention:
                //设置字体颜色和对应的下划线颜色
                line_left.setBackgroundColor(getResources().getColor(R.color.white));
                title_left.setTextColor(getResources().getColor(R.color.mine_gray_unselected));
                title_right.setTextColor(getResources().getColor(R.color.indicator));
                line_right.setBackgroundColor(getResources().getColor(R.color.indicator));
                FragmentManager fm2=getFragmentManager();
                FragmentTransaction t2=fm2.beginTransaction();
                AttentionFragment f2=new AttentionFragment();
                t2.replace(R.id.fm_content, f2);
                t2.commit();
                break;
        }
    }
}
