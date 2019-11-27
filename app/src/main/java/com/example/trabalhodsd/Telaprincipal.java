package com.example.trabalhodsd;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;


public class Telaprincipal extends AppCompatActivity {

    CalendarView mCalendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaprincipal2);
        mCalendar = findViewById(R.id.calendarView);
        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int ano, int mes, int dia) {
                Toast.makeText(Telaprincipal.this, "Data selecionada: " + dia+"/"+ (mes+1) +"/"+ ano, Toast.LENGTH_SHORT).show();
            }
        });
        String nome = getIntent().getStringExtra("nome");
        Toast.makeText(this, "Bem vindo " + nome + "!", Toast.LENGTH_SHORT).show();
    }


}
