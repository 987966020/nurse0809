package chinanurse.cn.nurse.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
public class News_Title_Adapter extends PagerAdapter{
    private List<ImageView> titlevplist;
    private Activity mactivity;
    public News_Title_Adapter(Activity mactivity,List<ImageView> titlevplist){
        this.titlevplist = titlevplist;
        this.mactivity = mactivity;
    }
    @Override
    public int getCount() {
        return titlevplist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //return super.instantiateItem(container, position);
        container.addView(titlevplist.get(position));
        return titlevplist.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
