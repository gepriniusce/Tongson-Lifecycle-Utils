package linghit.com.myapplication.Handler;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * <b>Create Date:</b> 2018/10/15<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongson
 */
public class PostHandlerUtil implements LifecycleObserver, ICallbackHandler, IPostHandler, IMainHandler {

    private Activity mActivity;
    private Handler mHandler;
    private Handler mMainHandler;
    private Handler mCallbackHandler;
    private Handler mLooperHandler;

    public PostHandlerUtil(Activity activity) {
        mActivity = activity;
        if (mActivity instanceof FragmentActivity) {
            ((FragmentActivity) mActivity).getLifecycle().addObserver(this);
        }
        if (mActivity instanceof AppCompatActivity) {
            ((AppCompatActivity) mActivity).getLifecycle().addObserver(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        mHandler = new Handler();
        mMainHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onCreate(Handler.Callback callback) {
        mCallbackHandler = new Handler(callback);
    }

    @Override
    public void sendToTarget(int what, Object object) {
        mHandler.obtainMessage(what, object).sendToTarget();
    }

    @Override
    public void postDelayedMain(Runnable runnable, long delayMillis) {
        mMainHandler.postDelayed(runnable, delayMillis);

    }

    @Override
    public void postMain(Runnable runnable) {
        mMainHandler.post(runnable);
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }

    @Override
    public void postDelayed(Runnable runnable, long delayMillis) {
        mHandler.postDelayed(runnable, delayMillis);
    }

    public Handler looper() {
        Looper.prepare();
        mLooperHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.i("Tongson ","what:"+msg.what);
            }
        };
        Looper.loop();
        return mLooperHandler;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        looper().removeCallbacksAndMessages(null);
        mMainHandler.removeCallbacksAndMessages(null);
        mHandler.removeCallbacksAndMessages(null);
        mCallbackHandler.removeCallbacksAndMessages(null);
    }
}
