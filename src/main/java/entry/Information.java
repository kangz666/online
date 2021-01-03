package entry;

/**
 * @author kangz
 * @date 2020-12-26
 */
public class Information {
    //商品信息表（商品编号，商品名称，类别编号，数量，单价，图片，描述）
    private String information_number;
    private String information_name;
    private String category_number;
    private int information_sum;
    private float information_price;
    private String information_picture;
    private String information_text;

    public Information(){

    }
    public Information(String information_number, String information_name,
                       String categroy_number, int information_sum,
                       float information_price, String information_picture,
                       String information_text) {
        this.information_number = information_number;
        this.information_name = information_name;
        this.category_number = categroy_number;
        this.information_sum = information_sum;
        this.information_price = information_price;
        this.information_picture = information_picture;
        this.information_text = information_text;
    }

    @Override
    public String toString() {
        return "Information{" +
                "information_number='" + information_number + '\'' +
                ", information_name='" + information_name + '\'' +
                ", category_number='" + category_number + '\'' +
                ", information_sum=" + information_sum +
                ", information_price=" + information_price +
                ", information_picture='" + information_picture + '\'' +
                ", information_text='" + information_text + '\'' +
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

    public String getCategory_number() {
        return category_number;
    }

    public void setCategory_number(String categroy_number) {
        this.category_number = categroy_number;
    }

    public int getInformation_sum() {
        return information_sum;
    }

    public void setInformation_sum(int information_sum) {
        this.information_sum = information_sum;
    }

    public float getInformation_price() {
        return information_price;
    }

    public void setInformation_price(float information_price) {
        this.information_price = information_price;
    }

    public String getInformation_picture() {
        return information_picture;
    }

    public void setInformation_picture(String information_picture) {
        this.information_picture = information_picture;
    }

    public String getInformation_text() {
        return information_text;
    }

    public void setInformation_text(String information_text) {
        this.information_text = information_text;
    }
}
