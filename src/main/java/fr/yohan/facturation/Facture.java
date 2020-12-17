package fr.yohan.facturation;

import java.util.ArrayList;

public class Facture {

    private int numero;
    private String dateDeFacture;
    private ArrayList<Produit> produits = new ArrayList<>();
    private Client acheteur;
    private ArrayList<LigneFacture> quantite = new ArrayList<>();

    public Facture(int numero, String dateDeFacture, Client acheteur) {
        this.numero = numero;
        this.dateDeFacture = dateDeFacture;
        this.acheteur = acheteur;
    }

    public ArrayList<Produit> getListProduits(){
        return produits;
    }

    public ArrayList<LigneFacture> getListQuantites(){
        return quantite;
    }

    public int calculPrixTotalHT() {
        int prixTotalHT = 0;

        for (int i =0; i< produits.size(); i++) {
            
            prixTotalHT += produits.get(i).getPrixHT() * quantite.get(i).getQuantite();
        }
        return prixTotalHT;
    }

    public int calculPrixTotalTTC(){
        int prixTotalTTC = 0;

        for (int i =0; i< produits.size(); i++) {
            
            prixTotalTTC += produits.get(i).calculerPrixTTC() * quantite.get(i).getQuantite();
        }
        return prixTotalTTC;
    }

    public boolean ajouterProduit(Produit nouvProduit, LigneFacture quantite){
        if (quantite.getQuantite() >0){
            for (int i =0; i< produits.size(); i++) {
        
                if (nouvProduit.equals(produits.get(i))) {
                    this.quantite.get(i).setQuantite(quantite.getQuantite()+this.quantite.get(i).getQuantite());
                    return true;
                }
            }
            produits.add(nouvProduit);
            return true;
        } else {
            return false;
        }
    }

    

    public boolean retirerProduit(Produit produitDemande, LigneFacture quantite){
        if (quantite.getQuantite() >0){
            for (int i =0; i< produits.size(); i++) {
        
                if (produitDemande.equals(produits.get(i))) {
                    this.quantite.get(i).setQuantite(quantite.getQuantite()-this.quantite.get(i).getQuantite());
                    return true;
                }
            }
            produits.remove(produitDemande);
            return true;
        } else {
            return false;
        }
    }

    
}
