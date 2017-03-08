package com.example.agrur.agrur;

/**
 * Created by tangu on 08/03/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AgrurPPE extends AppCompatActivity {

    private Button buttonAjout, buttonList;
    private BdAdapter vergerBdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrur_ppe);
        initialisations();
        testBd();
    }

    public void initialisations() {
        buttonAjout = (Button) findViewById(R.id.buttonAjout);
        buttonAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgrurPPE.this, AjoutVerger.class);
                startActivity(intent);
            }
        });

        buttonList = (Button) findViewById(R.id.buttonList);
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgrurPPE.this, ListeVerger.class);
                startActivity(intent);
            }
        });

    }

    public void testBd() {

//        vergerBdd = new BdAdapter(this);
//
//        Verger unVerger = new Verger("des1", "10.0", "3");
//
//        vergerBdd.open();
//
//        vergerBdd.insererVerger(unVerger);
//
//        Verger unVergerFromBdd = vergerBdd.getVergerWithNom("des1");
//
//        if (unVergerFromBdd != null) {
//
//            Toast.makeText(this, unVergerFromBdd.getNom(), Toast.LENGTH_LONG).show();
//
//            //unVergerFromBdd.setNom("Des2");
//
//            vergerBdd.updateVerger(unVergerFromBdd.getNom(), unVergerFromBdd);
//        } else {
//            Toast.makeText(this, "Verger non trouvé", Toast.LENGTH_LONG).show();
//        }
//
//        vergerBdd.close();
    }

}