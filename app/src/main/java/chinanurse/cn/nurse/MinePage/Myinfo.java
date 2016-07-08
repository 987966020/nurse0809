package chinanurse.cn.nurse.MinePage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import chinanurse.cn.nurse.Other.MyActivity;
import chinanurse.cn.nurse.R;

public class Myinfo extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);
        back= (LinearLayout) findViewById(R.id.myinfo_back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myinfo_back:
                finish();
                break;

        }
    }
}
