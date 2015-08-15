package granule.dimoge.me.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import granule.dimoge.me.R;
import granule.dimoge.me.entity.Check;

import java.util.List;

/**
 * Created by dime on 2015/8/7 0007.
 */
public class CheckLlistAdapter extends BaseAdapter {

    Context context;
    public static List<Check> checkList;//数据

    ImageView check_item_img;
    TextView check_item_title_tv;
    TextView check_item_date_tv;
    TextView check_item_remark_tv;

    public CheckLlistAdapter(Context context, List<Check> checkList){
        this.context = context;
        this.checkList = checkList;
    }


    @Override
    public int getCount() {
        return checkList.size();
    }

    @Override
    public Object getItem(int position) {
        return checkList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return checkList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_check, null);//加载布局文件
            //控件初始化
            check_item_img = (ImageView) convertView.findViewById(R.id.check_item_img);
            check_item_title_tv = (TextView) convertView.findViewById(R.id.check_item_title_tv);
            check_item_date_tv = (TextView) convertView.findViewById(R.id.check_item_date_tv);
            check_item_remark_tv = (TextView) convertView.findViewById(R.id.check_item_remark_tv);
        }
        check_item_remark_tv.setText(checkList.get(position).getRemark());
        check_item_date_tv.setText(checkList.get(position).getDate().toString());
        check_item_title_tv.setText(checkList.get(position).getTitle());
        return convertView;
    }
}
