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
    private BdAdapter vergerBdd;


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
                if (getEditNomVerger().equals("") || getEditSuperficie().equals("") || getEditHectare().equals("")||getEditVariete().equals("")
                        || getEditProducteur().equals("") || getEditCommune().equals("")){
                    Toast.makeText(getApplicationContext(), "Champ vide !", Toast.LENGTH_LONG).show();
                }

                else{
                    testBd();
                    Toast.makeText(getApplicationContext(), "Ajout du verger !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public String getEditNomVerger(){
        editTextNomVerger = (EditText) findViewById(R.id.editTextNomVerger);
        nomVerger = editTextNomVerger.getText().toString();
        return nomVerger;
    }

    public String getEditSuperficie(){
        editTextSuperficie = (EditText) findViewById(R.id.editTextSuperficie);
        superficie = editTextSuperficie.getText().toString();
        return superficie;
    }

    public String getEditHectare(){
        editTextHectare = (EditText) findViewById(R.id.editTextHectare);
        hectare = editTextHectare.getText().toString();
        return hectare;
    }

    public String getEditCommune(){
        editTextCommune = (EditText) findViewById(R.id.editTextCommune);
        commune = editTextCommune.getText().toString();
        return commune;
    }

    public String getEditProducteur(){
        editTextProducteur = (EditText) findViewById(R.id.editTextProducteur);
        producteur = editTextProducteur.getText().toString();
        return producteur;
    }

    public String getEditVariete(){
        editTextVariete = (EditText) findViewById(R.id.editTextVariete);
        variete = editTextVariete.getText().toString();
        return variete;
    }

    public void testBd(){
        vergerBdd = new BdAdapter(this);
        Verger unVerger = new Verger(getEditNomVerger(), getEditSuperficie(),getEditHectare(), getEditVariete(), getEditCommune(), getEditProducteur());
        vergerBdd.open();
        vergerBdd.insererVerger(unVerger);
        System.out.println("insertion article");
        vergerBdd.close();
    }

}

