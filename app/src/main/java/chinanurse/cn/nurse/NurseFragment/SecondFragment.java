package chinanurse.cn.nurse.NurseFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chinanurse.cn.nurse.R;

/**
 * Created by Administrator on 2016/6/12.
 */
public class SecondFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = View.inflate(getContext(), R.layout.nurse_employment_main, null);
        return mView;
    }
}
