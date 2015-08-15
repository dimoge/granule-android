package granule.dimoge.me.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import granule.dimoge.me.R;
import granule.dimoge.me.entity.Check;
import granule.dimoge.me.utils.CommonUtil;

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
    TextView check_item_amount_tv;
    LinearLayout check_item_layout;

    public CheckLlistAdapter(Context context, List<Check> checkList) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.adapter_check, null);//加载布局文件
        //控件初始化
        check_item_img = (ImageView) convertView.findViewById(R.id.check_item_img);
        check_item_title_tv = (TextView) convertView.findViewById(R.id.check_item_title_tv);
        check_item_date_tv = (TextView) convertView.findViewById(R.id.check_item_date_tv);
        check_item_remark_tv = (TextView) convertView.findViewById(R.id.check_item_remark_tv);
        check_item_layout = (LinearLayout) convertView.findViewById(R.id.check_item_layout);
        check_item_amount_tv = (TextView) convertView.findViewById(R.id.check_item_amount_tv);
        //控件设值
        check_item_remark_tv.setText(checkList.get(position).getRemark());
        check_item_date_tv.setText(CommonUtil.Date2Str(checkList.get(position).getDate()));
        check_item_title_tv.setText(checkList.get(position).getTitle());
        check_item_amount_tv.setText("金额:"+checkList.get(position).getAmount()+"");
        check_item_layout.setBackgroundColor(checkList.get(position).getAmount()>0?Color.parseColor("#698B22"):Color.parseColor("#FF0000"));
        return convertView;
    }
}
