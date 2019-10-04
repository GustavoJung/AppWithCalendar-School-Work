package com.example.trabalhodsd.DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.trabalhodsd.model.Tarefa;
import com.example.trabalhodsd.model.User;

@Database(entities = {User.class, Tarefa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DAOUser DAOuser();
    public abstract DAOTarefa DAOTarefa();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }




}
