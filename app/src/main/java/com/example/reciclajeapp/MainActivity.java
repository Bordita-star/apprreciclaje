package com.example.reciclajeapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileReader;

public class MainActivity extends AppCompatActivity {
    int Correo;
    int password;
    int textView3;

    int textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View inicio = findViewById(R.id.imageView);
        View correo = findViewById(Correo);
        View contraseña = findViewById(password);
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

        EditText password = findViewById(R.id.password);
        ImageButton toggleVisibility = findViewById(R.id.toggleVisibility);

        toggleVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Si el textView está mostrando la contraseña, la oculta y cambia el icono
                if (password.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    toggleVisibility.setImageResource(R.drawable.visibility_off);

                    //Si el textView está ocultando la contaseña, la muestra y cambia el icono
                } else {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    toggleVisibility.setImageResource(R.drawable.visibility_0n);
                }
                // Mueve el cursor al final del texto
                password.setSelection(password.getText().length());

            }

        }
        );
    }
}















