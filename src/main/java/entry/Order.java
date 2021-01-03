package entry;

/**
 * @author kangz
 * @date 2020-12-26
 */
public class Order {
    //订单编号，订单商品编号，商品总价，买家编号，收货人姓名，收货地址，联系方式，状态编号
    private String order_number;
    private String information_number;
    private String goods_price;
    private String user_number;
    private String user_name;
    private String user_address;
    private String user_phone;
    private String status_number;
    public Order(){}
//构造函数
    public Order(String order_number, String information_number,
                 String goods_price, String user_number, String user_name,
                 String user_address, String user_phone, String status_number) {
        this.order_number = order_number;
        this.information_number = information_number;
        this.goods_price = goods_price;
        this.user_number = user_number;
        this.user_name = user_name;
        this.user_address = user_address;
        this.user_phone = user_phone;
        this.status_number = status_number;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_number='" + order_number + '\'' +
                ", information_number='" + information_number + '\'' +
                ", goods_price='" + goods_price + '\'' +
                ", user_number='" + user_number + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", status_number='" + status_number + '\'' +
                '}';
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getInformation_number() {
        return information_number;
    }

    public void setInformation_number(String information_number) {
        this.information_number = information_number;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getStatus_number() {
        return status_number;
    }

    public void setStatus_number(String status_number) {
        this.status_number = status_number;
    }
}
