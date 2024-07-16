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

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        Button Calcular = findViewById(R.id.button9);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Calcular = new Intent(Registro.this,Contadorrecompensa.class);
                startActivity(Calcular);
            }
        });

        Button Volveramenu = findViewById(R.id.button17);

        Volveramenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Volveramenu = new Intent(Registro.this,MenuPrincipal.class);
                startActivity(Volveramenu);
            }
        });



    }
}