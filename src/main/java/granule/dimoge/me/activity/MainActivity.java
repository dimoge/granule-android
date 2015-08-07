package granule.dimoge.me.activity;

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
import granule.dimoge.me.R;

/**
 * Created by dime on 2015/8/7 0007.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    TextView create_check_tv;//�������˵�
    ListView check_lv;//�˵��б�

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
            case R.id.create_check_tv:
                //TODO:�����µ��˵�
                break;
            default:return;
        }
    }

    private void initView() {
        create_check_tv = (TextView) findViewById(R.id.create_check_tv);
        check_lv = (ListView) findViewById(R.id.check_lv);

        create_check_tv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG ); //�»���
    }

    private void initClick() {
        create_check_tv.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //�������ؼ�, ���ص�����
        Intent home = new Intent(Intent.ACTION_MAIN);
        home.addCategory(Intent.CATEGORY_HOME);
        startActivity(home);
        return super.onKeyDown(keyCode, event);
    }


}