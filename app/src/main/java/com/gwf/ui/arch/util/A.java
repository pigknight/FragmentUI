package com.gwf.ui.arch.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.AbsSpinner;
import android.widget.AbsoluteLayout;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.ViewAnimator;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

public class A {

    public static final String VERSION = "0.2.2.1";
    private final static String LOG_TAG = "Q";
    public static final int ERROR_NETWORK = 1;
    public static final int ERROR_LOAD_DATA = 2;
    public static final int ERROR_PARSER_XML = 3;


    private View data = null;

    // core

    public A(){

    }

    private A(View view)
    {
        this.data = view;
    }

    public static A $(View view){
        return new A(view);
    }

    public static A $(Context content, String s){
        View view = null;
        if(s.equals("View")){
            view = new View(content);
        }else if(s.equals("TextView")){
            view = new TextView(content);
        }else if(s.equals("EditText")){
            view = new EditText(content);
        }else if(s.equals("ImageView")){
            view = new ImageView(content);
        }else if(s.equals("Button")){
            view = new Button(content);
        }else if(s.equals("AbsoluteLayout")){
            view = new AbsoluteLayout(content);
        }else if(s.equals("RelativeLayout")){
            view = new RelativeLayout(content);
        }else if(s.equals("LinearLayout")){
            view = new LinearLayout(content);
        }else if(s.equals("FrameLayout")){
            view = new FrameLayout(content);
        }else if(s.equals("ScrollView")){
            view = new ScrollView(content);
        }else if(s.equals("ListView")){
            view = new ListView(content);
        }else if(s.equals("GridView")){
            view = new GridView(content);
        }else if(s.equals("WebView")){
            view = new WebView(content);
        }
        A j = new A(view);
        return j;
    }

    public static A $(Activity at, int id){
        A j = new A();
        if( at != null )
            j.data = at.findViewById(id);
        return j;
    }

    public static A $(Dialog dl, int id){
        A j = new A();
        if( dl != null )
            j.data = dl.findViewById(id);
        return j;
    }

    public static A $(ViewGroup vg, int id){
        A j = new A();
        if( vg != null )
            j.data = vg.findViewById(id);
        return j;
    }

    public static A $(View v,int id){
        A j = new A();
        if( v != null && v instanceof ViewGroup ){
            j.data = ((ViewGroup)v).findViewById(id);
        }

        return j;
    }

    public static A $(Context ctx,int rid,ViewGroup vg){
        A j = new A();
        j.data = View.inflate(ctx, rid, vg);
        return j;
    }



    // View

    public int getId(){
        if( data != null){
            return data.getId();
        }
        return -1;
    }

    public A setId(int id){
        if( data!=null ){
            data.setId(id);
        }
        return this;
    }

    public Object getTag(){
        if( data != null ){
            return data.getTag();
        }
        return null;
    }

    public Object getTag(int key){
        if( data != null ){
            return data.getTag(key);
        }
        return null;
    }

    public A setTag(Object tag){
        if( data!= null){
            data.setTag(tag);
        }
        return this;
    }

    public A setTag(int key,Object tag){
        if( data!= null){
            data.setTag(key,tag);
        }
        return this;
    }

    public A bringToFront(){
        if( data!= null){
            data.bringToFront();
        }
        return this;
    }


    public int getVisibility(){
        if ( data!= null){
            return data.getVisibility();
        }
        return -1;
    }

    public int getWindowVisibility(){
        if ( data!= null){
            return data.getWindowVisibility();
        }
        return -1;
    }

    public A setVisibility(int visibility){
        if( data!= null){
            data.setVisibility(visibility);
        }
        return this;
    }

    public boolean isShown(){
        if ( data!= null){
            return data.isShown();
        }
        return false;
    }

    public boolean isEnabled(){
        if ( data!= null){
            return data.isEnabled();
        }
        return false;
    }

    public A setEnabled(boolean enabled){
        if( data!= null){
            data.setEnabled(enabled);
        }
        return this;
    }

    public boolean hasFocusable(){
        if ( data!= null){
            return data.hasFocusable();
        }
        return false;
    }

    public boolean isFocusable(){
        if ( data!= null){
            return data.isFocusable();
        }
        return false;
    }

    public boolean hasFocus(){
        if ( data!= null){
            return data.hasFocus();
        }
        return false;
    }

    public boolean isFocused(){
        if ( data!= null){
            return data.isFocused();
        }
        return false;
    }

    public A setFocusable(boolean focusable){
        if( data!= null){
            data.setFocusable(focusable);
        }
        return this;
    }

    public A requestFocus(){
        if( data!= null){
            data.requestFocus();
        }
        return this;
    }

    public A clearFocus(){
        if( data!= null){
            data.clearFocus();
        }
        return this;
    }

    public A computeScroll(){
        if( data!= null){
            data.computeScroll();
        }
        return this;
    }

    public A dispatchKeyEvent(KeyEvent event){
        if( data!= null){
            data.dispatchKeyEvent(event);
        }
        return this;
    }

    public A dispatchKeyEventPreIme(KeyEvent event){
        if( data!= null){
            data.dispatchKeyEventPreIme(event);
        }
        return this;
    }

    public A dispatchKeyShortcutEvent(KeyEvent event){
        if( data!= null){
            data.dispatchKeyShortcutEvent(event);
        }
        return this;
    }

    public A dispatchPopulateAccessibilityEvent(AccessibilityEvent event){
        if( data!= null){
            data.dispatchPopulateAccessibilityEvent(event);
        }
        return this;
    }

    public A dispatchTouchEvent(MotionEvent event){
        if( data!= null){
            data.dispatchTouchEvent(event);
        }
        return this;
    }

