package granule.dimoge.me.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import granule.dimoge.me.entity.Account;
import granule.dimoge.me.utils.MySQLiteHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dime on 2015/8/11 0011.
 */
public class AccountBiz {

    Context context;
    MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(context);
    SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

    public AccountBiz(Context context) {
        this.context = context;
    }


    /**
     * 添加操作
     * @param contentValues
     * @return
     */
    public long add(ContentValues contentValues){
       long result = db.insert("account", null,  contentValues);
       return result;
    }

    /**
     * 获取所有account
     * @return
     */
    public List<Account> getAll(){
        List<Account> accountList = new ArrayList<Account>();
        Cursor cursor = db.rawQuery("SELECT * FROM account", null);
        while (cursor.moveToNext()){
            Account account = new Account();
            account.setId( Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))) );
            account.setUserId(cursor.getString(cursor.getColumnIndex("userId")));
            account.setImg(cursor.getString(cursor.getColumnIndex("img")));
            account.setTotal(Float.parseFloat(cursor.getString(cursor.getColumnIndex("total"))));
            account.setExpend(Float.parseFloat(cursor.getString(cursor.getColumnIndex("expend"))));
            account.setIncome(Float.parseFloat(cursor.getString(cursor.getColumnIndex("income"))));
            account.setDate(new Date(cursor.getString(cursor.getColumnIndex("date"))));
            accountList.add(account);
        }
        return accountList;
    }

}
