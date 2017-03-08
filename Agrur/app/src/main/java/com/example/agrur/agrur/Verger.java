package com.example.agrur.agrur;

/**
 * Created by benoi_000 on 07/03/2017.
 */

public class Verger {
    private int id;
    private String nom;
    private String superficie;
    private String hectare;
    private String producteur;
    private String variete;
    private String commune;




    public Verger() {

    }

    public Verger(String unNom, String uneSerpifice, String unHectare, String unProducteur,
                  String uneVariete, String uneCommune) {
        this.nom = unNom;
        this.superficie = uneSerpifice;
        this.hectare = unHectare;
        this.producteur = unProducteur;
        this.commune = uneCommune;
        this.variete = uneVariete;
    }

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

    public String getHectare() {
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
