package granule.dimoge.me.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import granule.dimoge.me.AppConfig;
import granule.dimoge.me.R;
import granule.dimoge.me.adapter.AccountListAdapter;
import granule.dimoge.me.dialog.AccountCreateDialog;
import granule.dimoge.me.entity.Account;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dime on 2015/8/8 0008.
 */
public class AccountActivity extends Activity implements View.OnClickListener {
    Context context;

    ImageView account_add_img;//添加账户的按钮
    ListView account_lv;//账户列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        context = this;
        
        initView();
        initClick();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case 1:
                //TODO:添加新账户
                new AccountCreateDialog(context, R.style.account_create_style).showDialog();
                break;
            default:return;
        }
    }

    /**
     * 控件初始化
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void initView() {
        account_lv = (ListView) findViewById(R.id.account_lv);
        /////TODO:模拟假数据显示listview
        List<Account> accountList = new ArrayList<Account>();
        for(int i=0 ; i<5 ; i++ ){
            Account account = new Account();
            account.setId(i);
            account.setUserId(AppConfig.user.getId());
            account.setImg(R.mipmap.cash + "");
            account.setTotal(1024);
            account.setExpend(77);
            account.setIncome(66);
            account.setDate(new Date());
            accountList.add(account);
        }//数据准备完毕
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
        AccountListAdapter accountListAdapter = new AccountListAdapter(context, accountList);
        account_lv.setAdapter(accountListAdapter);

    }

    /**
     * 点击事件初始化
     */
    private void initClick() {
    }


}
