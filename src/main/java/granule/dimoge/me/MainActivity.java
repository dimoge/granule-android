package granule.dimoge.me;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by dime on 2015/8/7 0007.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    TextView create_note_tv;//创建新账单
    ListView note_title_lv;//账单列表

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initClick();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_note_tv:
                //TODO:创建新的账单
                break;
            default:return;
        }
    }

    private void initView() {
        create_note_tv = (TextView) findViewById(R.id.create_note_tv);
        note_title_lv = (ListView) findViewById(R.id.note_title_lv);

        create_note_tv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG ); //下划线
    }

    private void initClick() {
        create_note_tv.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //监听返回键, 返回到桌面
        Intent home = new Intent(Intent.ACTION_MAIN);
        home.addCategory(Intent.CATEGORY_HOME);
        startActivity(home);
        return super.onKeyDown(keyCode, event);
    }


}
