package linghit.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import linghit.com.myapplication.Handler.PostHandlerUtil;

public class MainActivity extends AppCompatActivity {
    PostHandlerUtil mHandlerUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandlerUtil = new PostHandlerUtil(this);
        mHandlerUtil.looper().obtainMessage(1);
    }
}
