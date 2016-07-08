package chinanurse.cn.nurse.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import chinanurse.cn.nurse.MinePage.Myinfo;
import chinanurse.cn.nurse.MinePage.Mypost;
import chinanurse.cn.nurse.MinePage.Myrecruit.Myrecruit;
import chinanurse.cn.nurse.MinePage.fans_and_attention.Fans;
import chinanurse.cn.nurse.Other.MyActivity;
import chinanurse.cn.nurse.R;

/**
 * Created by Administrator on 2016/6/2.
 */
public class MineFragment extends Fragment implements View.OnClickListener {
    private ImageView setting;
    private LinearLayout fans,attention;
    private RelativeLayout post,myrecruit;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View mView=View.inflate(getContext(), R.layout.minefragment,null);
        setting= (ImageView) mView.findViewById(R.id.mine_setting);
        fans= (LinearLayout) mView.findViewById(R.id.mine_fans);
        attention= (LinearLayout) mView.findViewById(R.id.mine_attention);
        post= (RelativeLayout) mView.findViewById(R.id.mine_post);
        myrecruit= (RelativeLayout) mView.findViewById(R.id.mine_myrecruit);
        myrecruit.setOnClickListener(this);
        post.setOnClickListener(this);
        fans.setOnClickListener(this);
        attention.setOnClickListener(this);
        setting.setOnClickListener(this);
        return mView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_setting:
                //调用自定义方法，跳转页面
                MyActivity.getIntent(getActivity(), Myinfo.class);
                break;
            case R.id.mine_fans:
                MyActivity.getIntent(getActivity(), Fans.class);
                break;
            case R.id.mine_attention:
                MyActivity.getIntent(getActivity(), Fans.class);
                break;
            case R.id.mine_post:
                MyActivity.getIntent(getActivity(), Mypost.class);
                break;
            case R.id.mine_myrecruit:
                MyActivity.getIntent(getActivity(), Myrecruit.class);
                break;
        }
    }
}
