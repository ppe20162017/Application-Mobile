package com.example.agrur.agrur;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by benoi_000 on 07/03/2017.
 */

public class BdAdapter {
    static final int VERSION_BDD = 8;
    private static final String NOM_BDD = "verger.db";

    static final String TABLE_VERGER = "table_verger";
    static final String COL_ID = "ID";
    static final int NUM_COL_ID = 0;
    static final String COL_NOM = "NOM";
    static final int NUM_COL_NOM = 1;
    static final String COL_SUP = "SUP";
    static final int NUM_COL_SUP = 2;
    static final String COL_HEC = "HEC";
    static final int NUM_COL_HEC = 3;

    private SQLiteDatabase db;

    private CreateBdVerger bdVerger;

    public BdAdapter(Context context) {
        bdVerger = new CreateBdVerger(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open() {
        db = bdVerger.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getBDD(){
        return db;
    }

    public long insererVerger(Verger unVerger) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOM, unVerger.getNom());
        values.put(COL_SUP, unVerger.getSuperficie());
        values.put(COL_HEC, unVerger.getHectare());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_VERGER, null, values);
    }

    public int updateVerger(String id, Verger unVerger) {
        //La mise à jour d'un verger dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quel verger on doit mettre à jour grâce à sa référence
        ContentValues values = new ContentValues();
        values.put(COL_NOM, unVerger.getNom());
        values.put(COL_SUP, unVerger.getSuperficie());
        values.put(COL_HEC, unVerger.getHectare());
        return db.update(TABLE_VERGER, values, COL_ID + " = " + id, null);
    }

    public int removeVergerWithId(String id) {
        //Suppression d'un verger de la BDD grâce à sa référence
        return db.delete(TABLE_VERGER, COL_ID + " = " + id , null);
    }

    public Verger getVergerWithNom(String nom) {
        //Récupère dans un Cursor les valeurs correspondant à un verger grâce à sa designation)
        Cursor c = db.query(TABLE_VERGER, new String[]{COL_ID, COL_NOM, COL_SUP, COL_HEC}, COL_NOM + " LIKE \"" + nom +"\"", null, null, null, null);
        return cursorToVerger(c);
    }

    //Cette méthode permet de convertir un cursor en un verger
    private Verger cursorToVerger(Cursor c) {
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst(); //on se place sur le premier élément
        Verger unVerger = new Verger(); //On créé un verger
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor

        unVerger.setId(c.getInt(NUM_COL_ID));
        unVerger.setNom(c.getString(NUM_COL_NOM));
        unVerger.setSuperficie(c.getString(NUM_COL_SUP));
        unVerger.setHectare(c.getString(NUM_COL_HEC));
        c.close(); //On ferme le cursor
        return unVerger; //On retourne le verger
    }

    public Cursor getData() {
        return db.rawQuery("SELECT * FROM TABLE_VERGER", null);
    }
}
