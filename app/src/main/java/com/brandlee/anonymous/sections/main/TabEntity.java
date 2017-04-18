package com.brandlee.anonymous.sections.main;

import com.brandlee.anonymous.entities.BaseEntity;
import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * @ClassName: TabEntity
 * @Description:
 * @Author liqi1
 * @Date 17/4/18
 */

public class TabEntity extends BaseEntity implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public TabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
