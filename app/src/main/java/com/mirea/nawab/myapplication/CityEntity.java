package com.mirea.nawab.myapplication;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CityEntity {
    @PrimaryKey
    @NonNull
    String name;
}
