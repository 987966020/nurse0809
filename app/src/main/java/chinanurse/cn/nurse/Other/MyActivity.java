package chinanurse.cn.nurse.Other;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyActivity {
    //开启页面
    public static void getIntent(Activity activity,Class c){
        Intent intent=new Intent(activity,c);
        activity.startActivity(intent);
    }
}
