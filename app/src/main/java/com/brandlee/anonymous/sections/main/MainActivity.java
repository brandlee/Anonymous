package com.brandlee.anonymous.sections.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.widget.SlidableViewPager;
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

        initTabs();
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
