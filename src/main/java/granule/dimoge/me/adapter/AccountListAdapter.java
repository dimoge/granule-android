package granule.dimoge.me.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import granule.dimoge.me.R;
import granule.dimoge.me.entity.Account;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by dime on 2015/8/11 0011.
 */
public class AccountListAdapter extends BaseAdapter {


    Context context;
    public List<Account> accountList;

    ImageView account_icon_img;//账户图标
    TextView account_name_tv, account_total_tv;//账户名称, 账户总额
    ImageButton account_update_imgBtn;//账户信息修改

    public AccountListAdapter(Context context, List<Account> accountList) {
        this.accountList = accountList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return accountList.size();
    }

    @Override
    public Object getItem(int position) {
        return accountList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_account, null);//加载布局文件
            //控件初始化
            account_icon_img = (ImageView) convertView.findViewById(R.id.account_icon_img);
            account_name_tv = (TextView) convertView.findViewById(R.id.account_name_tv);
            account_total_tv = (TextView) convertView.findViewById(R.id.account_total_tv);
            account_update_imgBtn = (ImageButton) convertView.findViewById(R.id.account_update_imgBtn);
        }
        account_name_tv.setText(accountList.get(position).getName());
        account_total_tv.setText("总金额:"+accountList.get(position).getTotal());
        account_icon_img.setImageResource(accountList.get(position).getImg().equals("cash")?R.mipmap.cash:R.mipmap.incash);

        return convertView;
    }
}
