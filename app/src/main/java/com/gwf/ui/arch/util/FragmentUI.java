package com.gwf.ui.arch.util;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gwf.ui.arch.R;

import java.util.HashMap;
import java.util.List;

public abstract class FragmentUI extends Fragment {
    private static final String TAG = FragmentUI.class.getSimpleName();

    public static boolean DEBUG_INFO = true;
    public static boolean DEBUG_ERR = false;

    private boolean mIsRoot = false;

    //Application Context
    protected Context mContext = null;

    protected ViewGroup mContainer = null;

    private ViewGroup mChildUIContainer = null;

    private FragmentUI mParentUI = null;

    private HashMap<String,FragmentUI> mChildUIMap = null;

    private static int mDefaultInAnimRes = -1;
    private static int mDefaultOutAnimRes = -1;
    private static int mDefaultPopInAnimRes = -1;
    private static int mDefaultPopOutAnimRes = -1;

    public FragmentUI(){

    }

    protected void startup(Context context, boolean isRoot) {
        mContext = context;
        mIsRoot = isRoot;

        mContainer = onCreateContainer();
        if( mContainer != null ) {
            //处理点击事件,避免未处理的点击被后面的fragment处理
            mContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            mChildUIContainer = onCreateChildUIContainer();
            if( mChildUIContainer != null )
                mChildUIMap = new HashMap<String,FragmentUI>();
        }
    }

    public static void setDefaultAnimRes(int defaultInAnimRes,int defaultOutAnimRes,int defaultPopInAnimRes,int defaultPopOutAnimRes){
        mDefaultInAnimRes = defaultInAnimRes;
        mDefaultOutAnimRes = defaultOutAnimRes;
        mDefaultPopInAnimRes = defaultPopInAnimRes;
        mDefaultPopOutAnimRes = defaultPopOutAnimRes;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        logInfo(this.getClass().getSimpleName()+ ": onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logInfo(this.getClass().getSimpleName()+ ": onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        logInfo(this.getClass().getSimpleName()+ ": onCreateView()");

        if( mContainer != null ) {
            logInfo(this.getClass().getSimpleName() + ": onCreateUI()  start.");
            onCreateUI();
            logInfo(this.getClass().getSimpleName() + ": onCreateUI()  end.");
            return mContainer;
        }else
            return  super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        logInfo(this.getClass().getSimpleName()+ ": onActivityCreated()");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        logInfo(this.getClass().getSimpleName()+ ": onViewStateRestored()");
    }

    @Override
    public void onStart() {
        super.onStart();

        logInfo(this.getClass().getSimpleName()+ ": onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();

        logInfo(this.getClass().getSimpleName()+ ": onResume()");

        logInfo(this.getClass().getSimpleName()+ ": onResumeUI()  start.");
        onResumeUI();
        logInfo(this.getClass().getSimpleName()+ ": onResumeUI()  end.");
    }

    @Override
    public void onPause() {
        super.onPause();

        logInfo(this.getClass().getSimpleName()+ ": onPause()");

        logInfo(this.getClass().getSimpleName()+ ": onPauseUI()  start.");
        onPauseUI();
        logInfo(this.getClass().getSimpleName()+ ": onPauseUI()  start.");
    }

    @Override
    public void onStop() {
        super.onStop();

        logInfo(this.getClass().getSimpleName()+ ": onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        logInfo(this.getClass().getSimpleName()+ ": onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        logInfo(this.getClass().getSimpleName()+ ": onDestroy()");

        logInfo(this.getClass().getSimpleName()+ ": onDestroyUI()  start.");
        onDestroyUI();
        logInfo(this.getClass().getSimpleName()+ ": onDestroyUI()  start.");
    }

    @Override
    public void onDetach() {
        super.onDetach();

        logInfo(this.getClass().getSimpleName()+ ": onDetach()");

        if( mParentUI != null )
            mParentUI.mChildUIMap.remove(this.getClass().getSimpleName());
    }

    public abstract ViewGroup onCreateContainer();

    public abstract ViewGroup onCreateChildUIContainer();

    public abstract void onCreateUI();

    public abstract void onResumeUI();

    public abstract void onForwardAndHideUI();

    public abstract void onBackwardAndShowUI();

    public abstract void onPauseUI();

    public abstract void onDestroyUI();

    public <T> FragmentUI findUI(Class<T> clazz) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException(TAG + ": findUI(...) must be called in main thread.");
        }

        FragmentUI ui = null;
        if( mChildUIMap != null ){
            ui = mChildUIMap.get(clazz.getSimpleName());

            if( ui == null ){
                for( FragmentUI _ui : mChildUIMap.values() ){
                    if( _ui != null ) {
                        ui = _ui.findUI(clazz);
                        if( ui != null )
                            break;
                    }
                }
            }
        }

        return ui;
    }

    public <T> void enterUI(Class<T> clazz){
        enterUI( clazz, (HashMap<String,Object>)null);
    }

    public <T> void enterUI(Class<T> clazz,HashMap<String,Object> argsMap){
        if( mDefaultInAnimRes > 0 && mDefaultOutAnimRes > 0 && mDefaultPopInAnimRes > 0 && mDefaultPopOutAnimRes > 0)
            enterUI( clazz, argsMap, mDefaultInAnimRes, mDefaultOutAnimRes,mDefaultPopInAnimRes,mDefaultPopOutAnimRes);
        else
            enterUI( clazz, argsMap, 0, 0,0,0);
    }

    public <T> void enterUI(Class<T> clazz,int inAnimRes, int outAnimRes,int popInAnimRes, int popOutAnimRes){
        enterUI( clazz, null, inAnimRes, outAnimRes, popInAnimRes, popOutAnimRes);
    }

    public <T> void enterUI(Class<T> clazz,HashMap<String,Object> argsMap, int inAnimRes, int outAnimRes,int popInAnimRes, int popOutAnimRes) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException(TAG + ": findUI(...) must be called in main thread.");
        }

