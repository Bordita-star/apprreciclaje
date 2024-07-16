package com.example.reciclajeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ConsejosReciclaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consejosreciclaje);

        Button volveramenu = findViewById(R.id.button16);

        volveramenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volveramenu = new Intent(ConsejosReciclaje.this,MenuPrincipal.class);
                startActivity(volveramenu);
            }
        });



    }
}
