package com.example.tangu.agrurppe;

/**
 * Created by tangu on 14/03/2017.
 */

public class Verger {
    private int id;
    private String nom;
    private String superficie;
    private String hectare;
    private String producteur;
    private String variete;
    private String commune;


    /**
     * Constructeur de la classe verger
     * @param unNom
     * @param uneSuperficie
     * @param unHectare
     * @param unProducteur
     * @param uneVariete
     * @param uneCommune
     */
    public Verger(String unNom, String uneSuperficie, String unHectare, String unProducteur,
                  String uneVariete, String uneCommune) {
        this.nom = unNom;
        this.superficie = uneSuperficie;
        this.hectare = unHectare;
        this.producteur = unProducteur;
        this.commune = uneCommune;
        this.variete = uneVariete;
    }

    /**
     * Les getteurs et setteur de variable de la classe Verger
     *
     */

    public int getId() {

        return this.id;
    }

    public void setId(int unId) {

        this.id = unId;
    }

    public String getNom() {

        return this.nom;
    }

    public void setNom(String unNom) {

        this.nom = unNom;
    }

    public String getSuperficie() {

        return this.superficie;
    }

    public void setSuperficie(String uneSuperficie) {

        this.superficie = uneSuperficie;
    }

    public String getHectare(){

        return this.hectare;
    }

    public void setHectare(String unHectare) {

        this.hectare = unHectare;
    }
    public String getProducteur() {

        return this.producteur;
    }

    public void setProducteur(String unProducteur) {

        this.producteur = unProducteur;
    }
    public String getCommune() {

        return this.commune;
    }

    public void setCommune(String uneCommune) {

        this.commune = uneCommune;
    }
    public String getVariete() {

        return this.variete;
    }

    public void setVariete(String uneVariete) {

        this.variete = uneVariete;
    }






    public String toString(){
        return "ID : "+id+"\nNom : "+nom+"\nSuperficie : "+superficie+"\nHectare : "+hectare+"\nProducteur : "+producteur+
                "\nCommune : "+commune+"\nVariete : "+variete;
    }

}
