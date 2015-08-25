package granule.dimoge.me.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import granule.dimoge.me.R;
import granule.dimoge.me.adapter.AccountListAdapter;
import granule.dimoge.me.biz.AccountBiz;
import granule.dimoge.me.dialog.AccountCreateDialog;
import granule.dimoge.me.entity.Account;

import java.text.ParseException;
import java.util.List;

/**
 * Created by dime on 2015/8/8 0008.
 */
public class AccountActivity extends Activity{
    Context context;
    public static AccountListAdapter accountListAdapter;

    ImageView account_add_img;//添加账户的按钮
    SwipeMenuListView account_lv;//账户列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        context = this;

        try {
            initView();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        initClick();
    }

    /**
     * 控件初始化
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void initView() throws ParseException {
        account_lv = (SwipeMenuListView) findViewById(R.id.account_lv);
        //获取数据
        AccountBiz accountBiz = new AccountBiz(context);
        List<Account> accountList = accountBiz.getAll();
        //ListView添加footer
        account_add_img = new ImageView(context);
        ListView.LayoutParams params = new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.MATCH_PARENT);
        account_add_img.setLayoutParams(params);
        account_add_img.setImageResource(R.mipmap.account_add);
        account_add_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加用户
                new AccountCreateDialog(context, R.style.account_create_style).showDialog();
            }
        });
        account_lv.addFooterView(account_add_img);
        //初始化适配器
        accountListAdapter = new AccountListAdapter(context, accountList);
        account_lv.setAdapter(accountListAdapter);
    }

    /**
     * 点击事件初始化
     */
    private void initClick() {

    }

        @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //返回键监听, 直接回到桌面
        Intent home = new Intent(Intent.ACTION_MAIN);
        home.addCategory(Intent.CATEGORY_HOME);
        startActivity(home);
        return super.onKeyDown(keyCode, event);
    }


}
