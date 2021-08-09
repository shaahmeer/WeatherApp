package com.mirea.nawab.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CityEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CityDao employeeDao();
}