package granule.dimoge.me.dialog;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import granule.dimoge.me.AppConfig;
import granule.dimoge.me.R;
import granule.dimoge.me.entity.Account;
import granule.dimoge.me.utils.CommonUtil;

import java.util.Date;

/**
 * Created by dime on 2015/8/8 0008.
 */
public class AccountCreateDialog extends Dialog implements View.OnClickListener {

    Window window;
    Context context;
    Account account;

    EditText account_name_edtTxt;//账户名称
    RadioGroup account_icon_rdoGroup;//账户图标选择
    RadioButton account_cash;//现金账户
    EditText account_total_edtTxt;//账户总额
    Button account_create_no_btn,account_create_yes_btn;//  确认/取消按钮


    public AccountCreateDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;

    }

    /**
     * dialog初始化方法, 所有初始化操作当在这里
     */
    public void showDialog(){
        setContentView(R.layout.dialog_account_create);
        window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = CommonUtil.dip2px(context,350);
        layoutParams.height = CommonUtil.dip2px(context, 300);
        window.setAttributes(layoutParams);
        setCanceledOnTouchOutside(false);//不允许触摸消失

        initView();//初始化控件
        initClick();//初始化控件点击事件


        show();//显示出来
    }

    private void initClick() {
        account_create_yes_btn.setOnClickListener(this);
        account_create_no_btn.setOnClickListener(this);
    }

    private void initView() {
        account_name_edtTxt = (EditText) findViewById(R.id.account_name_edtTxt);
        account_icon_rdoGroup = (RadioGroup) findViewById(R.id.account_icon_rdoGroup);
        account_cash = (RadioButton) findViewById(R.id.account_cash);
        account_total_edtTxt = (EditText) findViewById(R.id.account_total_edtTxt);
        account_create_no_btn = (Button) findViewById(R.id.account_create_no_btn);
        account_create_yes_btn = (Button) findViewById(R.id.account_create_yes_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.account_create_yes_btn:
                //TODO:确定
                account = new Account();
                account.setId(0);
                account.setUserId(AppConfig.user.getId());
                account.setName(account_name_edtTxt.getText().toString().trim());
                account.setExpend(0);//总支出 默认为0
                account.setIncome(0);//总收入 默认为0
                account.setTotal(Float.parseFloat(account_total_edtTxt.getText().toString().trim()));//总金额
                account.setImg((account_cash.getId() == account_icon_rdoGroup.getCheckedRadioButtonId() ? R.mipmap.cash : R.mipmap.incash) + "");
                account.setDate(new Date());
                break;
            case R.id.account_create_no_btn:
                //取消
                this.dismiss();
                break;
            default:return;
        }
    }
}
