package linghit.com.myapplication.Handler;

/**
 * <b>Create Date:</b> 2018/10/16<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongson
 */
interface IPostHandler {
    void post(Runnable runnable);

    void postDelayed(Runnable runnable, long delayMillis);
}
