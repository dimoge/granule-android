package granule.dimoge.me.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dime on 2015/8/10 0010.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "granule_db";//数据库名
    private static final int version = 1;//数据库版本

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
