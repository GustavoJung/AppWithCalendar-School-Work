package com.example.trabalhodsd;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.trabalhodsd.controller.SaveData;
import com.example.trabalhodsd.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class Telaprincipal extends AppCompatActivity implements NovaAtividadeDialog.AtividadeListener {
    private Button button_addAtividade;
    private String[] itens = new String[10];
    private List<String> itensL;
    private ArrayAdapter<String> adapter;
    private int count;
    private SaveData saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaprincipal2);
        saveData = new SaveData(this);

        for (int i = 0; i < 10; i++) {
            itens[i] = " ";
        }
        count = 0;
        itensL = new ArrayList<>();
        String nome = getIntent().getStringExtra("nome");
        Toast.makeText(this, "Bem vindo " + nome + "!", Toast.LENGTH_SHORT).show();


        button_addAtividade = (Button) findViewById(R.id.bt_adicionarAtividade);
        button_addAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddAtividade();
            }
        });
        populateListView();
    }

    private void openAddAtividade() {
        NovaAtividadeDialog dialog = new NovaAtividadeDialog();
        dialog.show(getSupportFragmentManager(), "Nova atividade");

    }

    private void populateListView() {
        ListView listV = (ListView) findViewById(R.id.list_view);
        Cursor data = saveData.getData();
        itensL = new ArrayList<>();
        while (data.moveToNext()) {
            //get the value from the database in column 1
            //then add it to the ArrayList
            itensL.add(data.getString(1));
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itensL);
        listV.setAdapter(adapter);

    }


    @Override
    public void setText(View v, String nome, String data) {
        Tarefa t = new Tarefa(nome, data);
        itensL.add(nome);

        // adapter.notifyDataSetChanged();
        Toast.makeText(this, "Atividade adicionada!", Toast.LENGTH_SHORT).show();

    }
}
