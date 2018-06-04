package com.brandlee.anonymous.sections.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.widget.SlidableViewPager;
import com.brandlee.anonymous.sections.login.LoginSplashActivity;
import com.brandlee.anonymous.utils.Constant;
import com.brandlee.anonymous.utils.SharedPrefsUtils;
import com.brandlee.leeimageloader.GlideImageLoaderStrategy;
import com.brandlee.leeimageloader.ImageLoaderManager;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;

import static com.brandlee.anonymous.utils.Constant.mIconSelectIds;
import static com.brandlee.anonymous.utils.Constant.mIconUnselectIds;
import static com.brandlee.anonymous.utils.Constant.sTabTitles;

public class MainActivity extends BaseActivity {
    @BindView(R.id.vp_content)
    SlidableViewPager mVPContent;
    @BindView(R.id.tab_layout)
    CommonTabLayout mTabLayout;

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageLoaderManager.getInstance().setImageLoaderStrategy(new GlideImageLoaderStrategy());

        initTabs();

        boolean loginStatus = SharedPrefsUtils.getBooleanPreference(this, Constant.LOGIN_STATUS, false);
        if (!loginStatus) {
            startActivity(new Intent(MainActivity.this, LoginSplashActivity.class));
        }
    }

    public void jumpToOrderList() {
        mVPContent.setCurrentItem(1);
    }

    private void initTabs() {
        for (int i = 0; i < sTabTitles.length; i++) {
            mTabEntities.add(new TabEntity(sTabTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        GankAdapter gankAdapter = new GankAdapter(getSupportFragmentManager());
        mVPContent.setAdapter(gankAdapter);
        mVPContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout.setTabData(mTabEntities);
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mVPContent.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }
}
