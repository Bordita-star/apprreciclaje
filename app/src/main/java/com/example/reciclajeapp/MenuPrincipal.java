package com.example.reciclajeapp;

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
        Button contador = findViewById(R.id.button12);
        Button recycling = findViewById(R.id.button13);
        Button categorizacíon = findViewById(R.id.button19);
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

        contador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Contador = new Intent(MenuPrincipal.this, ContadorRecompensa.class);
                startActivity(Contador);
            }
        });

        recycling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterRecycling = new Intent(MenuPrincipal.this,com.example.reciclajeapp.RegisterRecycling.class);
                startActivity(RegisterRecycling );
            }
        });
        categorizacíon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Categorizacion = new Intent(MenuPrincipal.this, com.example.reciclajeapp.Categorizacion.class);
                startActivity(Categorizacion);
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