package com.example.reciclajeapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroUsuario extends AppCompatActivity {

    private static final String PREFS_NAME = "UserPrefs";
    private static final String PREF_KEY_NOMBRE = "nombre";
    private static final String PREF_KEY_CORREO = "correo";
    private static final String PREF_KEY_TELEFONO = "telefono";
    private static final String PREF_KEY_CONTRASEÑA = "contraseña";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        final EditText nombreEditText = findViewById(R.id.nombre);
        final EditText correoEditText = findViewById(R.id.correo);
        final EditText telefonoEditText = findViewById(R.id.tlf);
        final EditText contraseñaEditText = findViewById(R.id.contraseña);
        Button registrarButton = findViewById(R.id.button3);

        registrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreEditText.getText().toString();
                String correo = correoEditText.getText().toString();
                String telefono = telefonoEditText.getText().toString();
                String contraseña = contraseñaEditText.getText().toString();

                if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty() || contraseña.isEmpty()) {
                    Toast.makeText(RegistroUsuario.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                } else {
                    saveUserData(nombre, correo, telefono, contraseña);
                    Toast.makeText(RegistroUsuario.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    // Redirige al usuario al MainActivity
                    Intent intent = new Intent(RegistroUsuario.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Opcional: cierra la actividad actual para que no se pueda volver a ella con el botón de retroceso
                }
            }
        });
    }

    private void saveUserData(String nombre, String correo, String telefono, String contraseña) {
        SharedPreferences sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(PREF_KEY_NOMBRE, nombre);
        editor.putString(PREF_KEY_CORREO, correo);
        editor.putString(PREF_KEY_TELEFONO, telefono);
        editor.putString(PREF_KEY_CONTRASEÑA, contraseña);
        editor.apply();
    }
}