        if( mChildUIContainer != null ) {
            try {
                /*以下调用带参的、私有构造函数*/
                //Constructor constructor = clazz.getDeclaredConstructor(new Class[]{Context.class,boolean.class});
                //constructor.setAccessible(true);
                //FragmentUI newUi = (FragmentUI)constructor.newInstance(new Object[]{mContext, false});
                FragmentUI newUi = (FragmentUI) clazz.newInstance();
                if (newUi != null) {
                    newUi.startup(mContext, false);
                    newUi.mParentUI = this; //Set Parent UI
                    mChildUIMap.put(clazz.getSimpleName(), newUi);

                    FragmentManager fm = null;
                    if (mIsRoot)
                        fm = ((FragmentActivity)mContext).getSupportFragmentManager();
                    else
                        fm = this.getChildFragmentManager();

                    if (fm != null) {
                        List<Fragment> fragments = fm.getFragments();
                        if( fragments != null && fragments.size() > 0 ){
                            FragmentUI hideUi = (FragmentUI)fragments.get(fragments.size()-1);
                            if( hideUi != null ) {
                                logInfo(hideUi.getClass().getSimpleName()+ ": onForwardAndHideUI()");
                                hideUi.onForwardAndHideUI();
                            }
                        }

                        FragmentTransaction tx = fm.beginTransaction();
                        if( inAnimRes > 0 && outAnimRes > 0 && popInAnimRes > 0 && popOutAnimRes > 0)
                            tx.setCustomAnimations(inAnimRes,outAnimRes, popInAnimRes,popOutAnimRes);//设置切换动画
                        else if( mDefaultInAnimRes > 0 && mDefaultOutAnimRes > 0 && mDefaultPopInAnimRes > 0 && mDefaultPopOutAnimRes > 0)
                            tx.setCustomAnimations( mDefaultInAnimRes, mDefaultOutAnimRes,mDefaultPopInAnimRes,mDefaultPopOutAnimRes);
                        else
                            tx.setCustomAnimations(0,0, 0,0);//设置切换动画
                        tx.add(mChildUIContainer.getId(), newUi, clazz.getSimpleName());
                        tx.addToBackStack(null);
                        tx.commit();
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void exitUI(){
        exitUI(-1,-1);
    }

    public void exitUI(int inAnimRes, int outAnimRes) {
        if( mParentUI != null ) {
            FragmentManager fm = null;
            if (mParentUI.mIsRoot)
                fm = ((FragmentActivity) mContext).getSupportFragmentManager();
            else
                fm = mParentUI.getChildFragmentManager();

            if( fm != null ) {
                fm.popBackStack();

                List<Fragment> fragments = fm.getFragments();
                if( fragments != null && fragments.size() >= 2 ){
                    FragmentUI showUi = (FragmentUI)fragments.get(fragments.size()-2);
                    if( showUi != null ) {
                        logInfo(showUi.getClass().getSimpleName()+ ": onBackwardAndShowUI()");
                        showUi.onBackwardAndShowUI();
                    }
                }
            }
        }
    }

    public boolean dispatchBack() {
        logInfo("Call dispatchKeyEvent on :" + this.getClass().getSimpleName());
        FragmentManager fm = null;
        if( mIsRoot )
            fm = ((FragmentActivity)mContext).getSupportFragmentManager();
        else
            fm = this.getChildFragmentManager();

        if( fm != null ) {
            List<Fragment> fragments = fm.getFragments();
            if( fragments != null && fragments.size() > 0 ){
                //获取当前FragmentManager的top(正现实的)子Fragment,
                FragmentUI theTopChildUI = (FragmentUI)fragments.get(fragments.size()-1);
                if( theTopChildUI != null ){
                    //进一步基于该子Fragment处理
                    if( theTopChildUI.dispatchBack() ){
                        return true;
                    }else{
                        //当前FragmentManager的top子Fragment,无可回退动作,则FragmentManager做回退处理
                        if (fm.getBackStackEntryCount() > 1) {
                            fm.popBackStack();

                            if( fragments != null && fragments.size() >= 2 ){
                                FragmentUI showUi = (FragmentUI)fragments.get(fragments.size()-2);
                                if( showUi != null ) {
                                    logInfo(showUi.getClass().getSimpleName()+ ": onBackwardAndShowUI()");
                                    showUi.onBackwardAndShowUI();
                                }
                            }
                            return true;
                        }else{
                            //最后无可以处理回退,返回false,交由App主线程处理
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * 判断Fragment是否处理了Back键
     *
     * @return 如果处理了back键则返回 **true**
     */
    public boolean isFragmentBackHandled(Fragment fragment) {
        return (fragment != null
                && fragment.isVisible()
                && fragment.getUserVisibleHint() //for ViewPager
        );//&& fragment is FragmentBackHandler
        //&& (fragment as FragmentBackHandler).onBackPressed())
    }

    //=======================================================
    protected void logInfo(String msg) {
        if (DEBUG_INFO)
            Log.i(TAG, msg);
    }

    protected void logErr(String msg) {
        if (DEBUG_ERR)
            Log.e(TAG, msg);
    }

    public void dumpUIArch(){
        Log.i(TAG, "dumpUIArch()***********************************************Start");
        if (mIsRoot){
            int layerNumber = 1; // Root layer
            Log.i(TAG, "Layer-" + layerNumber + ": --" + this.getClass().getSimpleName());
            this.dumpChildUIArch(layerNumber,"  ");
        }else{
            throw new RuntimeException(TAG + ": dumpUIArch() only be called on a Root UI.");
        }
        Log.i(TAG, "dumpUIArch()***********************************************End");
    }

    private void dumpChildUIArch(int layerNumber,String lineText){
        layerNumber++;

        FragmentManager fm = null;
        if( mIsRoot )
            fm = ((FragmentActivity)mContext).getSupportFragmentManager();
        else
            fm = this.getChildFragmentManager();

        if( fm != null ) {
            List<Fragment> fragments = fm.getFragments();
            if( fragments != null && fragments.size() > 0 ){
                for( Fragment fragment : fragments ){
                    if( fragment != null ){
                        FragmentUI theChildUI = (FragmentUI)fragment;

                        Log.i(TAG, "Layer-" + layerNumber + ": " + lineText + "|--" + theChildUI.getClass().getSimpleName());
                        theChildUI.dumpChildUIArch(layerNumber,lineText+"   ");
                    }
                }
            }
        }
    }
}
