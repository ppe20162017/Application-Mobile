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



}
