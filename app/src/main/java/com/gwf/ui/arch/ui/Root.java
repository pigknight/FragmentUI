package com.gwf.ui.arch.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.gwf.ui.arch.MainActivity;
import com.gwf.ui.arch.R;
import com.gwf.ui.arch.util.FragmentUI;

public class Root extends FragmentUI{
    private static final String TAG = Root.class.getSimpleName();

    private static Root mInstance = null;

    public static void initInstance(Context context) {
        mInstance = new Root();
        mInstance.startup(context,true);
    }

    public static Root getInstance() {
        if (mInstance == null)
            throw new RuntimeException(TAG + ": Must called the initInstance() before to call getInstance().");
        return mInstance;
    }

    @Override
    public ViewGroup onCreateContainer() {
        return ((MainActivity)mContext).getMainContainer();
    }

    @Override
    public ViewGroup onCreateChildUIContainer() {
        return mContainer.findViewById(R.id.child_ui_container);
    }

    @Override
    public void onCreateUI() {

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
