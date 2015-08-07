package granule.dimoge.me.entity;

import java.util.Date;

/**
 * Created by dime on 2015/8/7 0007.
 */
public class Check {
    private Date date;//ÈÕÆÚ
    private String remark;//±¸×¢

    public Check(Date date, String remark) {
        this.date = date;
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
