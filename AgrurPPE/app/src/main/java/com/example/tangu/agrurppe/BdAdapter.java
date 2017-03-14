package com.example.tangu.agrurppe;

/**
 * Created by tangu on 14/03/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by tangu on 07/03/2017.
 */

public class BdAdapter {
    static final int VERSION_BDD = 9;
    private static final String NOM_BDD = "verger.db";
    static final String TABLE_VERGER = "table_verger";
    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;
    static final String COL_NOM = "NOM";
    static final int NUM_COL_NOM = 1;
    static final String COL_SUP = "SUP";
    static final int NUM_COL_SUP = 2;
    static final String COL_HEC = "HEC";
    static final int NUM_COL_HEC = 3;
    static final String COL_VAR = "VAR";
    static final int NUM_COL_VAR = 4;
    static final String COL_COM = "COM";
    static final int NUM_COL_COM = 5;
    static final String COL_PRO = "PRO";
    static final int NUM_COL_PRO = 6;
    private CreateBdVerger bdVerger;
    private Context context;
    private SQLiteDatabase db;

    public BdAdapter(Context context) {
        this.context = context;
        bdVerger = new CreateBdVerger(context, NOM_BDD, null, VERSION_BDD);
    }

    public BdAdapter open() {
        db = bdVerger.getWritableDatabase();
        return this;
    }

    public BdAdapter close() {
        db.close();
        return null;
    }


    public long insererVerger(Verger unVerger) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOM, unVerger.getNom());
        values.put(COL_SUP, unVerger.getSuperficie());
        values.put(COL_HEC, unVerger.getHectare());
        values.put(COL_VAR, unVerger.getVariete());
        values.put(COL_COM, unVerger.getCommune());
        values.put(COL_PRO, unVerger.getProducteur());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_VERGER, null, values);
    }

    //Cette méthode permet de convertir un cursor en un verger
    private Verger cursorToVerger(Cursor c) {
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst(); //on se place sur le premier élément
        Verger unVerger = new Verger("kiribati", "12", "15", "franck", "mayette", "toufflers"); //On créé un verger
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor

        unVerger.setId(c.getInt(NUM_COL_ID));
        unVerger.setNom(c.getString(NUM_COL_NOM));
        unVerger.setSuperficie(c.getString(NUM_COL_SUP));
        unVerger.setHectare(c.getString(NUM_COL_HEC));
        unVerger.setVariete(c.getString(NUM_COL_VAR));
        unVerger.setCommune(c.getString(NUM_COL_COM));
        unVerger.setProducteur(c.getString(NUM_COL_PRO));
        c.close(); //On ferme le cursor
        return unVerger; //On retourne le verger
    }

    public Verger getVergerWithNom(String nom) {
        //Récupère dans un Cursor les valeurs correspondant à un verger grâce à sa designation)
        Cursor c = db.query(TABLE_VERGER, new String[]{COL_ID, COL_NOM, COL_SUP, COL_HEC, COL_VAR, COL_COM, COL_PRO}, COL_NOM + " LIKE \"" + nom + "\"", null, null, null, null);
        return cursorToVerger(c);
    }

    public int updateVerger(String id, Verger unVerger) {
        //La mise à jour d'un verger dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quel verger on doit mettre à jour grâce à sa référence
        ContentValues values = new ContentValues();
        values.put(COL_NOM, unVerger.getNom());
        values.put(COL_SUP, unVerger.getSuperficie());
        values.put(COL_HEC, unVerger.getHectare());
        values.put(COL_VAR, unVerger.getVariete());
        values.put(COL_COM, unVerger.getCommune());
        values.put(COL_PRO, unVerger.getProducteur());
        return db.update(TABLE_VERGER, values, COL_ID + " = " + id, null);
    }

    public int removeVergerWithId(String id) {
        //Suppression d'un verger de la BDD grâce à sa référence
        return db.delete(TABLE_VERGER, COL_ID + " = " + id, null);
    }

    public Cursor getData() {
        return db.rawQuery("SELECT * FROM TABLE_VERGER", null);

    }
}
