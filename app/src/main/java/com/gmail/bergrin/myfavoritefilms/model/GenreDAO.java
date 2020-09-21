package com.gmail.bergrin.myfavoritefilms.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GenreDAO {

    @Insert
    void insert(Genre genre);

    @Update
    void update(Genre genre);

    @Delete
    void delete(Genre genre);

    @Query("SELECT * FROM GENRES_TABLE")
    LiveData<List<Genre>> getAllGenres();
}
