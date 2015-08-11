package granule.dimoge.me.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import granule.dimoge.me.R;
import granule.dimoge.me.utils.CommonUtil;
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
        if( cursor.moveToFirst() ){
            //旧用户
            Toast.makeText(context, "欢迎回来:"+cursor.getString(cursor.getColumnIndex("name")), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "新用户, 添加数据库", Toast.LENGTH_SHORT).show();//TODO:DELETE
            //新用户, 要注册哦
            ContentValues cv = new ContentValues();
            cv.put("id", CommonUtil.getDeviceId(context));
            cv.put("name","default_user");
            cv.put("sex",1+"");
            cv.put("age","");
            cv.put("tel","");
            cv.put("email", "");
            db.insert("user", null, cv);//insert返回一个long的行号(并不是id,染病暖)
        }

        handler.sendEmptyMessageDelayed(0,2000);
    }

}
