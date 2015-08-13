package granule.dimoge.me.entity;

import java.util.Date;

/**
 * Created by dime on 2015/8/8 0008.
 * 账户实体
 */
public class Account {
    private int id;
    private String userId;//拥有者
    private String name;//账户名称
    private String img;//图标
    private float total;//总额
    private float expend;//总支出
    private float income;//总收入
    private Date date;//创建时间

    public Account() {
    }

    public Account(int id, String userId, String name, String img, float total, float expend, float income, Date date) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.img = img;
        this.total = total;
        this.expend = expend;
        this.income = income;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
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
