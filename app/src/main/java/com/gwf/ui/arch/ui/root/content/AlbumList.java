package com.gwf.ui.arch.ui.root.content;


import android.view.View;
import android.view.ViewGroup;

import com.gwf.ui.arch.R;
import com.gwf.ui.arch.ui.Root;
import com.gwf.ui.arch.ui.root.Content;
import com.gwf.ui.arch.util.A;
import com.gwf.ui.arch.util.FragmentUI;

public class AlbumList extends FragmentUI {
    private static final String TAG = AlbumList.class.getSimpleName();

    @Override
    public ViewGroup onCreateContainer() {
        return (ViewGroup) View.inflate(mContext, R.layout.album_list, null);
    }

    @Override
    public ViewGroup onCreateChildUIContainer(){
        return null;
    }

    @Override
    public void onCreateUI() {
        A.$(mContainer,R.id.title).setText("Album List");
        A.$(mContainer,R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitUI();
            }
        });

        A.$(mContainer,R.id.album_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Root.getInstance().findUI(Content.class).enterUI(MusicList.class);
            }
        });

        A.$(mContainer,R.id.album_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Root.getInstance().findUI(Content.class).enterUI(MusicList.class);
            }
        });

        A.$(mContainer,R.id.album_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Root.getInstance().findUI(Content.class).enterUI(MusicList.class);
            }
        });
        A.$(mContainer,R.id.album_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Root.getInstance().findUI(Content.class).enterUI(MusicList.class);
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
