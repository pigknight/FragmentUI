package com.gwf.ui.arch.ui.root.content;

import android.view.View;
import android.view.ViewGroup;

import com.gwf.ui.arch.R;
import com.gwf.ui.arch.util.A;
import com.gwf.ui.arch.util.FragmentUI;

public class MusicList extends FragmentUI {
    private static final String TAG = MusicList.class.getSimpleName();

    @Override
    public ViewGroup onCreateContainer() {
        return (ViewGroup)View.inflate(mContext, R.layout.music_list, null);
    }

    @Override
    public ViewGroup onCreateChildUIContainer() {
        return null;
    }

    @Override
    public void onCreateUI() {
        A.$(mContainer,R.id.title).setText("Music List");

        A.$(mContainer,R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitUI();
            }
        });
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
