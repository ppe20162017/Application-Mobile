package com.example.tangu.agrurppe;

import android.content.Intent;
import android.database.Cursor;
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

        vergerBdd = new BdAdapter(this);

        Verger unVerger = new Verger("kiribati", "12","15", "franck", "mayette", "toufflers");

        vergerBdd.open();
        vergerBdd.insererVerger(new Verger("ref1", "des1", "10.0","3","jjk","jk"));
        System.out.println("insertion article");
        vergerBdd.close();
        Verger unVergerFromBdd = vergerBdd.getVergerWithNom("Des1");
        if (unVergerFromBdd != null) {

            Toast.makeText(this, unVergerFromBdd.getNom(), Toast.LENGTH_LONG).show();

            unVergerFromBdd.setNom("Des2");

            vergerBdd.updateVerger(unVergerFromBdd.getNom(), unVergerFromBdd);
        } else {
            Toast.makeText(this, "Verger non trouvé", Toast.LENGTH_LONG).show();
        }
//On extrait l’Article de la BDD grâce à sa nouvelle désignation
        unVergerFromBdd = vergerBdd.getVergerWithNom("Des2");
//S'il existe un Article possédant cette désignation dans la BDD
        if(unVergerFromBdd != null){
//On affiche les nouvelles info de l’Article pour vérifié que la désignation de l’Article a bien été maj
            Toast.makeText(this, unVergerFromBdd.getNom(), Toast.LENGTH_LONG).show();
//on supprime le unArticle de la BDD grâce à son ID
            vergerBdd.removeVergerWithId(unVergerFromBdd.getNom());
        }
//On essait d'extraire de nouveau l’Article de la BDD toujours grâce à sa nouvelle désignation
        unVergerFromBdd = vergerBdd.getVergerWithNom("Des2");
//Si aucun unArticle n'est retourné
        if(unVergerFromBdd == null){
//On affiche un message indiquant que l’Article n'existe pas dans la BDD
            Toast.makeText(this, "Cet article n'existe pas dans la BDD", Toast.LENGTH_LONG).show();
        }
        else{ //Si l'Article existe (mais normalement il ne devrait pas)
//on affiche un message indiquant que l’Article existe dans la BDD
            Toast.makeText(this, "Cet article existe dans la BDD", Toast.LENGTH_LONG).show();
        }
        Cursor c = vergerBdd.getData(); Toast.makeText(getApplicationContext(), "il y a "+String.valueOf(c.getCount())+" articles dans la BD", Toast.LENGTH_LONG).show();
    }

}
