package granule.dimoge.me.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import granule.dimoge.me.entity.Check;
import granule.dimoge.me.utils.CommonUtil;
import java.util.List;

import granule.dimoge.me.utils.MySQLiteHelper;

import java.text.ParseException;
import java.util.ArrayList;
/**
 * Created by dime on 2015/8/14 0014.
 */
public class CheckBiz {

    Context context;

    public CheckBiz(Context context) {
        this.context = context;
    }

    public long add(ContentValues contentValues){
        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(context);
        SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();
        return db.insert("checks", null, contentValues);
    }

    /**
     * 获取所有账单
     * @return
     * @throws ParseException
     */
    public List<Check> getAll(int accountId) throws ParseException {
        List<Check> checkList = new ArrayList<Check>();
        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(context);
        SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from check where accountId="+accountId, null);
        while (cursor.moveToNext()){
            Check check = new Check();
            check.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))));
            check.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            check.setRemark(cursor.getString(cursor.getColumnIndex("remark")));
            check.setAmount(Float.parseFloat(cursor.getString(cursor.getColumnIndex("amount"))));
            check.setAccountId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("accountId"))));
            check.setDate(CommonUtil.Str2Date(cursor.getString(cursor.getColumnIndex("date"))));
            checkList.add(check);
        }
        return checkList;
    }

}
