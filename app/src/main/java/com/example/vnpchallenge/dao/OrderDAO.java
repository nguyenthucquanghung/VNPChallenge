package com.example.vnpchallenge.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.vnpchallenge.model.Order;

import java.util.List;

@Dao
public interface OrderDAO {
    @Query("SELECT * FROM orders")
    List<Order> getOrders();
}
