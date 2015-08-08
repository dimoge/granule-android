package granule.dimoge.me.entity;

import java.util.Date;

/**
 * Created by dime on 2015/8/8 0008.
 * 账户实体
 */
public class Account {
    private String id;
    private String user;//拥有者
    private String name;//账户名称
    private String img;//图标
    private float expend;//总支出
    private float income;//总收入
    private Date date;//创建时间

    public Account() {
    }

    public Account(String id, String name, String img, float expend, float income, Date date) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.expend = expend;
        this.income = income;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getExpend() {
        return expend;
    }

    public void setExpend(float expend) {
        this.expend = expend;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
