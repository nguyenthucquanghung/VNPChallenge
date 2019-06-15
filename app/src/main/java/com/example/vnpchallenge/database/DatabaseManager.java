package com.example.vnpchallenge.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.vnpchallenge.model.Order;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final String TAG = "DatabaseManager";

    private static final String TABLE_ORDER = "tbl_order";

    private SQLiteDatabase sqLiteDatabase;
    private AssetHelper assetHelper;

    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance(Context context) {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager(context);
        }
        return databaseManager;
    }

    private DatabaseManager(Context context) {
        assetHelper = new AssetHelper(context);
    }

    public List<Order> getListOrder() {
        sqLiteDatabase = assetHelper.getReadableDatabase();

        List<Order> orders = new ArrayList<>();

        Cursor cursor =sqLiteDatabase.rawQuery("select * from " + TABLE_ORDER, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            //read data
            int id = cursor.getInt(0);
            String fromAddress = cursor.getString(1);
            String toAddress = cursor.getString(2);
            long pickupTime = cursor.getLong(3);
            String toName = cursor.getString(4);
            String toNumber = cursor.getString(5);
            float weight = cursor.getFloat(6);
            float sizew = cursor.getFloat(7);
            float sizel = cursor.getFloat(8);
            float sizeh = cursor.getFloat(9);
            String note = cursor.getString(10);
            float fee = cursor.getFloat(11);
            int type = cursor.getInt(12);

            //create data
            Order order = new Order(id, fromAddress, toAddress, pickupTime, toName, toNumber, weight, sizew, sizel, sizeh, note, fee, type);
            orders.add(order);

            cursor.moveToNext();
        }
        return orders;
    }

    public int getNumberOfOrder() {
        return getListOrder().size();
    }

    public void addOrder(Order order) {
        sqLiteDatabase = assetHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", order.getId());
        contentValues.put("from_address", order.getFromAddress());
        contentValues.put("to_address", order.getToAddress());
        contentValues.put("pickup_time", order.getPickupTime());
        contentValues.put("to_name", order.getReceiverName());
        contentValues.put("to_number", order.getReceiverNumber());
        contentValues.put("weight", order.getPackageWeight());
        contentValues.put("size_w", order.getSizeW());
        contentValues.put("size_l", order.getSizeL());
        contentValues.put("size_h", order.getSizeH());
        contentValues.put("note", order.getNote());
        contentValues.put("fee", order.getFee());
        contentValues.put("type", order.getType());

        sqLiteDatabase.insert(TABLE_ORDER, null, contentValues);
    }
}
