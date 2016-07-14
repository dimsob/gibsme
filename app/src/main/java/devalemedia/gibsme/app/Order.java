package devalemedia.gibsme.app;

/**
 * Created by admin on 02.07.2016.
 */

public class Order {
    int order_id;
    String order_title, order_desc, order_category, order_status, order_added_date, order_copleted_date,
            order_image, order_address, order_to_date;
    long order_executor;
    long order_customer;
    double order_lat, order_longt;

    public Order() {
    }

    public Order(int order_id, String order_title, String order_desc, String order_category, String order_status, String order_added_date, String order_copleted_date, String order_image, String order_address, String order_to_date, long order_executor, long order_customer, double order_lat, double order_longt) {
        this.order_id = order_id;
        this.order_title = order_title;
        this.order_desc = order_desc;
        this.order_category = order_category;
        this.order_status = order_status;
        this.order_added_date = order_added_date;
        this.order_copleted_date = order_copleted_date;
        this.order_image = order_image;
        this.order_address = order_address;
        this.order_to_date = order_to_date;
        this.order_executor = order_executor;
        this.order_customer = order_customer;
        this.order_lat = order_lat;
        this.order_longt = order_longt;
    }

    public Order(String order_title, String order_desc, String order_category, String order_status, String order_added_date, String order_copleted_date, String order_image, String order_address, String order_to_date, long order_executor, long order_customer, double order_lat, double order_longt) {
        this.order_title = order_title;
        this.order_desc = order_desc;
        this.order_category = order_category;
        this.order_status = order_status;
        this.order_added_date = order_added_date;
        this.order_copleted_date = order_copleted_date;
        this.order_image = order_image;
        this.order_address = order_address;
        this.order_to_date = order_to_date;
        this.order_executor = order_executor;
        this.order_customer = order_customer;
        this.order_lat = order_lat;
        this.order_longt = order_longt;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_title() {
        return order_title;
    }

    public void setOrder_title(String order_title) {
        this.order_title = order_title;
    }

    public String getOrder_desc() {
        return order_desc;
    }

    public void setOrder_desc(String order_desc) {
        this.order_desc = order_desc;
    }

    public String getOrder_category() {
        return order_category;
    }

    public void setOrder_category(String order_category) {
        this.order_category = order_category;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_added_date() {
        return order_added_date;
    }

    public void setOrder_added_date(String order_added_date) {
        this.order_added_date = order_added_date;
    }

    public String getOrder_copleted_date() {
        return order_copleted_date;
    }

    public void setOrder_copleted_date(String order_copleted_date) {
        this.order_copleted_date = order_copleted_date;
    }

    public String getOrder_image() {
        return order_image;
    }

    public void setOrder_image(String order_image) {
        this.order_image = order_image;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public String getOrder_to_date() {
        return order_to_date;
    }

    public void setOrder_to_date(String order_to_date) {
        this.order_to_date = order_to_date;
    }

    public long getOrder_executor() {
        return order_executor;
    }

    public void setOrder_executor(long order_executor) {
        this.order_executor = order_executor;
    }

    public long getOrder_customer() {
        return order_customer;
    }

    public void setOrder_customer(long order_customer) {
        this.order_customer = order_customer;
    }

    public double getOrder_lat() {
        return order_lat;
    }

    public void setOrder_lat(double order_lat) {
        this.order_lat = order_lat;
    }

    public double getOrder_longt() {
        return order_longt;
    }

    public void setOrder_longt(double order_longt) {
        this.order_longt = order_longt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_title='" + order_title + '\'' +
                ", order_desc='" + order_desc + '\'' +
                ", order_category='" + order_category + '\'' +
                ", order_status='" + order_status + '\'' +
                ", order_added_date='" + order_added_date + '\'' +
                ", order_copleted_date='" + order_copleted_date + '\'' +
                ", order_image='" + order_image + '\'' +
                ", order_address='" + order_address + '\'' +
                ", order_to_date='" + order_to_date + '\'' +
                ", order_executor=" + order_executor +
                ", order_customer=" + order_customer +
                ", order_lat=" + order_lat +
                ", order_longt=" + order_longt +
                '}';
    }
}
