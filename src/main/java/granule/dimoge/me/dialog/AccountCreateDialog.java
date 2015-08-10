package granule.dimoge.me.dialog;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import granule.dimoge.me.R;
import granule.dimoge.me.utils.CommonUtil;

/**
 * Created by dime on 2015/8/8 0008.
 */
public class AccountCreateDialog extends Dialog {

    Window window;
    Context context;

    EditText account_name_edtTxt;//账户名称
    RadioGroup account_icon_rdoGroup;//账户图标选择
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


        show();//显示出来
    }

    private void initView() {
        account_name_edtTxt = (EditText) findViewById(R.id.account_name_edtTxt);
        account_icon_rdoGroup = (RadioGroup) findViewById(R.id.account_icon_rdoGroup);
        account_total_edtTxt = (EditText) findViewById(R.id.account_total_edtTxt);
        account_create_no_btn = (Button) findViewById(R.id.account_create_no_btn);
        account_create_yes_btn = (Button) findViewById(R.id.account_create_yes_btn);
    }
}
