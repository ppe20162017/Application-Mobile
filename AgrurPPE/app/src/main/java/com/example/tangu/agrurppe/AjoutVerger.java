package com.example.tangu.agrurppe;

/**
 * Created by tangu on 14/03/2017.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



/**
 * Created by benoi_000 on 07/03/2017.
 */

public class AjoutVerger extends AppCompatActivity {

    private Button buttonAjoutVerger, buttonQuitterAjout;
    private EditText editTextNomVerger, editTextSuperficie, editTextHectare, editTextVariete, editTextProducteur, editTextCommune;
    private String nomVerger, superficie, hectare, producteur, commune, variete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_verger);
        quitter();
        ajouter();
    }

    /**
     * Fonction du bouton quitter pour revenir au menu
     */
    public void quitter() {
        buttonQuitterAjout = (Button) findViewById(R.id.buttonQuitterAjout);
        buttonQuitterAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * Fonction ajouter un verger qui teste si la valeur est nul ou
     */
    public void ajouter(){
        buttonAjoutVerger = (Button) findViewById(R.id.buttonAjoutVerger);
        buttonAjoutVerger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNomVerger = (EditText) findViewById(R.id.editTextNomVerger);
                editTextSuperficie = (EditText) findViewById(R.id.editTextSuperficie);
                editTextHectare = (EditText) findViewById(R.id.editTextHectare);
                editTextCommune = (EditText) findViewById(R.id.editTextCommune);
                editTextProducteur = (EditText) findViewById(R.id.editTextProducteur);
                editTextVariete = (EditText) findViewById(R.id.editTextVariete);

                nomVerger = editTextNomVerger.getText().toString();
                superficie = editTextSuperficie.getText().toString();
                hectare = editTextHectare.getText().toString();
                variete = editTextVariete.getText().toString();
                producteur = editTextProducteur.getText().toString();
                commune = editTextCommune.getText().toString();

                if (nomVerger.equals("") || superficie.equals("") || hectare.equals("")||variete.equals("") || producteur.equals("") || commune.equals("")){
                    Toast.makeText(getApplicationContext(), "Champ vide !", Toast.LENGTH_LONG).show();
                }

                else{
                    Toast.makeText(getApplicationContext(), "Ajout du verger !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

