package com.example.agrur.agrur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   
private BdAdapter vergersBdd ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// test de la BD
        testBd();
    }

    public void testBd(){
//Création d'une instance de la classe unArticlesBDD
       vergersBdd = new BdAdapter(this);
//Création d'un Article
        Vergers unArticle = new Vergers("ref1", "des1", "10.0","3");
//On ouvre la base de données pour écrire dedans
        vergersBdd.open();
//On insère l'article que l'on vient de créer
        vergersBdd.insererVergers(unArticle);
        System.out.println("insertion article");
//Pour vérifier que l'on a bien créé un Article dans la BDD
//on extrait l’article de la BDD grâce à la désignation de l'article que l'on a créé précédemment
        Vergers unArticleFromBdd = vergersBdd.getArticleWithDesignation("des1");
//Si un unArticle est retourné (donc si le unArticle à bien été ajouté à la BDD)
        if(unArticleFromBdd != null){
//On affiche les infos de l’Article dans un Toast
            Toast.makeText(this, unArticleFromBdd.getDesignation(), Toast.LENGTH_LONG).show();
//On modifie le titre de l’Article
            unArticleFromBdd.setDesignation("Des2");
//Puis on met à jour la BDD
            vergersBdd.updateArticle(unArticleFromBdd.getReference(), unArticleFromBdd);
        }
        else {
            Toast.makeText(this, "Article non trouvé", Toast.LENGTH_LONG).show();
        }
//On extrait l’Article de la BDD grâce à sa nouvelle désignation
        unArticleFromBdd = vergersBdd.getArticleWithDesignation("Des2");
//S'il existe un Article possédant cette désignation dans la BDD
        if(unArticleFromBdd != null){
//On affiche les nouvelles info de l’Article pour vérifié que la désignation de l’Article a bien été maj
            Toast.makeText(this, unArticleFromBdd.getDesignation(), Toast.LENGTH_LONG).show();
//on supprime le unArticle de la BDD grâce à son ID
            vergersBdd.removeArticleWithRef(unArticleFromBdd.getReference());
        }
//On essait d'extraire de nouveau l’Article de la BDD toujours grâce à sa nouvelle désignation
        unArticleFromBdd = vergersBdd.getArticleWithDesignation("Des2");
//Si aucun unArticle n'est retourné
        if(unArticleFromBdd == null){
//On affiche un message indiquant que l’Article n'existe pas dans la BDD
            Toast.makeText(this, "Cet article n'existe pas dans la BDD", Toast.LENGTH_LONG).show();
        }
        else{ //Si l'Article existe (mais normalement il ne devrait pas)
//on affiche un message indiquant que l’Article existe dans la BDD
            Toast.makeText(this, "Cet article existe dans la BDD", Toast.LENGTH_LONG).show();
        }
        vergersBdd.close();
    }