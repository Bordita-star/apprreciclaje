package com.example.reciclajeapp;

import android.annotation.SuppressLint;
import android.view.View;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


  public class RegisterRecycling extends AppCompatActivity {

    EditText editTextMaterial;
    EditText editTextQuantity;
    Button buttonAdd;
    TextView textViewPoints;
    ListView listViewRewards;
    ArrayAdapter<String> rewardsAdapter;
    ArrayList<String> rewardsList;  // Declarado como ArrayList<String>
    int points;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.register_recycling);

            // Inicializamos las vistas
            editTextMaterial = findViewById(R.id.editTextMaterial);
            editTextQuantity = findViewById(R.id.editTextQuantity);
            buttonAdd = findViewById(R.id.buttonAdd);
            textViewPoints = findViewById(R.id.textViewPoints);
            listViewRewards = findViewById(R.id.listViewRewards);

            // Inicializamos la lista y el adaptador de recompensas
            rewardsList = new ArrayList<>();
            rewardsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rewardsList);
            listViewRewards.setAdapter(rewardsAdapter);

            // Inicializamos los puntos
            points = 0;

            // Configuramos el listener para el botón
            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addRecycledMaterial();
                }
            });
        }

        private void addRecycledMaterial() {
            // Obtenemos los valores ingresados por el usuario
            String materialType = editTextMaterial.getText().toString();
            String quantityText = editTextQuantity.getText().toString();

            // Validamos que los campos no estén vacíos
            if (materialType.isEmpty() || quantityText.isEmpty()) {
                // Mostrar un mensaje de error o un Toast
                Toast.makeText(this, "Por favor, complete ambos campos.", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                // Convertimos la cantidad a un entero
                int quantity = Integer.parseInt(quantityText);

                // Actualizamos los puntos
                points += quantity; // Asumimos 1 punto por kg para simplificar
                textViewPoints.setText("Puntos: " + points);

                // Verificamos y agregamos recompensas
                checkForRewards();

                // Limpiamos los campos de entrada
                editTextMaterial.setText("");
                editTextQuantity.setText("");
            } catch (NumberFormatException e) {
                // Manejar el caso donde la cantidad no es un número válido
                Toast.makeText(this, "Por favor, ingrese una cantidad válida.", Toast.LENGTH_SHORT).show();
            }
        }

        private void checkForRewards() {
            // Verificamos si el usuario ha alcanzado las recompensas
            if (points >= 10 && !rewardsList.contains("Descuento de 10%")) {
                rewardsList.add("Descuento de 10%");
                rewardsAdapter.notifyDataSetChanged();
            }
            if (points >= 20 && !rewardsList.contains("Descuento de 20%")) {
                rewardsList.add("Descuento de 20%");
                rewardsAdapter.notifyDataSetChanged();
            }
            if (points >= 30 && !rewardsList.contains("Descuento de 30%")) {
                rewardsList.add("Descuento de 30%");
                rewardsAdapter.notifyDataSetChanged();
            }
        }
    }




