package com.xiaoxin.acp_client.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xiaoxin.acp_client.Fragment.PageFragment;
import com.xiaoxin.acp_client.Fragment.PluginListFragment;


/**
 * Created by Administrator on 2015/7/30.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"插件推荐", "tab2", "tab3"};
    private Context context;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PluginListFragment.newInstance(position + 1 + "", 0 + "");
            default:
                return PageFragment.newInstance(position + 1);
        }

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}