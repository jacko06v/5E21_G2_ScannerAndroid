package com.example.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //******** pagina finita +****

    private Button inserisci; //variabili bottoni
    private Button elimina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mantiene il pulsante in ascolto di un eventuale "click" per l'apertura della funzione openInserisci
        inserisci = (Button) findViewById(R.id.btnInserisci);
        inserisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInserisci();

            }
        });


        //mantiene il pulsante in ascolto di un eventuale "click" per l'apertura della funzione openelimina
        elimina = (Button) findViewById(R.id.btnElimina);
        elimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openElimina();

            }
        });


    }

    //funzione per aprire l'attività inserisci
    public void openInserisci(){
        Intent intentinserisci = new Intent(this, inserisci.class);
        startActivity(intentinserisci);
    }


    //funzione per aprire l'attività elimina
    public void openElimina(){
        Intent intentelimina = new Intent(this, elimina.class);
        startActivity(intentelimina);
    }


}