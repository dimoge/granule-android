package granule.dimoge.me.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import granule.dimoge.me.R;
import granule.dimoge.me.utils.MySQLiteHelper;

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

        MySQLiteHelper dbHelper = new MySQLiteHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user", null);



        handler.sendEmptyMessageDelayed(0,2000);
    }

}
