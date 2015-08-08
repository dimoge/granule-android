package granule.dimoge.me.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import granule.dimoge.me.R;
import granule.dimoge.me.dialog.AccountCreateDialog;

/**
 * Created by dime on 2015/8/8 0008.
 */
public class AccountActivity extends Activity implements View.OnClickListener {

    Button account_add_btn;//添加账户的按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        
        initView();
        initClick();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.account_add_btn:
                //TODO:添加新账户
                break;
            default:return;
        }
    }

    /**
     * 控件初始化
     */
    private void initView() {
        account_add_btn = (Button) findViewById(R.id.account_add_btn);
    }

    /**
     * 点击事件初始化
     */
    private void initClick() {
        account_add_btn.setOnClickListener(this);
    }


}
