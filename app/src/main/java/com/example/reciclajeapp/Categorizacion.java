package com.example.reciclajeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Categorizacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categorizacion);

        Button Volvermenu= findViewById(R.id.button);

        Volvermenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Volvermenu = new Intent(Categorizacion.this,MenuPrincipal.class);
                startActivity(Volvermenu);
            }
        });
        Button Calcular= findViewById(R.id.button6);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Calcular = new Intent(Categorizacion.this,Registro.class);
                startActivity(Calcular);
            }
        });

            }
        }

