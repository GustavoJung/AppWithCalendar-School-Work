package com.example.trabalhodsd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.room.Room;

import com.example.trabalhodsd.DAO.AppDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Telaprincipal extends AppCompatActivity implements NovaAtividadeDialog.AtividadeListener {
    private Button button_addAtividade;
    private AppDatabase banco;
    private String[] itens = new String[10];
    private List<String>itensL;
    private ArrayAdapter<String> adapter;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaprincipal2);
        for(int i=0; i<10; i++){
            itens[i] = " ";
        }
        count = 0;
        itensL = new ArrayList<>();
        String nome = getIntent().getStringExtra("nome");
        Toast.makeText(this, "Bem vindo "+nome+  "!", Toast.LENGTH_SHORT).show();
        //banco = Room.databaseBuilder(getApplicationContext(),
            //    AppDatabase.class, "database").build();


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
        dialog.show(getSupportFragmentManager(),"Nova atividade");
    }

    private void populateListView() {
        if(itensL.size() == 0){
            itensL.add("Adicione uma nova tarefa!!");
        }
        //Adapter
            adapter = new ArrayAdapter<String>(this, R.layout.list_item_layout, itensL);
            //Configurando
            ListView listV = (ListView) findViewById(R.id.list_view);
            listV.setAdapter(adapter);

    }

    @Override
    public void setText(String nome, String data) {
        if(itensL.size() == 1)
            itensL.set(0,nome);
        else
            itensL.add(nome);

        itens[count] = nome;
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Atividade adicionada!", Toast.LENGTH_SHORT).show();
        count++;
    }
}
