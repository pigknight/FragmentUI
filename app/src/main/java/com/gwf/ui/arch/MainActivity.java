package com.gwf.ui.arch;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gwf.ui.arch.ui.Root;
import com.gwf.ui.arch.ui.root.Content;
import com.gwf.ui.arch.ui.root.content.Category;
import com.gwf.ui.arch.ui.root.content.MusicList;
import com.gwf.ui.arch.util.FragmentUI;

import java.lang.ref.WeakReference;

public class MainActivity extends FragmentActivity {

    private ViewGroup mMainContainer = null;

    private boolean mWaitForSecondKey = false;

    private static final int MSG_ID_DELAYED_TO_WAIT_SECOND_BACK_KEY = 1;
    private MyHandler mHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMainContainer = (ViewGroup) View.inflate(this,R.layout.activity_main,null);
        setContentView( mMainContainer );

        mHandler = new MyHandler(this.getApplicationContext());

        initUI();
    }

    public ViewGroup getMainContainer(){
        return mMainContainer;
    }

    private void initUI() {
        //设置默认UI切换动画
        FragmentUI.setDefaultAnimRes(R.anim.push_right_in,R.anim.push_left_out,R.anim.push_left_in,R.anim.push_right_out);

        //Init
        Root.initInstance(this);

        Root.getInstance().enterUI(Content.class);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch( keyCode ){
            case KeyEvent.KEYCODE_BACK:
                if( Root.getInstance().dispatchBack() )
                    return true;

                if ( !mWaitForSecondKey ) {
                    mWaitForSecondKey = true;

                    Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();

                    mHandler.removeMessages(MSG_ID_DELAYED_TO_WAIT_SECOND_BACK_KEY);
                    mHandler.sendEmptyMessageDelayed(MSG_ID_DELAYED_TO_WAIT_SECOND_BACK_KEY, 2000);
                } else{
                    finish();
                }
                return true;
            case KeyEvent.KEYCODE_MENU:
                Root.getInstance().dumpUIArch();
                return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    /**
     * 声明一个静态的Handler内部类，并持有外部类的弱引用
     */
    private class MyHandler extends Handler {

        private final WeakReference<Context> mContext;

        private MyHandler(Context context) {
            this.mContext = new WeakReference<Context>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            mHandler.removeMessages(msg.what);

            switch (msg.what) {
                case MSG_ID_DELAYED_TO_WAIT_SECOND_BACK_KEY:
                    mHandler.removeMessages(MSG_ID_DELAYED_TO_WAIT_SECOND_BACK_KEY);
                    mWaitForSecondKey = false;
                    break;
            }
        }
    }
}
