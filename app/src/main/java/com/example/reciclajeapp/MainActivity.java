package com.example.reciclajeapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "UserPrefs";
    private static final String PREF_KEY_NOMBRE = "nombre";
    private static final String PREF_KEY_CORREO = "correo";
    private static final String PREF_KEY_TELEFONO = "telefono";
    private static final String PREF_KEY_CONTRASEÑA = "contraseña";

    private EditText editTextCorreo;
    private EditText editTextContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextCorreo = findViewById(R.id.Correo);
        editTextContraseña = findViewById(R.id.password);

        View inicio = findViewById(R.id.imageView);
        Button recuperarClave = findViewById(R.id.recuperarclave);
        Button registrarUsuario = findViewById(R.id.registrarusuario);
        Button consultarDatos = findViewById(R.id.consultarDatos);

        inicio.setOnClickListener(v -> {
            String correo = editTextCorreo.getText().toString();
            String contraseña = editTextContraseña.getText().toString();

            if (loginUser(correo, contraseña)) {
                Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        registrarUsuario.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegistroUsuario.class);
            startActivity(intent);
        });

        recuperarClave.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecuperarClave.class);
            startActivity(intent);
        });

        ImageButton toggleVisibility = findViewById(R.id.toggleVisibility);
        toggleVisibility.setOnClickListener(v -> {
            if (editTextContraseña.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                editTextContraseña.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                toggleVisibility.setImageResource(R.drawable.visibility_off);
            } else {
                editTextContraseña.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                toggleVisibility.setImageResource(R.drawable.visibility_0n);
            }
            editTextContraseña.setSelection(editTextContraseña.getText().length());
        });

        consultarDatos.setOnClickListener(v -> {
            SharedPreferences sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            String nombre = sharedPref.getString(PREF_KEY_NOMBRE, "No hay nombre guardado");
            String correo = sharedPref.getString(PREF_KEY_CORREO, "No hay correo guardado");
            String telefono = sharedPref.getString(PREF_KEY_TELEFONO, "No hay teléfono guardado");
            String contraseña = sharedPref.getString(PREF_KEY_CONTRASEÑA, "No hay contraseña guardada");

            Log.d("MainActivity", "Nombre guardado: " + nombre);
            Log.d("MainActivity", "Correo guardado: " + correo);
            Log.d("MainActivity", "Teléfono guardado: " + telefono);
            Log.d("MainActivity", "Contraseña guardada: " + contraseña);
        });
    }

    private boolean loginUser(String correo, String contraseña) {
        SharedPreferences sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String savedCorreo = sharedPref.getString(PREF_KEY_CORREO, "");
        String savedContraseña = sharedPref.getString(PREF_KEY_CONTRASEÑA, "");

        return correo.equals(savedCorreo) && contraseña.equals(savedContraseña);
    }
}