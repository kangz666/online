package entry;

/**
 * @author kangz
 * @date 2020-12-26
 */
public class Admin {
//    管理员表  （管理员编号，管理员名称，密码 电话）

    private String admin_number;
    private String admin_password;
    private String admin_name;
    private String admin_phone;

    public Admin() {
    }

    public Admin(String admin_number, String admin_password,
                 String admin_name, String admin_phone) {
        this.admin_number = admin_number;
        this.admin_password = admin_password;
        this.admin_name = admin_name;
        this.admin_phone = admin_phone;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_number='" + admin_number + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", admin_name='" + admin_name + '\'' +
                ", admin_phone='" + admin_phone + '\'' +
                '}';
    }

    public String getAdmin_number() {
        return admin_number;
    }

    public void setAdmin_number(String admin_number) {
        this.admin_number = admin_number;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone;
    }
}
