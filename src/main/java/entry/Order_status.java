package entry;

/**
 * @author kangz
 * @date 2020-12-26
 */
public class Order_status {
//    订单状态表（状态编号，订单状态）
    private String status_number;
    private String order_status;

    public Order_status(String status_number, String order_status) {
        this.status_number = status_number;
        this.order_status = order_status;
    }
    public Order_status(){}
    @Override
    public String toString() {
        return "Order_status{" +
                "status_number='" + status_number + '\'' +
                ", order_status='" + order_status + '\'' +
                '}';
    }

    public String getStatus_number() {
        return status_number;
    }

    public void setStatus_number(String status_number) {
        this.status_number = status_number;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}
