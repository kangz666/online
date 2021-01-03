package entry;

/**
 * @author kangz
 * @date 2020-12-26
 */
public class Cart {
//    购物车表 商品编号，商品名称，用户编号，单价，数量，金额
    private String information_number;
    private String information_name;
    private String user_number;
    private float information_price;
    private int sum;
    private float money;
    public Cart(){

    }
//构造函数
    public Cart(String information_number, String information_name,
                String user_number, float information_price,
                int sum, float money) {
        this.information_number = information_number;
        this.information_name = information_name;
        this.user_number = user_number;
        this.information_price = information_price;
        this.sum = sum;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "information_number='" + information_number + '\'' +
                ", information_name='" + information_name + '\'' +
                ", user_number='" + user_number + '\'' +
                ", information_price=" + information_price +
                ", sum=" + sum +
                ", money=" + money +
                '}';
    }

    public String getInformation_number() {
        return information_number;
    }

    public void setInformation_number(String information_number) {
        this.information_number = information_number;
    }

    public String getInformation_name() {
        return information_name;
    }

    public void setInformation_name(String information_name) {
        this.information_name = information_name;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public float getInformation_price() {
        return information_price;
    }

    public void setInformation_price(float information_price) {
        this.information_price = information_price;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
