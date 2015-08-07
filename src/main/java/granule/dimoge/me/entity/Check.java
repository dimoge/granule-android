package granule.dimoge.me.entity;

import java.util.Date;

/**
 * Created by dime on 2015/8/7 0007.
 */
public class Check {
    private int id;
    private Date date;//日期
    private String remark;//备注

    public Check(){
    }

    public Check(Date date, String remark, int id) {
        this.date = date;
        this.remark = remark;
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
