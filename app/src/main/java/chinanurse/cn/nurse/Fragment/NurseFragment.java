package chinanurse.cn.nurse.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import chinanurse.cn.nurse.NurseFragment.FirstFragment;
import chinanurse.cn.nurse.NurseFragment.SecondFragment;
import chinanurse.cn.nurse.R;

/**
 * Created by Administrator on 2016/6/2.
 */
public class NurseFragment extends Fragment {

    private RadioGroup nurse_rg;
    private RadioButton nurse_rb1, nurse_rb2;
    private FrameLayout nurse_frame;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //  进入界面，默认社区按钮选中
        nurse_rb1.setChecked(true);
        //默认显示第一个fragment
        initFragment(new FirstFragment());
        //设置RadioGroup的点击事件
        nurse_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.nurse_rb1:
                        initFragment(new FirstFragment());
                        break;
                    case R.id.nurse_rb2:
                        initFragment(new SecondFragment());
                        break;
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View mView = View.inflate(getContext(), R.layout.nursefragment, null);
        nurse_rg = (RadioGroup) mView.findViewById(R.id.nurse_rg);
        nurse_rb1 = (RadioButton) mView.findViewById(R.id.nurse_rb1);
        nurse_frame = (FrameLayout) mView.findViewById(R.id.nurse_frame);
        return mView;
    }

    /**
     * 初始化fragment
     **/
    public void initFragment(Fragment mFragment){

        android.support.v4.app.FragmentManager fm=getActivity().getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.nurse_frame, mFragment);
        ft.commit();

    }
}
