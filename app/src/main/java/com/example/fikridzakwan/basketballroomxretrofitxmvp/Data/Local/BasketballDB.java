package com.example.fikridzakwan.basketballroomxretrofitxmvp.Data.Local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsItem;

@Database(entities = TeamsItem.class, version = 1)
public abstract class BasketballDB extends RoomDatabase {

    public abstract BasketballDao basketballDao();

    private static BasketballDB baskettballDB;

    public static BasketballDB getBaskettballDB(Context context) {
        if (baskettballDB == null) {
            baskettballDB = Room.databaseBuilder(context, BasketballDB.class, "db_basketball").allowMainThreadQueries().build();
        } return baskettballDB;
    }
}
