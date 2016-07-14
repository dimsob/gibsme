package devalemedia.gibsme.app;

/**
 * Created by admin on 13.07.2016.
 */

public class User {

    int user_id;
    String user_name, user_phone, user_password, user_completed_orders, user_placed_orders, user_completed_rating, user_placed_rating, user_profile_foto;

    public User() {
    }

    public User(int user_id, String user_name, String user_phone, String user_password, String user_completed_orders, String user_placed_orders, String user_completed_rating, String user_placed_rating, String user_profile_foto) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_password = user_password;
        this.user_completed_orders = user_completed_orders;
        this.user_placed_orders = user_placed_orders;
        this.user_completed_rating = user_completed_rating;
        this.user_placed_rating = user_placed_rating;
        this.user_profile_foto = user_profile_foto;
    }

    public User(String user_name, String user_phone, String user_password, String user_completed_orders, String user_placed_orders, String user_completed_rating, String user_placed_rating, String user_profile_foto) {
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_password = user_password;
        this.user_completed_orders = user_completed_orders;
        this.user_placed_orders = user_placed_orders;
        this.user_completed_rating = user_completed_rating;
        this.user_placed_rating = user_placed_rating;
        this.user_profile_foto = user_profile_foto;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_completed_orders() {
        return user_completed_orders;
    }

    public void setUser_completed_orders(String user_completed_orders) {
        this.user_completed_orders = user_completed_orders;
    }

    public String getUser_placed_orders() {
        return user_placed_orders;
    }

    public void setUser_placed_orders(String user_placed_orders) {
        this.user_placed_orders = user_placed_orders;
    }

    public String getUser_completed_rating() {
        return user_completed_rating;
    }

    public void setUser_completed_rating(String user_completed_rating) {
        this.user_completed_rating = user_completed_rating;
    }

    public String getUser_placed_rating() {
        return user_placed_rating;
    }

    public void setUser_placed_rating(String user_placed_rating) {
        this.user_placed_rating = user_placed_rating;
    }

    public String getUser_profile_foto() {
        return user_profile_foto;
    }

    public void setUser_profile_foto(String user_profile_foto) {
        this.user_profile_foto = user_profile_foto;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_completed_orders='" + user_completed_orders + '\'' +
                ", user_placed_orders='" + user_placed_orders + '\'' +
                ", user_completed_rating='" + user_completed_rating + '\'' +
                ", user_placed_rating='" + user_placed_rating + '\'' +
                ", user_profile_foto='" + user_profile_foto + '\'' +
                '}';
    }
}
