package granule.dimoge.me.dialog;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import granule.dimoge.me.R;
import granule.dimoge.me.utils.CommonUtil;

/**
 * Created by dime on 2015/8/8 0008.
 */
public class AccountCreateDialog extends Dialog {

    Window window;
    Context context;

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
        show();//显示出来
    }
}
