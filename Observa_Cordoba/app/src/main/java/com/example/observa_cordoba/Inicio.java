package com.example.observa_cordoba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Inicio extends AppCompatActivity {
    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Intent intent = getIntent();
        String saludo = intent.getStringExtra(Registro.EXTRA_MESSAGE);
        TextView textViewReg = findViewById(R.id.txtUsuario);
        textViewReg.setText("Hola "+saludo+"!");

        /*Ocultamos la barra de titulo de la app si el video se ve en modo horizontal
        int orientacion=getResources().getConfiguration().orientation;
        if(orientacion== Configuration.ORIENTATION_LANDSCAPE){
            getSupportActionBar().hide();
        }
        else{
            getSupportActionBar().show();
        }*/

        /*Añadimos el video y su controlador*/
        video=findViewById(R.id.video);
        video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoandroid));
        MediaController mc = new MediaController(this);
        video.setMediaController(mc);
        mc.setAnchorView(video);
        video.start();
    }

    /*Enlace entre inicio y bievenida*/
    public void activity_bienvenida(View vista){
        Intent bievenidaIntent = new Intent(this, MainActivity.class);
        startActivity(bievenidaIntent);
        finish();
    }
}