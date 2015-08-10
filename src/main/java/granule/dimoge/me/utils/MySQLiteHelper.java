package granule.dimoge.me.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import granule.dimoge.me.AppConfig;

/**
 * Created by dime on 2015/8/10 0010.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public MySQLiteHelper(Context context){
        super(context, AppConfig.DB_NAME, null, AppConfig.DB_VERSION);
    }

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(id text, name TEXT, sex INTEGER, age INTEGER, tel TEXT, email TEXT)");//创建用户表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO:当数据库版本号发生改变时, 需要做哪些操作呢????
    }

}