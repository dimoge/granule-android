package granule.dimoge.me.dialog;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import granule.dimoge.me.AppConfig;
import granule.dimoge.me.R;
import granule.dimoge.me.biz.AccountBiz;
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
                //TODO:确定添加
                //获取参数
                String name;
                float total, expend = 0, income = 0;//总金额, 总支出(默认为0), 总收入(默认为0)
                //用户输入不为空验证
                if(!TextUtils.isEmpty(account_name_edtTxt.getText()) && !TextUtils.isEmpty(account_total_edtTxt.getText())){//不为空
                    name = account_name_edtTxt.getText().toString().trim();//账户名称
                    total =Float.parseFloat(account_total_edtTxt.getText().toString().toString());
                }else{
                    Toast.makeText(context, "请填写账户信息", Toast.LENGTH_SHORT).show();
                    return;
                }
                String img = (account_cash.getId() == account_icon_rdoGroup.getCheckedRadioButtonId() ? R.mipmap.cash : R.mipmap.incash) + "";//账户图片
                ContentValues contentValues = new ContentValues();
//                contentValues.put("id", 0);
                contentValues.put("userId", AppConfig.user.getId());
                contentValues.put("name", name);
                contentValues.put("img", img);
                contentValues.put("total", total);
                contentValues.put("expend", expend);
                contentValues.put("income", income);
                contentValues.put("date", String.valueOf(new Date()));
                //执行添加
                AccountBiz accountBiz = new AccountBiz(context);
                if(accountBiz.add(contentValues)!=-1){
                    Toast.makeText(context, "账户添加成功:"+name, Toast.LENGTH_SHORT).show();
                    this.dismiss();
                }else {
                    Toast.makeText(context, "账户添加失败,请重试!!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.account_create_no_btn:
                //取消
                this.dismiss();
                break;
            default:return;
        }
    }
}
