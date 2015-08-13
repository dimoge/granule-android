package granule.dimoge.me.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import granule.dimoge.me.R;
import granule.dimoge.me.entity.Account;
import granule.dimoge.me.utils.CommonUtil;

/**
 * Created by dime on 2015/8/13 0013.
 */
public class AccountUpdateDialog extends Dialog implements View.OnClickListener {

    Context context;
    Window window;
    Account account;

    EditText account_name_update_edtTxt, account_total_update_edtTxt;
    Button account_update_no_btn, account_update_yes_btn;

    public AccountUpdateDialog(Context context, int theme, Account account) {
        super(context, theme);
        this.context = context;
        this.account = account;
    }

    /**
     * dialog初始化方法, 所有初始化操作当在这里
     */
    public void showDialog(){
        setContentView(R.layout.dialog_account_update);
        window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = CommonUtil.dip2px(context, 350);
        layoutParams.height = CommonUtil.dip2px(context, 300);
        window.setAttributes(layoutParams);
        setCanceledOnTouchOutside(false);//不允许触摸消失

        initView();//初始化控件
        initClick();//初始化控件点击事件


        show();//显示出来
    }

    private void initClick() {
        account_update_yes_btn.setOnClickListener(this);
        account_update_no_btn.setOnClickListener(this);
    }

    private void initView() {
        account_total_update_edtTxt = (EditText) findViewById(R.id.account_total_update_edtTxt);
        account_name_update_edtTxt = (EditText) findViewById(R.id.account_name_update_edtTxt);
        account_update_no_btn = (Button) findViewById(R.id.account_update_no_btn);
        account_update_yes_btn = (Button) findViewById(R.id.account_update_yes_btn);

        account_name_update_edtTxt.setText(account.getName());
        account_total_update_edtTxt.setText(account.getTotal()+"");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.account_update_yes_btn://修改
                //TODO
                break;
            case R.id.account_update_no_btn://放弃修改
                //TODO
                break;
            default:return;
        }
    }
}
