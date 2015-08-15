package granule.dimoge.me.entity;

import java.util.Date;

/**
 * Created by dime on 2015/8/7 0007.
 */
public class Check {
    private int id;
    private int accountId;//所属账户id
    private String userId;//所属用户id
    private Date date;//日期
    private String title;//标题
    private String remark;//备注
    private float amount;//金额, 有正负之分

    public Check(){
    }

    public Check(int id, int accountId, String userId, Date date, String title, String remark, float amount) {
        this.id = id;
        this.accountId = accountId;
        this.userId = userId;
        this.date = date;
        this.title = title;
        this.remark = remark;
        this.amount = amount;
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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
