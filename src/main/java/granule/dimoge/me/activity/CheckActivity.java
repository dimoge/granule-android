package granule.dimoge.me.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import granule.dimoge.me.R;
import granule.dimoge.me.adapter.CheckLlistAdapter;
import granule.dimoge.me.biz.CheckBiz;
import granule.dimoge.me.dialog.CheckCreateDialog;
import granule.dimoge.me.entity.Check;

import java.text.ParseException;
import java.util.List;

/**
 * Created by dime on 2015/8/7 0007.
 */
public class CheckActivity extends Activity implements View.OnClickListener {

    int accountId;
    public static CheckLlistAdapter checkLlistAdapter;

    Context context;
    ImageButton check_create_imgBtn;//创建账单
    ListView check_lv;//账单列表
    CheckBiz checkBiz;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        context = this;
        accountId = Integer.parseInt( getIntent().getStringExtra("accountId") );
        try {
            initView();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        initClick();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check_create_imgBtn:
                //TODO:创建一个新的账单
                CheckCreateDialog checkCreateDialog = new CheckCreateDialog(context, R.style.account_create_style, accountId);
                checkCreateDialog.showDialog();
                break;
            default:return;
        }
    }

    private void initView() throws ParseException {
        check_create_imgBtn = (ImageButton) findViewById(R.id.check_create_imgBtn);
        check_lv = (ListView) findViewById(R.id.check_lv);


         CheckBiz checkBiz = new CheckBiz(context);
        List<Check> checkList = checkBiz.getAll(accountId);
        /////模拟假数据, 加入到适配器中
        checkLlistAdapter = new CheckLlistAdapter(context, checkList);
        check_lv.setAdapter(checkLlistAdapter);
        check_lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "我被长按喽!!!!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void initClick() {
        check_create_imgBtn.setOnClickListener(this);
    }



}
