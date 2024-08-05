package com.example.reciclajeapp;

import static com.example.reciclajeapp.R.id.buttonestadisticas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MenuPrincipal extends AppCompatActivity {

    private View register_recycling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_principal);

        Button consejos = findViewById(R.id.button10);
        Button beneficios = findViewById(R.id.button11);
        Button recycling = findViewById(R.id.button13);
        Button estadisticas = findViewById(buttonestadisticas);
        Button cerrarSesion = findViewById(R.id.button14);

        consejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consejos = new Intent(MenuPrincipal.this, ConsejosReciclaje.class);
                startActivity(consejos);
            }
        });

        beneficios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Beneficios = new Intent(MenuPrincipal.this, com.example.reciclajeapp.Beneficios.class);
                startActivity(Beneficios);
            }
        });

        recycling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterRecycling = new Intent(MenuPrincipal.this,com.example.reciclajeapp.RegisterRecycling.class);
                startActivity(RegisterRecycling );
            }
        });

        estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Estadisticas = new Intent(MenuPrincipal.this, Activity_Statistics.class);
                startActivity(Estadisticas);
            }
        });

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backP = new Intent(MenuPrincipal.this, MainActivity.class);
                startActivity(backP);
            }
        });


    }
}