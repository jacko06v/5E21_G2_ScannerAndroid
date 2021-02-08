package com.example.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class elimina extends AppCompatActivity implements View.OnClickListener{


    RadioButton pezzo;
    RadioButton accessori;
    Button btnElimina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elimina);

        btnElimina = findViewById(R.id.scanElimina);
        btnElimina.setOnClickListener(this);

        pezzo = findViewById(R.id.pezzo);
        accessori = findViewById(R.id.accessori);

    }

    @Override
    public void onClick(View v) {
        scan();

    }


    private void scan(){

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptureAct.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scannerizzando il codice..");
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() != null){
                if(accessori.isChecked()) {

                    String dati= result.getContents();

                    String[] datiCompleti = dati.split("[|]");




                    String sito = "https://www.spesagian.altervista.org/QRreader.php?cod="+datiCompleti[0]+"&reader=ciao&op=del&desc="+datiCompleti[1]+"&pz="+datiCompleti[2]+"&elem=accessorio";
                    gotoUrl(sito);



                }else if(pezzo.isChecked()){

                    String dati= result.getContents();

                    String[] datiCompleti = dati.split("[|]");




                    String sito = "https://spesagian.altervista.org/QRreader.php?cod="+datiCompleti[0]+"&reader=ciao&op=del&desc="+datiCompleti[1]+"&pz="+datiCompleti[2]+"&elem=pezzo";
                    gotoUrl(sito);



                }else {

                    Toast.makeText(this, "scegli la tipologia del prodotto", Toast.LENGTH_LONG).show();
                }

            }
            else
            {
                Toast.makeText(this,"nessun risultato", Toast.LENGTH_LONG).show();
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void gotoUrl(String sito) {



        Uri uri = Uri.parse(sito);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivity(intent);
        }
    }
}