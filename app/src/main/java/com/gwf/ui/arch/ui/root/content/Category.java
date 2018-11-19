package com.gwf.ui.arch.ui.root.content;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.gwf.ui.arch.R;
import com.gwf.ui.arch.ui.Root;
import com.gwf.ui.arch.ui.root.Content;
import com.gwf.ui.arch.util.A;
import com.gwf.ui.arch.util.FragmentUI;
import com.gwf.ui.arch.util.ViewPagerAdapter;

import java.util.ArrayList;

/**
 * Created by okgwf on 2018/11/16.
 */

public class Category extends FragmentUI{
    private static final String TAG = Category.class.getSimpleName();

    private View mLayoutLocal = null;
    private View mLayoutNetwork = null;
    private View mLayoutFavorite = null;

    //private var mPager: ViewPager? = null//页卡内容
    private ArrayList<View> mTabPageList = null; // Tab页面列表

    private View mSelectedTabView = null;

    private void onTabClickListener(View v) {
        if (mSelectedTabView == v)
            return;
        switch (v.getId()) {
            case R.id.tab_local:
                ((ViewPager)A.$(mContainer,R.id.viewpager).get()).setCurrentItem(0, false);
                break;
            case R.id.tab_network:
                ((ViewPager)A.$(mContainer,R.id.viewpager).get()).setCurrentItem(1, false);
                break;
            case R.id.tab_favorite:
                ((ViewPager)A.$(mContainer,R.id.viewpager).get()).setCurrentItem(2, false);
                break;
        }

        if (mSelectedTabView != null)
            mSelectedTabView.setSelected(false);
        v.setSelected(true);
        mSelectedTabView = v;
    }

    @Override
    public ViewGroup onCreateContainer() {
        return (ViewGroup)View.inflate(mContext, R.layout.category, null);
    }

    @Override
    public ViewGroup onCreateChildUIContainer(){
        return null;
    }

    @Override
    public void onCreateUI() {
        A.$(mContainer,R.id.tab_local).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTabClickListener(v);
            }
        });

        A.$(mContainer,R.id.tab_network).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTabClickListener(v);
            }
        });

        A.$(mContainer,R.id.tab_favorite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTabClickListener(v);
            }
        });

        mLayoutLocal = View.inflate(mContext, R.layout.category_local, null);
        mLayoutNetwork = View.inflate(mContext, R.layout.category_network, null);
        mLayoutFavorite = View.inflate(mContext, R.layout.category_favorite, null);

        mTabPageList = new ArrayList<View>();

        mTabPageList.add(mLayoutLocal);
        mTabPageList.add(mLayoutNetwork);
        mTabPageList.add(mLayoutFavorite);

        ((ViewPager)A.$(mContainer,R.id.viewpager).get()).setAdapter( new ViewPagerAdapter(mTabPageList) );
        ((ViewPager)A.$(mContainer,R.id.viewpager).get()).addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageSelected(int index) {
                switch (index) {
                    case 0:
                        A.$(mContainer,R.id.tab_local).performClick();
                        break;
                    case 1:
                        A.$(mContainer,R.id.tab_network).performClick();
                        break;
                    case 2:
                        A.$(mContainer,R.id.tab_favorite).performClick();
                        break;
                }
            }

        });

        A.$(mLayoutLocal,R.id.btn_view_local_album).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Root.getInstance().findUI(Content.class).enterUI(AlbumList.class);
            }
        });

        A.$(mLayoutNetwork,R.id.btn_view_network_album).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Root.getInstance().findUI(Content.class).enterUI(AlbumList.class);
            }
        });

        A.$(mLayoutFavorite,R.id.btn_view_favorite_album).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Root.getInstance().findUI(Content.class).enterUI(AlbumList.class);
            }
        });

        A.$(mContainer,R.id.tab_local).performClick();
    }

    @Override
    public void onResumeUI() {

    }

    @Override
    public void onForwardAndHideUI() {

    }

    @Override
    public void onBackwardAndShowUI() {

    }

    @Override
    public void onPauseUI() {

    }

    @Override
    public void onDestroyUI() {

    }
}
