package cn.com.xxutils.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2016/1/11.
 */
public class XXTableFragmentAdapter extends FragmentStatePagerAdapter {
    private List<String> titles;
    private List<Fragment> fragments;
    public XXTableFragmentAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments) {

        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


}
