package granule.dimoge.me.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import granule.dimoge.me.R;

/**
 * Created by dime on 2015/8/8 0008.
 */
public class AccountCreateDialog extends Dialog {

    Window window;

    public AccountCreateDialog(Context context, int theme) {
        super(context, theme);
    }

    /**
     * dialog初始化方法, 所有初始化操作当在这里
     */
    public void showDialog(){
        setContentView(R.layout.dialog_account_create);
        window = getWindow();
        setCanceledOnTouchOutside(false);//不允许触摸消失
        show();//显示出来
    }
}
