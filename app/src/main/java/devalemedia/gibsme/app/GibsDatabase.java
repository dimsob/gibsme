package devalemedia.gibsme.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 02.07.2016.
 */

public class GibsDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "doshdb";
    final String LOG_TAG = "DoshcardLog";

    public GibsDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ORDER_TABLE = "CREATE TABLE orders (order_id INTEGER PRIMARY KEY autoincrement, order_title TEXT, order_desc TEXT, order_category TEXT, order_status TEXT, order_added_date TEXT, order_copleted_date TEXT, order_executor REAL, order_customer REAL, order_image TEXT,  order_address TEXT, order_to_date TEXT, order_lat REAL, order_longt REAL);";
        db.execSQL(CREATE_ORDER_TABLE);

        String CREATE_USER_TABLE = "CREATE TABLE users (user_id INTEGER PRIMARY KEY autoincrement, user_name TEXT, user_phone TEXT, user_password TEXT, user_completed_orders TEXT, user_placed_orders TEXT, user_completed_rating TEXT, user_placed_rating TEXT, user_profile_foto TEXT);";
        db.execSQL(CREATE_USER_TABLE);
    }

    public void userAdd(User u){

    }

    public void addOrder(Order o) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("order_title", o.getOrder_id());
        values.put("order_desc", o.getOrder_desc());
        values.put("order_category", o.getOrder_category());
        values.put("order_status", o.getOrder_status());
        values.put("order_added_date", o.getOrder_added_date());
        values.put("order_copleted_date", o.getOrder_copleted_date());
        values.put("order_executor", o.getOrder_executor());
        values.put("order_customer", o.getOrder_customer());
        values.put("order_image", o.getOrder_image());
        values.put("order_address", o.getOrder_address());
        values.put("order_to_date", o.getOrder_to_date());
        values.put("order_lat", o.getOrder_lat());
        values.put("order_longt", o.getOrder_longt());
        db.insert("orders", null, values);
        db.close();
    }

    public List<Order> getAllUsers() {
        List<Order> orderList = new ArrayList<Order>();
        String selectQuery = "SELECT  * FROM orders ORDER BY order_id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Order order = new Order();
                order.setOrder_id(Integer.parseInt(cursor.getString(0)));
                order.setOrder_title(cursor.getString(1));
                order.setOrder_desc(cursor.getString(1));
                order.setOrder_category(cursor.getString(1));
                order.setOrder_status(cursor.getString(1));
                order.setOrder_added_date(cursor.getString(1));
                order.setOrder_copleted_date(cursor.getString(1));
                order.setOrder_executor(Long.valueOf(cursor.getString(1)));
                order.setOrder_customer(Long.valueOf(cursor.getString(1)));
                order.setOrder_image(cursor.getString(1));
                order.setOrder_address(cursor.getString(1));
                order.setOrder_to_date(cursor.getString(1));
                order.setOrder_lat(Double.valueOf(cursor.getString(1)));
                order.setOrder_longt(Double.valueOf(cursor.getString(1)));


                orderList.add(order);
            } while (cursor.moveToNext());
        }
        return orderList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
