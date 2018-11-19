package com.gwf.ui.arch.ui.root;

import android.view.View;
import android.view.ViewGroup;

import com.gwf.ui.arch.R;
import com.gwf.ui.arch.ui.Root;
import com.gwf.ui.arch.ui.root.content.Category;
import com.gwf.ui.arch.util.A;
import com.gwf.ui.arch.util.FragmentUI;

/**
 * Created by okgwf on 2018/11/16.
 */

public class Content extends FragmentUI {
    private static final String TAG = Content.class.getSimpleName();

    @Override
    public ViewGroup onCreateContainer() {
        return (ViewGroup)View.inflate(mContext, R.layout.content, null);
    }

    @Override
    public ViewGroup onCreateChildUIContainer() {
        return mContainer.findViewById(R.id.child_ui_container);
    }

    @Override
    public void onCreateUI() {
        A.$(mContainer,R.id.play_control_bar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Root.getInstance().enterUI(Playing.class, R.anim.push_bottom_in, R.anim.push_top_out,R.anim.push_top_in,R.anim.push_bootom_out);
            }
        });

        enterUI(Category.class);
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
