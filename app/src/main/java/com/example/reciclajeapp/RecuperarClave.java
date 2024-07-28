package com.example.reciclajeapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecuperarClave extends AppCompatActivity {

    private EditText editTextCorreo;
    private Button buttonEnviar;
    private static final String PREFS_NAME = "UserPrefs";
    private static final String PREF_KEY_CORREO = "correo";
    private static final String PREF_KEY_CONTRASEÑA = "contraseña";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperarclave);

        editTextCorreo = findViewById(R.id.editTextText);
        buttonEnviar = findViewById(R.id.button2);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correoIngresado = editTextCorreo.getText().toString().trim();

                if (!TextUtils.isEmpty(correoIngresado)) {
                    SharedPreferences sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    String correoRegistrado = sharedPref.getString(PREF_KEY_CORREO, "");

                    if (correoIngresado.equals(correoRegistrado)) {
                        // Generate a new password
                        String nuevaContraseña = PasswordGenerator.generateRandomPassword();

                        // Send email with new password
                        new SendEmailTask(correoIngresado, nuevaContraseña).execute();

                        // Update password in SharedPreferences
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(PREF_KEY_CONTRASEÑA, nuevaContraseña);
                        editor.apply();
                    } else {
                        Toast.makeText(RecuperarClave.this, "Correo no registrado", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RecuperarClave.this, "Por favor ingrese un correo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView iniciarsesion = findViewById(R.id.textView10);
        iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iniciarsesion = new Intent(RecuperarClave.this, MainActivity.class);
                startActivity(iniciarsesion);
            }
        });
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(RecuperarClave.this, MainActivity.class);
        startActivity(intent);
        finish(); // Optional: call finish() to remove the current activity from the back stack
    }

    private class SendEmailTask extends AsyncTask<Void, Void, Boolean> {
        private String recipientEmail;
        private String newPassword;

        SendEmailTask(String recipientEmail, String newPassword) {
            this.recipientEmail = recipientEmail;
            this.newPassword = newPassword;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                EmailSender.sendEmail(recipientEmail, newPassword);
                return true; // Email sent successfully
            } catch (Exception e) {
                e.printStackTrace();
                return false; // Failed to send email
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                Toast.makeText(RecuperarClave.this, "Nueva contraseña enviada al correo", Toast.LENGTH_SHORT).show();
                navigateToMainActivity();
            } else {
                Toast.makeText(RecuperarClave.this, "Error al enviar el correo", Toast.LENGTH_SHORT).show();
            }
        }
    }
}