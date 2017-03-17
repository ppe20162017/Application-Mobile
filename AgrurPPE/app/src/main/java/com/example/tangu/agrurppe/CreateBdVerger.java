package com.example.tangu.agrurppe;

/**
 * Created by tangu on 14/03/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;


/**
 * Created by tangu on 01/03/2017.
 */

public class CreateBdVerger extends SQLiteOpenHelper {

    /**
     * Déclaration des variables pour créer les colonnes de la bdd et la requête de la création de la bdd
     */

    private static final String TABLE_VERGER = "table_verger";
    static final String COL_ID = "_id";
    private static final String COL_NOM = "NOM";
    private static final String COL_SUP = "SUP";
    private static final String COL_HEC = "HEC";
    private static final String COL_VAR = "VAR";
    private static final String COL_COM = "COM";
    private static final String COL_PRO = "PRO";
    private static final String CREATE_BDD ="CREATE TABLE " + TABLE_VERGER + "("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NOM + " TEXT NOT NULL, " + COL_SUP + " TEXT NOT NULL, "
            + COL_HEC + " TEXT NOT NULL, " + COL_VAR + " TEXT NOT NULL, "
            + COL_COM + " TEXT NOT NULL ," + COL_PRO + " TEXT NOT NULL);";


    /**
     * Constructeur de la création de la base de données
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public CreateBdVerger(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(CREATE_BDD);
    }

    /**
     * Permet de modifier la bdd on supprime la bdd puis on la recrée
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_VERGER + ";");
        onCreate(db);
    }
}
