package granule.dimoge.me.dialog;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import granule.dimoge.me.R;
import granule.dimoge.me.activity.AccountActivity;
import granule.dimoge.me.biz.AccountBiz;
import granule.dimoge.me.entity.Account;
import granule.dimoge.me.utils.CommonUtil;

/**
 * Created by dime on 2015/8/13 0013.
 */
public class AccountUpdateDialog extends Dialog implements View.OnClickListener {

    Context context;
    Window window;
    Account account;
    int position;
    AccountBiz accountBiz;
    AccountActivity accountActivity = new AccountActivity();

    EditText account_name_update_edtTxt, account_total_update_edtTxt;
    Button account_update_no_btn, account_update_yes_btn;

    public AccountUpdateDialog(Context context, int theme, Account account, int position) {
        super(context, theme);
        this.context = context;
        this.account = account;
        this.position = position;
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
                if(TextUtils.isEmpty( account_name_update_edtTxt.getText() ) && TextUtils.isEmpty( account_total_update_edtTxt.getText() ) ){
                    Toast.makeText(context, "空信息不允许修改!!!", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    if ( account_name_update_edtTxt.toString().trim().equals(account.getName()) &&
                            account_total_update_edtTxt.getText().toString().toString().equals(account.getTotal()) ){
                        //信息没有修改
                        Toast.makeText(context, "并没有修改任何信息!!!", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        //验证正确
                        ContentValues contentValues = new ContentValues();//构造参数
                        String name = account_name_update_edtTxt.getText().toString().trim();
                        float total = Float.parseFloat(account_total_update_edtTxt.getText().toString().trim());
                        contentValues.put("name", name);
                        contentValues.put("total", total);
                        accountBiz = new AccountBiz(context);
                        accountBiz.update(contentValues, account.getId() + "");//操作数据库, 执行修改操作
                        //刷新适配器
                        account.setName(name);
                        account.setTotal(total);
                        accountActivity.accountListAdapter.accountList.remove(position);
                        accountActivity.accountListAdapter.accountList.add(position, account);
                        accountActivity.accountListAdapter.notifyDataSetChanged();//通知适配器
                        Toast.makeText(context, "修改成功!!!!", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }
                }

                break;
            case R.id.account_update_no_btn://放弃修改
                dismiss();
                break;
            default:return;
        }
    }
}
