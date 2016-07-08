package chinanurse.cn.nurse;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2016/6/22.
 */
public class AppApplication extends Application {
    public static DisplayImageOptions options;
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader();

    }
    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCacheSizePercentage(30)
                .build();
        ImageLoader.getInstance().init(config);

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .showImageForEmptyUri(R.drawable.icon_nurse)
                .showImageOnFail(R.drawable.icon_nurse)
                .build();
    }
}
