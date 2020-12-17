package fr.yohan.facturation;

public class Produit {
    private int code;
    private String nom;
    private int prixHT;
    private CategorieProduit categorieProduit;

    public Produit(int code, String nom, int prixHT, double TVA) {
        this.code = code;
        this.nom = nom;
        this.prixHT = prixHT;
        categorieProduit = new CategorieProduit(TVA);
    }

    public int getPrixHT() {
        return prixHT;
    }

    public String getNomProduit(){
        return nom;
    }

    public int calculerPrixTTC() {
        double TVA = categorieProduit.getTVA();
        int PrixTTC = (int) (prixHT * (1 + TVA));
        return PrixTTC;
    }

    

}