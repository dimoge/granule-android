package granule.dimoge.me.entity;

import java.util.Date;

/**
 * Created by dime on 2015/8/7 0007.
 */
public class Check {
    private int id;
    private String accountId;//所属账户id
    private Date date;//日期
    private String title;//标题
    private String remark;//备注

    public Check(){
    }

    public Check(int id, String accountId, Date date, String title, String remark) {
        this.id = id;
        this.accountId = accountId;
        this.date = date;
        this.title = title;
        this.remark = remark;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
