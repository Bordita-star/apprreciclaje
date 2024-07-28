package com.example.reciclajeapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.widget.AdapterView.OnItemSelectedListener;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RegisterRecycling extends AppCompatActivity {

    EditText editTextMaterial;
    EditText editTextQuantity;
    Button buttonAdd;
    Button buttonMenu;
    Button buttonReset; // Añadir el botón de reset
    TextView textViewPoints;
    ListView listViewRewards;
    ArrayAdapter<String> rewardsAdapter;
    ArrayList<String> rewardsList;
    int pointsCarton;
    int pointsPlastico;
    int pointsVidrio;
    int pointsLata;
    AdapterView<Adapter> spinnerMaterial;
    private SpinnerAdapter adapter;
    Spinner spinnerlistmaterial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_recycling);

        editTextQuantity = findViewById(R.id.editTextQuantity);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonMenu = findViewById(R.id.button18);
        buttonReset = findViewById(R.id.buttonclear); // Inicializar el botón de reset
        textViewPoints = findViewById(R.id.textViewPoints);
        listViewRewards = findViewById(R.id.listViewRewards);
        spinnerlistmaterial = findViewById(R.id.spinnerMaterial);
        rewardsList = new ArrayList<>();
        rewardsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rewardsList);
        listViewRewards.setAdapter(rewardsAdapter);

        pointsCarton = 0;
        pointsPlastico = 0;
        pointsVidrio = 0;
        pointsLata = 0;

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRecycledMaterial();
            }
        });

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterRecycling.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restablecer los puntos a cero
                pointsCarton = 0;
                pointsPlastico = 0;
                pointsVidrio = 0;
                pointsLata = 0;

                // Actualizar la vista de puntos (textViewPoints)
                updatePointsView();

                // Método para actualizar la vista de puntos
               View  updatePointsView; {
                    String pointsText = "Puntos acumulados: " + (pointsCarton + pointsPlastico + pointsVidrio + pointsLata);
                    textViewPoints.setText(pointsText);
                }

            }
        });
        


        // Crear un ArrayAdapter usando el string array y un default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.materiales_array, android.R.layout.simple_spinner_item);
        // Especificar el layout a usar cuando la lista de opciones aparece
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Aplicar el adaptador al Spinner
        spinnerlistmaterial.setAdapter(adapter);

        // Agregar un listener para detectar la selección del Spinner
        spinnerlistmaterial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el elemento seleccionado
                String selectedMaterial = parent.getItemAtPosition(position).toString();

                // Usar selectedMaterial en tu lógica (por ejemplo, en addRecycledMaterial)
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void updatePointsView() {
    }

    private void addRecycledMaterial() {
        String materialType = spinnerlistmaterial.getSelectedItem().toString();
        String quantityText = editTextQuantity.getText().toString();

        if (materialType.isEmpty() || quantityText.isEmpty()) {
            Toast.makeText(this, "Por favor, complete ambos campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityText);
            int materialPoints = 0;

            Log.e("mensaje",materialType);

            switch (materialType) {
                case "Cartón":
                    materialPoints = 3;
                    pointsCarton += quantity * materialPoints;
                    break;
                case "Plástico":
                    materialPoints = 4;
                    pointsPlastico += quantity * materialPoints;
                    break;
                case "Vidrio":
                    materialPoints = 2;
                    pointsVidrio += quantity * materialPoints;
                    break;
                case "Lata":
                    materialPoints = 3;
                    pointsLata += quantity * materialPoints;
                    break;
                default:
                    Toast.makeText(this, "Tipo de material no válido.", Toast.LENGTH_SHORT).show();
                    return;
            }

            checkForRewards(materialType);
            updatePointsDisplay();

            editTextQuantity.setText("");

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, ingrese una cantidad válida.", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkForRewards(String material) {
        boolean newReward = false;

        switch (material) {
            case "Cartón":
                if (pointsCarton >= 30 && !rewardsList.contains("Descuento de 30% en almacenes Exitos para Cartón")) {
                    rewardsList.add("Descuento de 30% en almacenes Exitos... válido por un mes");
                    newReward = true;
                } else if (pointsCarton >= 20 && !rewardsList.contains("Descuento de 20% en restaurantes para Cartón")) {
                    rewardsList.add("Descuento de 20% en restaurantes asociados a Ecorecicla...válido por 15 dias");
                    newReward = true;
                } else if (pointsCarton >= 10 && !rewardsList.contains("Descuento de 10% en tiendas para Cartón")) {
                    rewardsList.add("Descuento de 10% en transporte público o gasolina...válido por un mes");
                    newReward = true;
                }
                break;
            case "Plástico":
                if (pointsPlastico >= 30 && !rewardsList.contains("Descuento de 30% en almacenes Exitos para Plástico")) {
                    rewardsList.add("Descuento de 30% en almacenes Exitos.. válido por un mes ");
                    newReward = true;
                } else if (pointsPlastico >= 20 && !rewardsList.contains("Descuento de 20% en restaurantes para Plástico")) {
                    rewardsList.add("Descuento de 20% en restaurantes a nivel nacional asociados a Ecorecicla...válido por 15 dias");
                    newReward = true;
                } else if (pointsPlastico >= 10 && !rewardsList.contains("Descuento de 10% en tiendas para Plástico")) {
                    rewardsList.add("Descuento de 10% en transporte público o gasolina...válido por un mes");
                    newReward = true;
                }
                break;
            case "Vidrio":
                if (pointsVidrio >= 30 && !rewardsList.contains("Descuento de 30% en almacenes Exitos para Vidrio")) {
                    rewardsList.add("Descuento de 30% en almacenes Exitos... válido por un mes ");
                    newReward = true;
                } else if (pointsVidrio >= 20 && !rewardsList.contains("Descuento de 20% en restaurantes para Vidrio")) {
                    rewardsList.add("Descuento de 20% en restaurantes a nivel nacional asociados a Ecorecicla, válido por 15 dias ");
                    newReward = true;
                } else if (pointsVidrio >= 10 && !rewardsList.contains("Descuento de 10% en tiendas para Vidrio")) {
                    rewardsList.add("Descuento de 10% en transporte público o gasolina, válido por un mes" );
                    newReward = true;
                }
                break;
            case "Lata":
                if (pointsLata >= 30 && !rewardsList.contains("Descuento de 30% en almacenes Exitos para Lata")) {
                    rewardsList.add("Descuento de 30% en almacenes Exitos... válido por un mes ");
                    newReward = true;
                } else if (pointsLata >= 20 && !rewardsList.contains("Descuento de 20% en restaurantes para Lata")) {
                    rewardsList.add("Descuento de 20% en restaurantes a nivel nacional asociados a Ecorecicla, válido por 15 dias ");
                    newReward = true;
                } else if (pointsLata >= 10 && !rewardsList.contains("Descuento de 10% en tiendas para Lata")) {
                    rewardsList.add("Descuento de 10% en transporte público o gasolina, válido por un mes ");
                    newReward = true;
                }
                break;
        }

        if (newReward) {
            rewardsAdapter.notifyDataSetChanged();
            Toast.makeText(this, "¡Nuevo bono de descuento añadido!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updatePointsDisplay() {
        String pointsText = "Cartón: " + pointsCarton + "\n" +
                "Plástico: " + pointsPlastico + "\n" +
                "Vidrio: " + pointsVidrio + "\n" +
                "Lata: " + pointsLata + "\n";
        textViewPoints.setText(pointsText);
    }

    private void resetPoints() {
        pointsCarton = 0;
        pointsPlastico = 0;
        pointsVidrio = 0;
        pointsLata = 0;
        rewardsList.clear();
        rewardsAdapter.notifyDataSetChanged();
        Object updatePoints;

    }

}


























