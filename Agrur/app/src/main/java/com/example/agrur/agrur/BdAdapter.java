package com.example.agrur.agrur;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by tangu on 01/03/2017.
 */


public class BdAdapter {

        static final int VERSION_BDD = 1;
        private static final String NOM_BDD = "vergers.db";
        static final String TABLE_VERGERS = "table_vergers";
        static final String COL_ID = "_id";
        static final int NUM_COL_ID = 0;
        static final String COL_NOMVERGERS = "NOMVERGER";
        static final int NUM_COL_NOMVERGERS = 1;
        static final String COL_SUPERFICIE = "SUPERFICIE";
        static final int NUM_COL_SUPERFICIE = 2;
        static final String COL_HECTARE = "HECTARE";
        static final int NUM_COL_HECTARE = 3;
        static final String COL_VARIETE = "VARIETE";
        static final int NUM_COL_VARIETE = 4;
        static final String COL_COMMUNE = "COMMUNE";
        static final int NUM_COL_COMMUNE = 5;
        static final String COL_PRODUTEUR = "NOMPRODUCTEUR";
        static final int NUM_COL_PRODUTEUR = 6;



        private CreateBdVergers bdVergers;
        private Context context;
        private SQLiteDatabase db;
        public BdAdapter (Context context){
            this.context = context;
            bdVergers = new CreateBdVergers(context, NOM_BDD, null, VERSION_BDD);
        }
        //si la base n’existe pas, l’objet SQLiteOpenHelper exécute la méthode onCreate
// si la version de la bse a changé, la méthode onUpgrade sera lancée
// dans les 2 cas l’appel à getWritableDatabase ou getReadableDatabase renverra la base
// de données en cache, nouvellement ouverte, nouvellement créée ou mise à jour
        public BdAdapter open (){
            db = bdVergers.getWritableDatabase();
            return this;
        }
        public BdAdapter close (){
            db.close();
            return null;
        }
        public long insererVergers (Vergers unVergers){
//Création d'un ContentValues (fonctionne comme une HashMap)
            ContentValues values = new ContentValues();
//on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
            values.put(COL_NOMVERGERS, unVergers.getNomVerger());
            values.put(COL_SUPERFICIE, unVergers.getSuperficie());
            values.put(COL_HECTARE, unVergers.getHectare());
            values.put(COL_VARIETE, unVergers.getVariete());
            values.put(COL_COMMUNE, unVergers.getCommune());
            values.put(COL_PRODUTEUR, unVergers.getProducteur());
//on insère l'objet dans la BDD via le ContentValues
            return db.insert(TABLE_VERGERS, null, values);
        }
        private Vergers cursorToVergers(Cursor c){ //Cette méthode permet de convertir un cursor en un verger
//si aucun élément n'a été retourné dans la requête, on renvoie null
            if (c.getCount() == 0)
                return null;
//Sinon
            c.moveToFirst(); //on se place sur le premier élément
            Vergers unVergers = new Vergers("unNomVergers", "uneSuperficie", "unHectare",
                    "uneVariete", "uneCommune", "unProducteur"); //On créé un verger
//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor

            unVergers.setNomVerger(c.getString(NUM_COL_NOMVERGERS));
            unVergers.setSuperficie(c.getString(NUM_COL_SUPERFICIE));
            unVergers.setHectare(c.getString(NUM_COL_HECTARE));
            unVergers.setVariete(c.getString(NUM_COL_VARIETE));
            unVergers.setCommune(c.getString(NUM_COL_COMMUNE));
            unVergers.setProducteur(c.getString(NUM_COL_PRODUTEUR));
            c.close(); //On ferme le cursor
            return unVergers; //On retourne lle verger
        }

    public Vergers getVergersWithNomVergers(String nomVergers){
//Récupère dans un Cursor les valeurs correspondant à un article grâce à sa designation)
        Cursor c = db.query(TABLE_VERGERS, new String[] {COL_ID,COL_NOMVERGERS, COL_SUPERFICIE, COL_HECTARE, COL_VARIETE, COL_COMMUNE, COL_PRODUTEUR}, COL_NOMVERGERS + " LIKE \"" + nomVergers +"\"", null, null, null, null);
        return cursorToVergers(c);
    }
        public Cursor getData(){
            return db.rawQuery("SELECT * FROM TABLE_VERGERS", null);
        }
    }

