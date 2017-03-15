package com.example.tangu.agrurppe;

/**
 * Created by tangu on 14/03/2017.
 */

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by benoi_000 on 07/03/2017.
 */

public class ListeVerger extends AppCompatActivity {

    private Button buttonQuitterListe;

    private ListView listViewVergers;
    private BdAdapter vergerBdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_verger);
        listViewVergers = (ListView) findViewById(R.id.listViewVergers);
        vergerBdd = new BdAdapter(this); //On ouvre la base de données pour écrire dedans
        vergerBdd.open();
        Cursor c = vergerBdd.getData();
        Toast.makeText(getApplicationContext(), "il y a "+String.valueOf(c.getCount())+" articles dans la BD",Toast.LENGTH_LONG).show(); //
        // colonnes à afficher
        String[] columns = new String[] {BdAdapter.COL_NOM, BdAdapter.COL_SUP, BdAdapter.COL_HEC, BdAdapter.COL_VAR, BdAdapter.COL_COM, BdAdapter.COL_PRO};
        // champs dans lesquelles afficher les colonnes
        int[] to = new int[] {R.id.nom, R.id.sup, R.id.hec, R.id.var, R.id.com, R.id.pro };
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.list_entree,c,columns,to);
        // Assign adapter to ListView
        listViewVergers.setAdapter(dataAdapter);
        vergerBdd.close();
        quitter();

    }

    public void quitter() {
        buttonQuitterListe = (Button) findViewById(R.id.buttonQuitterListe);
        buttonQuitterListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
