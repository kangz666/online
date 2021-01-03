package entry;

/**
 * @author kangz
 * @date 2020-12-26
 */
public class User {
//    会员 会员帐号，真实姓名，密码，身份证号，地址，电话，Email，QQ
    private String user_number;
    private String user_name;
    private String user_password;
    private String user_id;
    private String user_address;
    private String user_phone;
    private String user_email;
    private String user_qq;
    public User(){}
//构造方法
    public User(String user_number, String user_name,
                String user_password, String user_id,
                String user_address, String user_phone,
                String user_email, String user_qq) {
        this.user_number = user_number;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_id = user_id;
        this.user_address = user_address;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.user_qq = user_qq;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_number='" + user_number + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_qq='" + user_qq + '\'' +
                '}';
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }
}
