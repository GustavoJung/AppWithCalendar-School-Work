package com.example.trabalhodsd.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

//chave estrangeira para usuario
    @Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id_tarefa",
        childColumns = "user_id"))
    public class Tarefa {

        @PrimaryKey
        private int id_tarefa;

        @ColumnInfo(name="nome")
        private String nome;
        @ColumnInfo(name="data")
        private String data;



    }
