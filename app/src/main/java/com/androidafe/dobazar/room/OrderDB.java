package com.androidafe.dobazar.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Orders.class}, version = 1)
public abstract class OrderDB extends RoomDatabase {
    public abstract OrdersDao userDao();
}