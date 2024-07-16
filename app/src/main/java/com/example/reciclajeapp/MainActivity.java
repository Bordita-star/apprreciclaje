package com.example.reciclajeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int editText4;
    int editText5;
    int textView3;

    int textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View inicio = findViewById(R.id.imageView);
        View correo = findViewById(editText4);
        View contraseña = findViewById(editText5);
        Button Recuperarclave = findViewById(R.id.recuperarclave);
        Button Registrarusuario = findViewById(R.id.registrarusuario);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio = new Intent(MainActivity.this, MenuPrincipal.class);
                startActivity(inicio);
            }
        });
        Registrarusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrarusuario = new Intent(MainActivity.this, RegistroUsuario.class);
                startActivity(registrarusuario);
            }
        });
       Recuperarclave.setOnClickListener(new View.OnClickListener() {
         @Override
           public void onClick(View v) {
             Intent recuperarclave = new Intent(MainActivity.this, RecuperarClave.class);
             startActivity(recuperarclave);

         }

       });


    }
}










