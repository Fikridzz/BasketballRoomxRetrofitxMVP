package com.example.fikridzakwan.basketballroomxretrofitxmvp.Data.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsItem;

import java.util.List;

@Dao
public interface BasketballDao {

    @Insert
    void insertItem(TeamsItem teamsItem);

    @Query("SELECT * FROM teams WHERE idTeam = :id")
    TeamsItem selectedItem(String id);

    @Delete
    void delete(TeamsItem teamsItem);

    @Query("SELECT * FROM teams ORDER BY nama_team ASC")
    List<TeamsItem> selectFavorite();
}
