package liangjianchao.com.bwei.week3_deamo2;

import android.app.Application;

import org.xutils.x;

/**
 * Created by lenovo、 on 2017/8/19.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);


    }
}
