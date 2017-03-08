package com.example.agrur.agrur;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tangu on 01/03/2017.
 */

public class CreateBdVerger extends SQLiteOpenHelper {
    private static final String TABLE_VERGERS = "table_vergers";
    static final String COL_ID = "_id";
    private static final String COL_NOMVERGERS = "NOMVERGER";
    private static final String COL_SUPERFICIE = "SUPERFICIE";
    private static final String COL_HECTARE = "HECTARE";
    private static final String COL_VARIETE = "VARIETE";
    private static final String COL_COMMUNE = "COMMUNE";
    private static final String COL_PRODUCTEUR = "NOMPRODUCTEUR";
    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_VERGERS + " ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NOMVERGERS + " TEXT NOT NULL, " + COL_SUPERFICIE + " TEXT NOT NULL, "
            + COL_HECTARE + " TEXT NOT NULL," + COL_VARIETE + " TEXT NOT NULL);"
            + COL_COMMUNE + " TEXT NOT NULL," + COL_PRODUCTEUR + " TEXT NOT NULL);";
    public CreateBdVerger(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
// TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
// appelée lorsqu’aucune base n’existe et que la classe utilitaire doit en créer une
//on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }
    @Override // appelée si la version de la base a changé
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//On peut supprimer la table et de la recréer
        db.execSQL("DROP TABLE " + TABLE_VERGERS + ";");
        onCreate(db);
    }
}