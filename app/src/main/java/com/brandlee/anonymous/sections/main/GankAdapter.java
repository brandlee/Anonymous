package com.brandlee.anonymous.sections.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.brandlee.anonymous.sections.about.AboutFragment;
import com.brandlee.anonymous.sections.daily.MainFragment;
import com.brandlee.anonymous.sections.sort.OrderFragment;
import com.brandlee.anonymous.utils.Constant;

/**
 * @ClassName: GankAdapter
 * @Description: Fragment适配器
 * @Author liqi1
 * @Date 17/4/18
 */

public class GankAdapter extends FragmentPagerAdapter {
    public GankAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MainFragment.newInstance("", "");
            case 1:
                return OrderFragment.newInstance("", "");
            case 2:
                return AboutFragment.newInstance("", "");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return Constant.sTabTitles.length;
    }
}
