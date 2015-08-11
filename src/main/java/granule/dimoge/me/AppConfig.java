package granule.dimoge.me;

import granule.dimoge.me.entity.User;

/**
 * Created by dime on 2015/8/10 0010.
 */
public class AppConfig {

    public static String DB_NAME = "granule_db";//数据库名
    public static int DB_VERSION = 1;//数据库版本号

    public static User user = new User();//用户信息

    //返回键点击次数
    public static int clickCount = 0;
}
