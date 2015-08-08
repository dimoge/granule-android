package granule.dimoge.me.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import granule.dimoge.me.R;

public class AppStart extends Activity {

    Context context;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            startActivity(new Intent(AppStart.this, AccountActivity.class));
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
