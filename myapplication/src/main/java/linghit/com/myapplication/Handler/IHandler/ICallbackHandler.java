package linghit.com.myapplication.Handler.IHandler;

import android.os.Handler;

/**
 * <b>Create Date:</b> 2018/10/16<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongson
 */
public interface ICallbackHandler {

    void onCreate(Handler.Callback callback);

    void sendToTarget(int what, Object object);
}
