package entry;

/**
 * @author kangz
 * @date 2020-12-26
 */
public class Category {
//    商品类别表（类别编号，类别名称）
    private String category_number;
    private String category_name;

    public Category(){

    }
    public Category(String category_number, String category_name) {
        this.category_number = category_number;
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "category{" +
                "category_number='" + category_number + '\'' +
                ", category_name='" + category_name + '\'' +
                '}';
    }

    public String getCategory_number() {
        return category_number;
    }

    public void setCategory_number(String category_number) {
        this.category_number = category_number;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
