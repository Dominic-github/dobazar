package com.androidafe.dobazar.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OrdersDao {

    @Insert
    void insertCartsData(Orders orders);

    @Query("SELECT * FROM orders")
    List<Orders> getCarts();


    @Delete
    void deleteCartItem(Orders orders);


}
