package com.gwf.ui.arch.util;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by okgwf on 2018/11/16.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private List<View> mListViews = null;

    public ViewPagerAdapter(List<View> ListViews){
        mListViews = ListViews;
    }

    @Override
    public void destroyItem(ViewGroup parentView, int position, Object data) {
        ((ViewPager)parentView).removeView(mListViews.get(position));
    }

    @Override
    public void finishUpdate(ViewGroup arg0){}

    @Override
    public int getCount() {
       return mListViews.size();
    }

    @Override
    public Object  instantiateItem( ViewGroup parentView, int position ){
        ((ViewPager)parentView).addView(mListViews.get(position), 0);
        return mListViews.get(position);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {

    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(ViewGroup parentView) {

    }
}
