package com.example.trabalhodsd.DAO;

import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.trabalhodsd.model.Tarefa;
import com.example.trabalhodsd.model.User;

import java.util.List;

@Dao
public interface DAOTarefa {
    @Query("SELECT * FROM tarefa")
    LiveData<List<Tarefa>> getAll();

    @Query("SELECT * FROM tarefa WHERE id_tarefa IN (:tarefasid)")
    LiveData<List<Tarefa>> loadAllByIds(int[] tarefasid);

    @Query("SELECT * FROM tarefa WHERE nome LIKE :nome LIMIT 1")
    LiveData<User> findByName(String nome);

    @Insert
    void insert(Tarefa tarefa);

    @Delete
    void delete(Tarefa tarefa);

}
