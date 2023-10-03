package com.class5.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button google, alarma, llamada, temporizador, correo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        google = findViewById(R.id.google);
        alarma = findViewById(R.id.alarma);
        llamada = findViewById(R.id.llamar);
        temporizador = findViewById(R.id.temporizador);
        correo = findViewById(R.id.correo);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irAGoogle = new Intent(Intent.ACTION_VIEW);
                irAGoogle.setData(Uri.parse("http://www.google.com"));
                startActivity(irAGoogle);

            }
        });

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                crearAlarma();

            }
        });

        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                crearLlamada();

            }
        });

        temporizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent temporizador = new Intent(AlarmClock.ACTION_SET_TIMER)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "message")
                        .putExtra(AlarmClock.EXTRA_LENGTH, 30)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
                if (temporizador.resolveActivity(getPackageManager()) != null) {
                    startActivity(temporizador);
                }

            }
        });


        correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, "juaneroskate9@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Bienvenido a su nuevo empleo");
                intent.putExtra(Intent.EXTRA_STREAM, "Te damos la bienvenida a Android Corp, eres un nuevo integrante de la familia te felicitamos");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    public void crearAlarma() {

        Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
        alarma.putExtra(AlarmClock.EXTRA_MESSAGE, "Gym");
        alarma.putExtra(AlarmClock.EXTRA_HOUR, 10);
        alarma.putExtra(AlarmClock.EXTRA_MINUTES, 30);
        if (alarma.resolveActivity(getPackageManager()) != null) {
            startActivity(alarma);
        }

    }

    public void crearLlamada(){

        Intent llamada = new Intent(Intent.ACTION_DIAL);
        llamada.setData(Uri.parse("tel:" + "+573015963619" ));
        if (llamada.resolveActivity(getPackageManager()) != null) {
            startActivity(llamada);
        }
    }



}






