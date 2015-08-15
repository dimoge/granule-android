package granule.dimoge.me.dialog;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import granule.dimoge.me.AppConfig;
import granule.dimoge.me.R;
import granule.dimoge.me.activity.CheckActivity;
import granule.dimoge.me.adapter.CheckLlistAdapter;
import granule.dimoge.me.biz.CheckBiz;
import granule.dimoge.me.entity.Check;
import granule.dimoge.me.utils.CommonUtil;

import java.util.Date;

/**
 * Created by dime on 2015/8/15 0015.
 */
public class CheckCreateDialog extends Dialog implements View.OnClickListener {

    Context context;
    Window window;
    int accountId;
    CheckActivity checkActivity = new CheckActivity();

    EditText check_title_edtTxt, check_remark_edtTxt, check_amount_edtTxt;//标题, 备注, 金额
    RadioGroup check_icon_rdoGroup;
    RadioButton check_out_radioBtn;
    Button check_create_no_btn, check_create_yes_btn;

    public CheckCreateDialog(Context context, int theme, int accountId) {
        super(context, theme);
        this.context = context;
        this.accountId = accountId;
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

    private void initView() {
        check_title_edtTxt = (EditText) findViewById(R.id.check_title_edtTxt);
        check_remark_edtTxt = (EditText) findViewById(R.id.check_remark_edtTxt);
        check_amount_edtTxt = (EditText) findViewById(R.id.check_amount_edtTxt);
        check_icon_rdoGroup = (RadioGroup) findViewById(R.id.check_icon_rdoGroup);
        check_out_radioBtn = (RadioButton) findViewById(R.id.check_out_radioBtn);
        check_create_no_btn = (Button) findViewById(R.id.check_create_no_btn);
        check_create_yes_btn = (Button) findViewById(R.id.check_create_yes_btn);
    }

    private void initClick() {
        check_create_no_btn.setOnClickListener(this);
        check_create_yes_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check_create_no_btn:
                dismiss();
                break;
            case R.id.check_create_yes_btn:
                if(TextUtils.isEmpty(check_title_edtTxt.getText()) ||
                        TextUtils.isEmpty(check_remark_edtTxt.getText() )||
                        TextUtils.isEmpty(check_amount_edtTxt.getText())){
                    //有空数据, 不允许添加账单
                    Toast.makeText(context, "不允许添加空数据", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    String title, remark;
                    float amount;
                    title = check_title_edtTxt.getText().toString().trim();
                    remark = check_remark_edtTxt.getText().toString().trim();
                    amount = check_icon_rdoGroup.getCheckedRadioButtonId()==check_out_radioBtn.getId()?-Float.parseFloat(check_amount_edtTxt.getText().toString().trim()):Float.parseFloat(check_amount_edtTxt.getText().toString().trim());
                    //构造参数
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("accountId", accountId);
                    Date date = new Date();
                    contentValues.put("date", CommonUtil.Date2Str(date));
                    contentValues.put("title", title);
                    contentValues.put("remark", remark);
                    contentValues.put("amount", amount);
                    contentValues.put("userId", AppConfig.user.getId());
                    //构造一个对象
                    Check check = new Check();
                    check.setId(checkActivity.checkLlistAdapter.checkList.size());
                    check.setTitle(title);
                    check.setRemark(remark);
                    check.setDate(date);
                    check.setAmount(amount);
                    //执行数据库添加操作
                    CheckBiz checkBiz = new CheckBiz(context);
                    if(checkBiz.add(contentValues)!=-1){
                        Toast.makeText(context, "添加账单成功:"+ title, Toast.LENGTH_SHORT).show();
                        //刷新适配器
                        checkActivity.checkLlistAdapter.checkList.add(check);
                        checkActivity.checkLlistAdapter.notifyDataSetChanged();//通知适配器数据已经修改
                        dismiss();
                    }else {
                        Toast.makeText(context, "添加账单失败", Toast.LENGTH_SHORT).show();
                    }
                }
                dismiss();
                break;
            default:return;
        }
    }
}
