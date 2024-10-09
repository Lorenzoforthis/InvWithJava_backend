package Stock.models;

public class DataModel {
    Long id = 0L;
    String orderNo = "";
    String comName = "";
    float price = 0;
    int quantity = 0;

    @Override
    public String toString() {
        return "DataModel [id=" + id + ", orderNo=" + orderNo + ", comName=" + comName + ", price=" + price
                + ", quantity=" + quantity + "]";
    }

    
    public DataModel(Long id, String orderNo, String comName, float price, int quantity) {
        super();
        this.id = id;
        this.orderNo = orderNo;
        this.comName = comName;
        this.price = price;
        this.quantity = quantity;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getComName() {
        return comName;
    }
    public void setComName(String comName) {
        this.comName = comName;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
