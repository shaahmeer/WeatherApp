package com.mirea.nawab.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CityDao {

    // Добавление Person в бд
    @Insert
    void insertAll(CityEntity... people);

    // Удаление Person из бд
    @Delete
    void delete(CityEntity cityEntity);

    // Получение всех Person из бд
    @Query("SELECT * FROM cityentity")
    List<CityEntity> getAllPeople();


}