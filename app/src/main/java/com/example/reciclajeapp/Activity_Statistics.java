package com.example.reciclajeapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity_Statistics extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        // Datos de ejemplo para el gráfico (material, cantidad en kg)
        HashMap<String, Integer> materialesReciclados = new HashMap<>();
        materialesReciclados.put("Cartón", 30); // amarillo
        materialesReciclados.put("Plástico", 20); //azul
        materialesReciclados.put("Vidrio", 10); //rojo


        // Obtener referencia al BarChart en el layout
        BarChart chart = findViewById(R.id.chart_materiales);

        // Crear entradas para el gráfico
        List<BarEntry> entries = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Integer> entry : materialesReciclados.entrySet()) {
            entries.add(new BarEntry(i, entry.getValue().floatValue())); // Usar el valor como cantidad en kg
            i++;
        }

        // Crear conjuntode datos y personalizarlo
        BarDataSet dataSet = new BarDataSet(entries, "Materiales Reciclados");

        // Array de colores personalizados
        int[] coloresPersonalizados = new int[] {
                Color.parseColor("#0000FF"),  // Plástico (Azul)
                Color.parseColor("#FF0000"),  // Vidrio (Rojo)
                Color.parseColor("#FFC107")   // Cartón (Amarillo)
        };

        dataSet.setColors(coloresPersonalizados); // Asignar los colores al dataSet

        // Crear datos del gráfico y asignarlos al gráfico
        BarData data = new BarData(dataSet);
        chart.setData(data);

        // Leyenda
        Legend legend = chart.getLegend();
        legend.setEnabled(true);
        legend.setDrawInside(false);

         // Etiquetas de la leyenda
        legend.setExtra(new int[] {Color.parseColor("#0000FF"), Color.parseColor("#FFC107"), Color.parseColor("#FF0000")},
                new String[] {"Plástico", "Cartón", "Vidrio"});

        // Personalizar el gráfico (opcional)
        chart.getDescription().setEnabled(false);

        // Actualizar el gráfico
        chart.invalidate();
    }
}