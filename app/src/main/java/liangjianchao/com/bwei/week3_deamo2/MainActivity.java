package liangjianchao.com.bwei.week3_deamo2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> list = new ArrayList<String>();
    private List<Fragment> frags = new ArrayList<Fragment>();
    private TabLayout tabLayout;
    private ViewPager vp;
    private SlidingMenu menu;
    private ImageView imagenight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x.view().inject(this);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        vp = (ViewPager) findViewById(R.id.vp);
       ImageView image = (ImageView) findViewById(R.id.imageViewButton);
        imagenight = (ImageView) findViewById(R.id.imageViewNight);
        list.add("推荐");
        list.add("热点");
        list.add("北京");
        list.add("视频");
        list.add("社会");
        frags.add(new OneFragment());
        frags.add(new TwoFragment());
        frags.add(new ThreFragment());
        frags.add(new FourFragment());
        frags.add(new FiveFragment());

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!menu.isMenuShowing()){
                    menu.showMenu();
                }
            }
        });

        imagenight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 SharedPreferences pre = getSharedPreferences("user_setting", MODE_PRIVATE);
                         boolean isNight = pre.getBoolean("night",false);

                         if(isNight){
                             AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                             pre.edit().putBoolean("night",false).commit();
                         }else{
                             AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                             pre.edit().putBoolean("night",true).commit();
                         }

                         recreate();
            }
        });

        MyFragment adapter = new MyFragment(getSupportFragmentManager());
        vp.setAdapter(adapter);
        Tabadd();
        initMeau();
    }

    private void initMeau() {
        menu = new SlidingMenu(this);
         menu.setMode(SlidingMenu.LEFT);
         // 设置触摸屏幕的模式
         menu.setShadowWidthRes(R.dimen.shadow_width);
         // 设置滑动菜单视图的宽度
         menu.setBehindOffsetRes(R.dimen.shadow_width);
         // 设置渐入渐出效果的值
         menu.setFadeDegree(0.35f);

         menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
         //为侧滑菜单设置布局
         menu.setMenu(R.layout.item_left);
    }

    private void Tabadd() {

        tabLayout.addTab(tabLayout.newTab().setText(list.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(list.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(list.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(list.get(3)));
        tabLayout.addTab(tabLayout.newTab().setText(list.get(4)));

        tabLayout.setupWithViewPager(vp);
    }

    class MyFragment extends FragmentPagerAdapter{

        public MyFragment(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return frags.get(position);
        }

        @Override
        public int getCount() {
            return frags.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }
    }
}
