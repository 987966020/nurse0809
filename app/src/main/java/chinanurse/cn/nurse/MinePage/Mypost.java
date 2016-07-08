package chinanurse.cn.nurse.MinePage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import chinanurse.cn.nurse.R;

public class Mypost extends AppCompatActivity implements View.OnClickListener {
    private ListView listView;
    private LinearLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypost);
        back= (LinearLayout) findViewById(R.id.mypost_back);
        listView= (ListView) findViewById(R.id.lv_content);
        listView.setAdapter(new MyAdapter());
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mypost_back:
                finish();
                break;
        }
    }

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=View.inflate(getApplication(),R.layout.listview_mypost,null);
            return view;
        }
    }
}