    public A dispatchTrackballEvent(MotionEvent event){
        if( data!= null){
            data.dispatchTrackballEvent(event);
        }
        return this;
    }

    public A dispatchUnhandledMove(View focused, int direction){
        if( data!= null){
            data.dispatchUnhandledMove(focused,direction);
        }
        return this;
    }

    public A dispatchWindowVisibilityChanged(int visibility){
        if( data!= null){
            data.dispatchWindowVisibilityChanged(visibility);
        }
        return this;
    }

    public View findFocus(){
        if ( data!= null){
            return data.findFocus();
        }
        return null;
    }

    public View findViewById(int id){
        if ( data!= null){
            return data.findViewById(id);
        }
        return null;
    }

    public View findViewWithTag(Object tag){
        if ( data!= null){
            return data.findViewWithTag(tag);
        }
        return null;
    }

    public View focusSearch(int direction){
        if ( data!= null){
            return data.focusSearch(direction);
        }
        return null;
    }

    public boolean isSelected(){
        if ( data!= null){
            return data.isSelected();
        }
        return false;
    }

    public A setSelected(boolean selected){
        if( data!= null){
            data.setSelected(selected);
        }
        return this;
    }

    public boolean isClickable(){
        if ( data!= null){
            return data.isClickable();
        }
        return false;
    }

    public A setClickable(boolean clickable){
        if( data!= null){
            data.setClickable(clickable);
        }
        return this;
    }

    public A performClick(){
        if( data!= null){
            data.performClick();
        }
        return this;
    }

    public boolean isPressed(){
        if ( data!= null){
            return data.isPressed();
        }
        return false;
    }

    public A setPressed(boolean pressed){
        if( data!= null){
            data.setPressed(pressed);
        }
        return this;
    }

    public int getLeft(){
        if ( data!= null){
            return data.getLeft();
        }
        return -1;
    }
    public int getRight(){
        if ( data!= null){
            return data.getRight();
        }
        return -1;
    }

    public int getTop(){
        if ( data!= null){
            return data.getTop();
        }
        return -1;
    }

    public int getBottom(){
        if ( data!= null){
            return data.getBottom();
        }
        return -1;
    }

    public int getWidth(){
        if ( data!= null){
            return data.getWidth();
        }
        return -1;
    }

    public int getHeight(){
        if ( data!= null){
            return data.getHeight();
        }
        return -1;
    }

    public int getPaddingTop(){
        if ( data!= null){
            return data.getPaddingTop();
        }
        return -1;
    }

    public int getPaddingBottom(){
        if ( data!= null){
            return data.getPaddingBottom();
        }
        return -1;
    }

    public int getPaddingLeft(){
        if ( data!= null){
            return data.getPaddingLeft();
        }
        return -1;
    }

    public int getPaddingRight(){
        if ( data!= null){
            return data.getPaddingRight();
        }
        return -1;
    }

    public int getMeasuredHeight(){
        if ( data!= null){
            return data.getMeasuredHeight();
        }
        return -1;
    }

    public int getMeasuredWidth(){
        if ( data!= null){
            return data.getMeasuredWidth();
        }
        return -1;
    }

    public ViewGroup.LayoutParams getLayoutParams(){
        if ( data!= null){
            return data.getLayoutParams();
        }
        return null;
    }

    public A setLayoutParams(ViewGroup.LayoutParams params){
        if ( data!= null){
            data.setLayoutParams(params);
        }
        return this;
    }

