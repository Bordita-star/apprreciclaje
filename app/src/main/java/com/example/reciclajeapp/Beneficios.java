package com.example.reciclajeapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Beneficios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_beneficios);

        Button Menuprincipal = findViewById(R.id.button5);

        Menuprincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Menuprincipal = new Intent(Beneficios.this, MenuPrincipal.class);
                startActivity(Menuprincipal);
            }
        });

        VideoView mivideo = findViewById(R.id.mivideo);

        int idmivideo = R.raw.beneficiosreciclaje;
        String carpetaRecursos = "android.resource://" + getPackageName() + "/";
        Uri uri = Uri.parse(carpetaRecursos + idmivideo);
        mivideo.setVideoURI(uri);
        mivideo.start();

        mivideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                mivideo.setVisibility(VideoView.GONE);
            }
        });
    }

}




