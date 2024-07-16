package com.example.reciclajeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.Principal;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_principal);

        Button consejos = findViewById(R.id.button10);
        Button beneficios = findViewById(R.id.button11);
        Button contador = findViewById(R.id.button12);
        Button estadísticas = findViewById(R.id.button13);
        Button categorizacíon = findViewById(R.id.button19);
        Button cerrarSesion = findViewById(R.id.button14);

        consejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consejos = new Intent(MenuPrincipal.this, Consejosreciclaje.class);
                startActivity(consejos);
            }
        });

        beneficios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Beneficios = new Intent(MenuPrincipal.this, beneficios.class);
                startActivity(Beneficios);
            }
        });

        contador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Contador = new Intent(MenuPrincipal.this, Contadorrecompensa.class);
                startActivity(Contador);
            }
        });

        estadísticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Estadisticas = new Intent(MenuPrincipal.this, Estadisticas.class);
                startActivity(Estadisticas);
            }
        });
        categorizacíon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Categorizacion = new Intent(MenuPrincipal.this, categorizacion.class);
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