    public A setLayoutParams(boolean fillParent) {
        if (fillParent) {
            return setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.FILL_PARENT));
        } else {
            return setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    public A layout(int l, int t, int r, int b){
        if ( data!= null){
            data.layout(l,t,r,b);
        }
        return this;
    }

    public A measure(int widthMeasureSpec, int heightMeasureSpec){
        if ( data!= null){
            data.measure(widthMeasureSpec,heightMeasureSpec);
        }
        return this;
    }

    public A setMinimumHeight(int minHeight){
        if ( data!= null){
            data.setMinimumHeight(minHeight);
        }
        return this;
    }

    public A setMinimumWidth(int minWidth){
        if ( data!= null){
            data.setMinimumWidth(minWidth);
        }
        return this;
    }

    public A setPadding(int left, int top, int right, int bottom){
        if ( data!= null){
            data.setPadding(left,top,right,bottom);
        }
        return this;
    }

    public A invalidate(){
        if ( data!= null){
            data.invalidate();
        }
        return this;
    }

    public A forceLayout(){
        if ( data!= null){
            data.forceLayout();
        }
        return this;
    }

    public A onKeyDown(int keyCode, KeyEvent event){
        if ( data!= null){
            data.onKeyDown(keyCode,event);
        }
        return this;
    }

    public A requestLayout(){
        if ( data!= null){
            data.requestLayout();
        }
        return this;
    }

    public A scheduleDrawable(Drawable who, Runnable what, long when){
        if ( data!= null){
            data.scheduleDrawable(who,what,when);
        }
        return this;
    }

    public A unscheduleDrawable(Drawable who, Runnable what){
        if ( data!= null){
            data.unscheduleDrawable(who,what);
        }
        return this;
    }

    public A unscheduleDrawable(Drawable who){
        if ( data!= null){
            data.unscheduleDrawable(who);
        }
        return this;
    }

    public A scrollBy(int x, int y){
        if ( data!= null){
            data.scrollBy(x,y);
        }
        return this;
    }

    public A scrollTo(int x, int y){
        if ( data!= null){
            data.scrollTo(x,y);
        }
        return this;
    }

    public A setAnimation(Animation animation){
        if ( data!= null){
            data.setAnimation(animation);
        }
        return this;
    }

    public A startAnimation(Animation animation){
        if ( data!= null){
            data.startAnimation(animation);
        }
        return this;
    }

    public A clearAnimation(){
        if ( data!= null){
            data.clearAnimation();
        }
        return this;
    }

    public A setBackgroundColor(int color){
        if ( data!= null){
            data.setBackgroundColor(color);
        }
        return this;
    }

    public A setBackgroundDrawable(Drawable d){
        if ( data!= null){
            data.setBackgroundDrawable(d);
        }
        return this;
    }

    public A setBackgroundResource(int resid){
        if ( data!= null){
            data.setBackgroundResource(resid);
        }
        return this;
    }


    public A setNextFocusLeftId(int resid){
        if ( data!= null){
            data.setNextFocusLeftId(resid);
        }
        return this;
    }

    public A setNextFocusUpId(int resid){
        if ( data!= null){
            data.setNextFocusUpId(resid);
        }
        return this;
    }

    public A setNextFocusRightId(int resid){
        if ( data!= null){
            data.setNextFocusRightId(resid);
        }
        return this;
    }

    public A setNextFocusDownId(int resid){
        if ( data!= null){
            data.setNextFocusDownId(resid);
        }
        return this;
    }

    public A setOnClickListener(View.OnClickListener l){
        if ( data!= null){
            data.setOnClickListener(l);
        }
        return this;
    }

    public A setOnCreateContextMenuListener(View.OnCreateContextMenuListener l){
        if ( data!= null){
            data.setOnCreateContextMenuListener(l);
        }
        return this;
    }

    public A setOnFocusChangeListener(View.OnFocusChangeListener  l){
        if ( data!= null){
            data.setOnFocusChangeListener(l);
        }
        return this;
    }

    public A setOnKeyListener(View.OnKeyListener  l){
        if ( data!= null){
            data.setOnKeyListener(l);
        }
        return this;
    }

    public A setOnLongClickListener(View.OnLongClickListener  l){
        if ( data!= null){
            data.setOnLongClickListener(l);
        }
        return this;
    }

    public A setOnTouchListener(View.OnTouchListener  l){
        if ( data!= null){
            data.setOnTouchListener(l);
        }
        return this;
    }

    public A setSaveEnabled(boolean enabled){
        if ( data!= null){
            data.setSaveEnabled(enabled);
        }
        return this;
    }

    public A setScrollBarStyle(int style){
        if ( data!= null){
            data.setScrollBarStyle(style);
        }
        return this;
    }

    public A setScrollContainer(boolean isScrollContainer){
        if ( data!= null){
            data.setScrollContainer(isScrollContainer);
        }
        return this;
    }

    public A setScrollbarFadingEnabled(boolean fadeScrollbars){
        if ( data!= null){
            data.setScrollbarFadingEnabled(fadeScrollbars);
        }
        return this;
    }

    public A setSoundEffectsEnabled(boolean soundEffectsEnabled){
        if ( data!= null){
            data.setSoundEffectsEnabled(soundEffectsEnabled);
        }
        return this;
    }

    // TextView
    public A setGravity(int gravity){
        if ( data!= null ){
            if(data instanceof TextView){
                ((TextView)data).setGravity(gravity);
            }else if(data instanceof LinearLayout){
                ((LinearLayout)data).setGravity(gravity);
            }else if(data instanceof RelativeLayout){
                ((RelativeLayout)data).setGravity(gravity);
            }
        }
        return this;
    }

    public CharSequence getText(){
        if ( data!= null && data instanceof TextView){
            return ((TextView)data).getText();
        }
        return null;
    }

    public A setText(CharSequence text){
        if ( data!= null && data instanceof TextView){
            ((TextView)data).setText(text);
        }
        return this;
    }

    public A setTextColor(int color){
        if ( data!= null && data instanceof TextView){
            ((TextView)data).setTextColor(color);
        }
        return this;
    }

    public A setTextColor(ColorStateList colors){
        if ( data!= null && data instanceof TextView){
            ((TextView)data).setTextColor(colors);
        }
        return this;
    }

    public A setTextSize(float size){
        if ( data!= null && data instanceof TextView){
            ((TextView)data).setTextSize(size);
        }
        return this;
    }

    public A setTextSize(int type,float size){
        if ( data!= null && data instanceof TextView){
            ((TextView)data).setTextSize(type,size);
        }
        return this;
    }

    public A append(CharSequence text, int start, int end){
        if ( data!= null && data instanceof TextView){
            ((TextView)data).append(text,start,end);
        }
        return this;
    }

    public A append(CharSequence text){
        if ( data!= null && data instanceof TextView){
            ((TextView)data).append(text);
        }
        return this;
    }

    public A setKeyListener(KeyListener input){
        if ( data!= null && data instanceof TextView){
            ((TextView)data).setKeyListener(input);
        }
        return this;
    }

    public A addTextChangedListener(TextWatcher watcher){
        if ( data!= null && data instanceof TextView){
            ((TextView)data).addTextChangedListener(watcher);
        }
        return this;
    }

    // CompoundButton
    public boolean isChecked(){
        if ( data!= null && data instanceof CompoundButton){
            return ((CompoundButton)data).isChecked();
        }
        return false;
    }

    public A setButtonDrawable(Drawable d){
        if ( data!= null && data instanceof CompoundButton){
            ((CompoundButton)data).setButtonDrawable(d);
        }
        return this;
    }

    public A setButtonDrawable(int resid){
        if ( data!= null && data instanceof CompoundButton){
            ((CompoundButton)data).setButtonDrawable(resid);
        }
        return this;
    }

    public A setChecked(boolean checked){
        if ( data!= null && data instanceof CompoundButton){
            ((CompoundButton)data).setChecked(checked);
        }
        return this;
    }

    public A toggle(){
        if ( data!= null && data instanceof CompoundButton){
            ((CompoundButton)data).toggle();
        }
        return this;
    }

    public A setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener){
        if ( data!= null && data instanceof CompoundButton){
            ((CompoundButton)data).setOnCheckedChangeListener(listener);
        }
        return this;
    }


    // ImageView
    public ImageView.ScaleType getScaleType(){
        if ( data!= null && data instanceof ImageView){
            return ((ImageView)data).getScaleType();
        }
        return null;
    }

    public A setAlpha(int alpha){
        if ( data!= null && data instanceof ImageView){
            ((ImageView)data).setAlpha(alpha);
        }
        return this;
    }



    public A setImageBitmap(Bitmap bm){
        if ( data!= null && data instanceof ImageView){
            ((ImageView)data).setImageBitmap(bm);
        }
        return this;
    }

    public A setImageDrawable(Drawable drawable){
        if ( data!= null && data instanceof ImageView){
            ((ImageView)data).setImageDrawable(drawable);
        }
        return this;
    }

    public A setImageResource(int resId){
        if ( data!= null && data instanceof ImageView){
            ((ImageView)data).setImageResource(resId);
        }
        return this;
    }


    public A setImageURI(Uri uri){
        if ( data!= null && data instanceof ImageView){
            ((ImageView)data).setImageURI(uri);
        }
        return this;
    }

    public static Bitmap loadBitmap(String url){
        if(url == null || "".equals(url)){
            return null;
        }

        HttpParams p = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(p,NETWORK_CONNECT_TIMEOUT);
        HttpConnectionParams.setSoTimeout(p,NETWORK_SO_TIMEOUT);

        DefaultHttpClient mHttpClient = new DefaultHttpClient(p);

        HttpGet mHttpGet = null;
        try{
            mHttpGet= new HttpGet(url);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

        InputStream inputStream = null;
        HttpEntity resEntity = null;
        try{
            HttpResponse response = mHttpClient.execute(mHttpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            resEntity = response.getEntity();
            inputStream = resEntity.getContent();
            int length = (int)resEntity.getContentLength();
            if(length == 0){
                inputStream.close();
                return null;
            }
            if(length == -1)
                length = 1024*1024+4096;
            byte[] buffer = new byte[length];

            if(buffer == null){
                inputStream.close();
                return null;
            }

            int n;
            int rlength = 0;
            while ((n = inputStream.read(buffer,rlength,40960)) >= 0) {
                rlength += n;
                if(rlength > length){
                    buffer = null;
                    inputStream.close();
                    return null;
                }
            }
            inputStream.close();
            Bitmap bmp = BitmapFactory.decodeByteArray(buffer,0,rlength);
            buffer=null;
            return bmp;

        }catch(OutOfMemoryError oe){
            Log.i(LOG_TAG, "OutOfMemoryError : " + oe);
            return null;
        }catch(Exception e){
            Log.i(LOG_TAG, "Exception : " + e);
            return null;
        }
    }


    public static void loadImage(ImageView view,String url){
        final String  mUrl = url;
        final ImageView mView= view;
        new Thread(new Runnable(){
            public void run() {
                Drawable d = null;
                //	Log.d("loadImage","murl:"+mUrl);
                final Bitmap bmp = loadBitmap(mUrl);
                if(bmp !=null){
                    mView.post(new Runnable(){
                        public void run() {
                            mView.setImageBitmap(bmp);
                            //	Log.d("loadImage","setImageDrawable");
                        }});
                }
            }}).start();
    }

    public A loadImage(String url){
        if( data!= null && data instanceof ImageView){
            loadImage((ImageView)data,url);
        }
        return this;
    }
    static int nMaxThreadNum = 10;
    static int nThreadLoadImage = 0;
    static Object mLoadImageLock = new Object();

    public static void setMaxThreadNum(int max){
        nMaxThreadNum = max;
    }

    public static void loadImageLimited(final ImageView view,final String url){
        final String  mUrl = url;
        final ImageView mView= view;


        synchronized(mLoadImageLock) {
            if(nThreadLoadImage > nMaxThreadNum){
                //	Log.d(LOG_TAG,"loadImageLimited postDelayed this request. url:"+mUrl);
                view.postDelayed(new Runnable(){

                    public void run() {
                        // TODO Auto-generated method stub
                        loadImageLimited(view,url);
                    }
                },2000);
                return;
            }
        }


        new Thread(new Runnable(){
            public void run() {

                Boolean loop = true;
                int try_time = 20;
                while(loop){
                    synchronized(mLoadImageLock) {
                        if(nThreadLoadImage < nMaxThreadNum){
                            loop = false;
                            break;
                        }
                    }
                    try_time --;
                    if(try_time == 0){
                        break;
                    }
                    try {
                        //	Log.d(LOG_TAG,"loadImageLimited checking nThread:"+nThreadLoadImage + " v:"+mView.getVisibility()+"url:"+mUrl);
                        Object ob = mView.getTag();
                        if( ob != null && ob instanceof String){
                            if(!((String)ob).equals(mUrl)){
                                Log.d(LOG_TAG,"loadImageLimited the url is outtime. oldUrl:"+mUrl+" newUrl:"+(String)ob);
                                return;
                            }
                        }
                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                    }
                }

                Object ob = mView.getTag();
                if( ob != null && ob instanceof String){
                    if(!((String)ob).equals(mUrl)){
                        return;
                    }
                }

                //	Log.d(LOG_TAG,"loadImageLimited begin load nThread:"+nThreadLoadImage + " v:"+mView.getVisibility());

                synchronized(mLoadImageLock) {
                    nThreadLoadImage ++;
                }
                Drawable d = null;
                try {
                    //	Log.d(LOG_TAG,"loadImageLimited loading the image murl:" + mUrl);
                    final Bitmap bmp = loadBitmap(mUrl);
                    if(bmp !=null){
                        ob = mView.getTag();
                        if( ob != null && ob instanceof String){
                            if(((String)ob).equals(mUrl)){
                                mView.post(new Runnable(){
                                    public void run() {
										/* to see whether the activity is show ? */
                                        if (mView.getWindowVisibility() == View.VISIBLE) {
                                            mView.setImageBitmap(bmp);
                                            //	Log.d(LOG_TAG,"loadImageLimited update image v:" + mView + "from:"+mUrl);
                                        } else {
                                            Log.d(LOG_TAG,"loadImageLimited update image cancled");
                                        }
                                    }});
                            }else{
                                Log.d(LOG_TAG,"loadImageLimited error 1 url:" + mUrl);
                            }
                        }else{
                            Log.d(LOG_TAG,"loadImageLimited error 2 url:" + mUrl);
                        }
                    }else{
                        Log.d(LOG_TAG,"loadImageLimited error 3 url:" + mUrl);
                    }
                }catch(Exception e2){
                    Log.d(LOG_TAG,"loadImageLimited error 4 url:"+mUrl);
                    e2.printStackTrace();
                }finally{
                    synchronized(mLoadImageLock) {
                        nThreadLoadImage --;
                    }
                }
            }}).start();
    }

    public A loadImageLimited(String url){
        if( data!= null && data instanceof ImageView){
            loadImageLimited((ImageView)data,url);
        }
        return this;
    }


    public A setMaxHeight(int maxHeight){
        if ( data!= null && data instanceof ImageView){
            ((ImageView)data).setMaxHeight(maxHeight);
        }
        return this;
    }

    public A setMaxWidth(int maxWidth){
        if ( data!= null && data instanceof ImageView){
            ((ImageView)data).setMaxWidth(maxWidth);
        }
        return this;
    }

    public A setScaleType(ImageView.ScaleType scaleType){
        if ( data!= null && data instanceof ImageView){
            ((ImageView)data).setScaleType(scaleType);
        }
        return this;
    }


    // ViewGroup

    public A addView (View child, int index){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).addView(child,index);
        }
        return this;
    }

    public A addView(View child, int width, int height){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).addView(child,width,height);
        }
        return this;
    }

    public A addView (View child, int index, ViewGroup.LayoutParams params){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).addView(child,index,params);
        }
        return this;
    }

    public A addView (View child){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).addView(child);
        }
        return this;
    }

    public A bringChildToFront (View child){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).bringChildToFront(child);
        }
        return this;
    }


    public View getChildAt(int index){
        if ( data!= null && data instanceof ViewGroup){
            return ((ViewGroup)data).getChildAt(index);
        }
        return null;
    }

    public int getChildCount(){
        if ( data!= null && data instanceof ViewGroup){
            return ((ViewGroup)data).getChildCount();
        }
        return 0;
    }

    public View getFocusedChild(){
        if ( data!= null && data instanceof ViewGroup){
            return ((ViewGroup)data).getFocusedChild();
        }
        return null;
    }

    public int indexOfChild(View child){
        if ( data!= null && data instanceof ViewGroup){
            return ((ViewGroup)data).indexOfChild(child);
        }
        return -1;
    }


    public A removeAllViews(){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).removeAllViews();
        }
        return this;
    }

    public A removeView(View view){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).removeView(view);
        }
        return this;
    }

    public A removeViewAt(int index){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).removeViewAt(index);
        }
        return this;
    }

    public A removeViews(int start, int count){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).removeViews(start,count);
        }
        return this;
    }

    public A setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener listener){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).setOnHierarchyChangeListener(listener);
        }
        return this;
    }

    public A startLayoutAnimation(){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).startLayoutAnimation();
        }
        return this;
    }

    public A updateViewLayout(View view, ViewGroup.LayoutParams params){
        if ( data!= null && data instanceof ViewGroup){
            ((ViewGroup)data).updateViewLayout(view,params);
        }
        return this;
    }


    // FrameLayout

    public A setForeground(Drawable drawable){
        if ( data!= null && data instanceof FrameLayout){
            ((FrameLayout)data).setForeground(drawable);
        }
        return this;
    }

    public A setForegroundGravity(int foregroundGravity){
        if ( data!= null && data instanceof FrameLayout){
            ((FrameLayout)data).setForegroundGravity(foregroundGravity);
        }
        return this;
    }

    // ViewAnimator
    public A setDisplayedChild(int index){
        if ( data!= null && data instanceof ViewAnimator){
            ((ViewAnimator)data).setDisplayedChild(index);
        }
        return this;
    }
    // LinearLayout

	/* public Q setGravity(int gravity) :  defined before */

    public A setHorizontalGravity(int horizontalGravity){
        if ( data!= null ){
            if(data instanceof LinearLayout){
                ((LinearLayout)data).setHorizontalGravity(horizontalGravity);
            }else if(data instanceof RelativeLayout){
                ((RelativeLayout)data).setHorizontalGravity(horizontalGravity);
            }
        }
        return this;
    }

    public A setVerticalGravity(int verticalGravity){
        if ( data!= null ){
            if(data instanceof LinearLayout){
                ((LinearLayout)data).setVerticalGravity(verticalGravity);
            }else if(data instanceof RelativeLayout){
                ((RelativeLayout)data).setVerticalGravity(verticalGravity);
            }
        }
        return this;
    }

    public A setOrientation(int orientation){
        if ( data!= null && data instanceof LinearLayout){
            ((LinearLayout)data).setOrientation(orientation);
        }
        return this;
    }

    public int getOrientation(){
        if ( data!= null && data instanceof LinearLayout){
            ((LinearLayout)data).getOrientation();
        }
        return -1;
    }

    // RelativeLayout

    // AdapterView

    public A onItemClick(AdapterView.OnItemClickListener l){
        if(data !=null){
            if(data instanceof AdapterView)
                ((AdapterView) data).setOnItemClickListener(l);
        }
        return this;
    }

    public A onItemLongClick(AdapterView.OnItemLongClickListener l){
        if(data !=null){
            if(data instanceof AdapterView)
                ((AdapterView) data).setOnItemLongClickListener(l);
        }
        return this;
    }

    public A onItemSelected(AdapterView.OnItemSelectedListener l){
        if(data !=null){
            if(data instanceof AdapterView)
                ((AdapterView) data).setOnItemSelectedListener(l);
        }
        return this;
    }


    public int getCount(){
        if(data !=null){
            if(data instanceof AdapterView)
                ((AdapterView) data).getCount();
        }
        return 0;
    }

    public A performItemClick(View view, int position, long id){
        if(data !=null){
            if(data instanceof AdapterView)
                ((AdapterView) data).performItemClick(view,position,id);
        }
        return this;
    }

    // ListView
    public A addHeaderView(View v, Object data, boolean isSelectable){
        if( data instanceof ListView){
            ((ListView)data).addHeaderView(v,data,isSelectable);
        }
        return this;
    }

    public A addHeaderView(View v){
        if( data instanceof ListView){
            ((ListView)data).addHeaderView(v);
        }
        return this;
    }

    public A addFooterView(View v, Object data, boolean isSelectable){
        if( data instanceof ListView){
            ((ListView)data).addFooterView(v,data,isSelectable);
        }
        return this;
    }

    public A addFooterView(View v){
        if( data instanceof ListView){
            ((ListView)data).addFooterView(v);
        }
        return this;
    }

    public ListAdapter getAdapter(){
        if(data !=null){
            if(data instanceof ListView)
                return ((ListView) data).getAdapter();
            else if(data instanceof GridView){
                return ((GridView) data).getAdapter();
            }
        }
        return null;
    }

    public A notifyDataSetChanged(){
        ListAdapter ad = null;
        if(data != null){
            if( data instanceof ExpandableListView){
                ExpandableListAdapter ead =  ((ExpandableListView) data).getExpandableListAdapter();
                if( ead != null ) {
                    if( ead instanceof BaseExpandableListAdapter)
                        ((BaseExpandableListAdapter)ead).notifyDataSetChanged();
                    else if( ead instanceof SimpleExpandableListAdapter)
                        ((SimpleExpandableListAdapter)ead).notifyDataSetChanged();
                }
            }if(data instanceof ListView)
                ad =  ((ListView) data).getAdapter();
            if(ad instanceof BaseAdapter){
                ((BaseAdapter)ad).notifyDataSetChanged();
            }else if( ad instanceof HeaderViewListAdapter){
                BaseAdapter baseAdapter = (BaseAdapter)((HeaderViewListAdapter)ad).getWrappedAdapter();
                if( baseAdapter != null )
                    baseAdapter.notifyDataSetChanged();
            }
            else if(data instanceof GridView){
                ad = (BaseAdapter)((GridView) data).getAdapter();
                if(ad instanceof BaseAdapter){
                    ((BaseAdapter)ad).notifyDataSetChanged();
                }
            }else if(data instanceof AbsSpinner){
                ad = (BaseAdapter)((AbsSpinner) data).getAdapter();
                if(ad instanceof BaseAdapter){
                    ((BaseAdapter)ad).notifyDataSetChanged();
                }
            }
        }
        return this;
    }

    // AbsSpinner
    public A setSelection(int position){
        if(data !=null){
            if(data instanceof AbsSpinner)
                ((AbsSpinner) data).setSelection(position);
        }
        return this;
    }

    public A setSelection(int position, boolean animate){
        if(data !=null){
            if(data instanceof AbsSpinner)
                ((AbsSpinner) data).setSelection(position,animate);
        }
        return this;
    }

    /////////////////////

    // Attributes

    public int id(){
        if(data!=null){
            return data.getId();
        }
        return 0;
    }

    public int width(){
        return getWidth();
    }

    public int height(){
        return getHeight();
    }
    public int left(){
        return getLeft();
    }

    public int top(){
        return getTop();
    }

    public int right(){
        return getRight();
    }

    public int bottom(){
        return getBottom();
    }

    public static ViewGroup.LayoutParams layout(View view){
        if(view != null)
            return view.getLayoutParams();
        return null;
    }

    public static void layout(View view,ViewGroup.LayoutParams l){
        if(view != null )
            view.setLayoutParams(l);
    }

    public ViewGroup.LayoutParams layout(){
        return layout(data);
    }

    public A layout(ViewGroup.LayoutParams l){
        layout(data,l);
        return this;
    }

    public A text(String val){
        setText(val);
        return this;
    }
    public CharSequence text(){
        return getText();
    }

    // Traversing

    /*only support one element. todo : support mutiplies? */
    public View get(){
        return data;
    }

    public int length(){
        if(data != null)
            return 1;
        else
            return 0;
    }

    public int index(){
        return 0;
    }

    public static View find(View view,int id){
        if(view !=null){
            if(view instanceof ViewGroup)
                return ((ViewGroup)view).findViewById(id);
        }
        return null;
    }

    public A find(int id){
        return $(find(data,id));
    }

    public static View children(View parent,int index){
        if(parent !=null){
            if(parent instanceof ViewGroup)
                return ((ViewGroup)parent).getChildAt(index);
        }
        return null;
    }

    public A children(int index){
        return $(children(data,index));
    }

    public static View parent(View view){
        if(view !=null){
            return (View) view.getParent();
        }
        return null;
    }

    public A parent(){
        return $(parent(data));
    }

    public static View root(View view){
        if(view !=null){
            return (View) view.getRootView();
        }
        return null;
    }

    public A root(){
        return $(root(data));
    }


    public static View next(View element){
        if( element != null){
            ViewGroup parent = (ViewGroup) element.getParent();
            int postion = parent.indexOfChild(element);
            int count = parent.getChildCount();
            if(postion<count-1){
                parent.getChildAt(postion+1);
            }
        }
        return null;
    }

    public static View prev(View element){
        if( element != null){
            ViewGroup parent = (ViewGroup) element.getParent();
            int postion = parent.indexOfChild(element);
            if(postion > 0){
                parent.getChildAt(postion-1);
            }
        }
        return null;
    }

    public A prev(){
        return $(prev(data));
    }
    public A next(){
        return $(next(data));
    }


    // Manipulation

    public static void append(View parent,View child){
        if(parent !=null){
            if(parent instanceof ViewGroup){
                ((ViewGroup)parent).addView(child);
            }
        }
    }
    public  A append(View child){
        append(data,child);
        return this;
    }

    public static void appendTo(View view,View parent){
        if(view != null){
            if(view.getParent() == null){
                append(parent,view);
            }
        }
    }

    public A appendTo(A parent){
        appendTo(data,parent.get());
        return this;
    }

    /* todo : check and test */
    public static void insertAfter(View element,View target){
        if(element != null && target != null && element.getParent() == null){
            ViewGroup parent = (ViewGroup) target.getParent();
            int postion = parent.indexOfChild(target);
            if(postion != -1){
                parent.addView(element, postion+1);
            }
        }
    }

    public static void insertBefore(View element,View target){
        if(element != null && target != null && element.getParent() == null){
            ViewGroup parent = (ViewGroup) target.getParent();
            int postion = parent.indexOfChild(target);
            if(postion != -1){
                parent.addView(element, postion);
            }
        }
    }

    public A insertAfter(View target){
        insertAfter(data,target);
        return this;
    }

    public A insertBefore(View target){
        insertBefore(data,target);
        return this;
    }

    public static void remove(View parent,View child){
        if(parent !=null){
            if(parent instanceof ViewGroup){
                ((ViewGroup)parent).removeView(child);
            }
        }
    }

    public A remove(View child){
        remove(data,child);
        return this;
    }

    public static void empty(View parent){
        if(parent != null && parent instanceof ViewGroup){
            ((ViewGroup)parent).removeAllViews();
        }
    }

    public A empty(){
        empty(data);
        return this;
    }

    public A removeAll(){
        return empty();
    }



    // Event

    public A focus(View.OnFocusChangeListener l){
        if(data !=null){
            data.setOnFocusChangeListener(l);
        }
        return this;
    }

    public A focus(){
        if(data !=null){
            data.requestFocus();
        }
        return this;
    }

    public A click(View.OnClickListener l){
        if(data !=null){
            data.setOnClickListener(l);
        }
        return this;
    }

    public A click(){
        if(data !=null){
            data.performClick();
        }
        return this;
    }

    public A keypress(View.OnKeyListener l){
        if(data !=null){
            data.setOnKeyListener(l);
        }
        return this;
    }

    public A change(TextWatcher watcher){
        if ( data!= null && data instanceof TextView){
            ((TextView)data).addTextChangedListener(watcher);
        }
        return this;
    }


    // Effects

    public A show()
    {
        if(data != null){
            data.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public A show(boolean visible)
    {
        if(visible){
            return show();
        }else{
            return hide();
        }
    }

    public A hide()
    {
        if(data != null){
            data.setVisibility(View.INVISIBLE);
        }
        return this;
    }

    public A gone()
    {
        if(data != null){
            data.setVisibility(View.GONE);
        }
        return this;
    }

    public A animate(Context context,int res){
        if(data != null){
            Animation animation = AnimationUtils.loadAnimation(context,res);
            data.startAnimation(animation);
        }
        return this;
    }

    /* box GradientDrawable */
    public A box(int width,int color,float dashWidth,float dashGap,int bgColor,float radius){
        if( data != null){
            GradientDrawable d1=new GradientDrawable();
            d1.setStroke(width,color,dashWidth,dashGap);
            d1.setColor(bgColor);
            d1.setCornerRadius(radius);
            data.setBackgroundDrawable(d1);
        }
        return this;
    }

    public A box(int width,int color){
        return box(width,color,1,0,0x00000000,0);
    }

    public A box(int width){
        return box(width,0xffffffff,1,0,0x00000000,0);
    }


    // data

    public A setAdapter(Adapter adapter){
        if(data != null){
            if(data instanceof AdapterView){
                ((AdapterView)data).setAdapter(adapter);
            }
        }
        return this;
    }

    public Object data(int key){
        if(data != null){
            return data.getTag(key);
        }
        return null;
    }

    public A data(int key,Object tag){
        if(data != null){
            data.setTag(key, tag);
        }
        return this;
    }

    public Object data(){
        if(data != null){
            return data.getTag();
        }
        return null;
    }

    public A data(Object tag){
        if(data != null){
            data.setTag(tag);
        }
        return this;
    }
    // window setInterval setTimeout

    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            // TODO Auto-generated method stub

        }

    };

    static Timer setInterval(TimerTask task, int millisec){
        Timer t = new Timer();
        t.schedule(task,0,millisec);
        return t;
    }

    static void clearInterval(Timer t){
        t.cancel();
    }

    // ajax
    public interface AjaxOption {
        public void prepare();
        public void execute(InputStream inputStream);
        public void execute(Bitmap bitmap);
        public void finish();
        public void error(int code);
    };


    private static int NETWORK_CONNECT_TIMEOUT = 30000;
    private static int NETWORK_SO_TIMEOUT = 30000;

    public static InputStream get_stream(String url,HttpParams params,Header []headers,Cookie []cookies){
        HttpParams p;
        if( params == null){
            p = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(p,NETWORK_CONNECT_TIMEOUT);
            HttpConnectionParams.setSoTimeout(p,NETWORK_SO_TIMEOUT);
        }else{
            p = params.copy();
        }

        DefaultHttpClient mHttpClient = new DefaultHttpClient(p);

        HttpGet mHttpGet = new HttpGet(url);
        if( headers != null){
            mHttpGet.setHeaders(headers);
        }

        if(cookies != null){
            CookieStore cs = mHttpClient.getCookieStore();
            for(int i=0;i<cookies.length;i++){
                cs.addCookie(cookies[i]);

            }
            mHttpClient.setCookieStore(cs);
        }

        InputStream inputStream = null;
        HttpEntity resEntity = null;
        try{
            HttpResponse response = mHttpClient.execute(mHttpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            resEntity = response.getEntity();
            inputStream = resEntity.getContent();
        }catch(Exception e){
            Log.i(LOG_TAG, "Exception : " + e);
        }

        return inputStream;
    }

    public static InputStream post_stream(String url,HttpParams params,Header []headers,Cookie []cookies,HttpEntity entity){
        HttpParams p;
        if( params == null){
            p = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(p,NETWORK_CONNECT_TIMEOUT);
            HttpConnectionParams.setSoTimeout(p,NETWORK_SO_TIMEOUT);
        }else{
            p = params.copy();
        }

        DefaultHttpClient mHttpClient = new DefaultHttpClient(p);

        HttpPost mHttpPost = new HttpPost(url);
        if( headers != null){
            mHttpPost.setHeaders(headers);
        }

        if( entity != null ){
            mHttpPost.setEntity(entity);
        }


        if(cookies != null){
            CookieStore cs = mHttpClient.getCookieStore();
            for(int i=0;i<cookies.length;i++){
                cs.addCookie(cookies[i]);

            }
            mHttpClient.setCookieStore(cs);
        }

        InputStream inputStream = null;
        try{
            HttpResponse response = mHttpClient.execute(mHttpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity resEntity = response.getEntity();
            inputStream = resEntity.getContent();
        }catch(Exception e){
            Log.i(LOG_TAG, "Exception : " + e);
        }

        return inputStream;
    }



    public static void get(final String url,final HttpParams params,final Header []headers,final Cookie []cookies,final AjaxOption option){
        option.prepare();
        new Thread(new Runnable(){
            public void run() {
                InputStream inputStream = get_stream(url,params,headers,cookies);
                if(inputStream != null){
                    option.execute(inputStream);
                }else{
                    option.error(ERROR_NETWORK);
                }
                option.finish();
            }}).start();
    }
    public static void get(final String url,final Header []headers,final Cookie []cookies,final AjaxOption option){
        get(url,null,headers,cookies,option);
    }
    public static void get(final String url,final Header []headers,final AjaxOption option){
        get(url,null,headers,null,option);
    }
    public static void get(final String url,final AjaxOption option){
        get(url,null,null,null,option);
    }

    public static void post(final String url,final HttpParams params,final Header [] headers,final Cookie []cookies,final HttpEntity entity,final AjaxOption option){
        option.prepare();
        new Thread(new Runnable(){
            public void run() {
                InputStream inputStream = post_stream(url,params,headers,cookies,entity);
                if(inputStream != null){
                    option.execute(inputStream);
                }else{
                    option.error(ERROR_NETWORK);
                }
                option.finish();
            }}).start();
    }

    public static void post(final String url,final Header [] headers,final Cookie []cookies,final HttpEntity entity,final AjaxOption option){
        post(url,null,headers,cookies,entity,option);
    }

    public static void post(final String url,final Header [] headers,final HttpEntity entity,final AjaxOption option){
        post(url,null,headers,null,entity,option);
    }

    public static void post(final String url,final HttpEntity entity,final AjaxOption option){
        post(url,null,null,null,entity,option);
    }

    public static void post(final String url,final AjaxOption option){
        post(url,null,null,null,null,option);
    }

    public static boolean check(String url) {
        HttpGet mHttpGet = new HttpGet(url);
        HttpParams p = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(p,10000);
        HttpConnectionParams.setSoTimeout(p,10000);
        DefaultHttpClient mHttpClient = new DefaultHttpClient(p);
        try {
            HttpResponse response = mHttpClient.execute(mHttpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public interface LoadOption{
        public void complete(View view);
    }

    public static void  load(View contaier,int contentResId,LoadOption option){
        if(contaier != null && contaier instanceof ViewGroup){
            View child = View.inflate(contaier.getContext(), contentResId,null);
            if( child != null){
                ((ViewGroup)contaier).removeAllViews();
                ((ViewGroup)contaier).addView(child);
                if(option != null){
                    option.complete(child);
                }
            }
        }
    }

    public A load(int contentResId,LoadOption option){
        load(data,contentResId,option);
        return this;
    }

}
