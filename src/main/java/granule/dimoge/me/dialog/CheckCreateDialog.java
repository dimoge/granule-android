package granule.dimoge.me.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import granule.dimoge.me.R;
import granule.dimoge.me.utils.CommonUtil;

/**
 * Created by dime on 2015/8/15 0015.
 */
public class CheckCreateDialog extends Dialog {

    Context context;
    Window window;

    EditText check_title_edtTxt, check_remark_edtTxt, check_amount_edtTxt;//标题, 备注, 金额
    RadioGroup account_icon_rdoGroup;
    RadioButton check_out_radioBtn;

    public CheckCreateDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    public void showDialog(){
        setContentView(R.layout.dialog_check_create);
        window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = CommonUtil.dip2px(context, 350);
        layoutParams.height = CommonUtil.dip2px(context, 350);
        window.setAttributes(layoutParams);
        setCanceledOnTouchOutside(false);//不允许触摸消失

        initView();//初始化控件
        initClick();//初始化控件点击事件

        show();
    }

    private void initClick() {
        check_title_edtTxt = (EditText) findViewById(R.id.check_title_edtTxt);
        check_remark_edtTxt = (EditText) findViewById(R.id.check_remark_edtTxt);
        check_amount_edtTxt = (EditText) findViewById(R.id.check_amount_edtTxt);
        account_icon_rdoGroup = (RadioGroup) findViewById(R.id.account_icon_rdoGroup);
        check_out_radioBtn = (RadioButton) findViewById(R.id.check_out_radioBtn);
    }

    private void initView() {

    }
}
