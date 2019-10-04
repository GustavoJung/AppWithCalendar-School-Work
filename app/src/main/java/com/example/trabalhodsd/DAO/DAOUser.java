package com.example.trabalhodsd.DAO;

import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.trabalhodsd.model.User;

import java.util.List;

@Dao
public interface DAOUser {
    @Query("SELECT * FROM user")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM user WHERE id_user IN (:userIds)")
    LiveData<List<User>> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE nome LIKE :first LIMIT 1")
    LiveData<User> findByName(String first);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

}
