package com.example.agrur.agrur;

/**
 * Created by tangu on 08/03/2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by benoi_000 on 07/03/2017.
 */

public class ListeVerger extends AppCompatActivity {

    private Button buttonQuitterListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_verger);
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
