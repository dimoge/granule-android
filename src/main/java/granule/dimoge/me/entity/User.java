package granule.dimoge.me.entity;

/**
 * Created by dime on 2015/8/8 0008.
 */
public class User {
    private String id;//通过手机生成的deviceid
    private String name;//默认为 default_user
    private int sex;//1, 0 默认为1
    private int age;
    private String tel;
    private String email;

    public User() {
    }

    public User(String id, String name, int age, int sex, String tel, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.tel = tel;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
