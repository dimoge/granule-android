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
        //初始化数据库
        db.execSQL("CREATE TABLE user(id varchar(32), name TEXT, sex INTEGER, age integer, tel TEXT, email TEXT)");//创建用户表
        db.execSQL("CREATE TABLE account(id INTEGER primary key autoincrement, user TEXT, name TEXT, img TEXT, total FLOAT, expend FLOAT, income FLOAT, date DATE)");//创建账户表
        db.execSQL("CREATE TABLE check(id TEXT primary key autoincrement, accountId INTEGER, date DATE, title TEXT, remark TEXT)");//创建 账单表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO:当数据库版本号发生改变时, 需要做哪些操作呢????
    }

}