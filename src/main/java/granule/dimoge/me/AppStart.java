package granule.dimoge.me;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class AppStart extends Activity {

    Context context;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            context.startActivity(new Intent(AppStart.this, MainActivity.class));
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);
        context = this;
        handler.sendEmptyMessageDelayed(0,2000);
    }

}
