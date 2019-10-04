package com.example.trabalhodsd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btLogin;
    private EditText text;
    private String nome_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.nome_user);


        btLogin = findViewById(R.id.bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome_user = text.getText().toString();
                Intent newActivity = new Intent(MainActivity.this, Telaprincipal.class);
                newActivity.putExtra("nome",nome_user);
                startActivity(newActivity);
                finish();
            }
        });


    }

}
