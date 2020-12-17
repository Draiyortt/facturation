package fr.yohan.facturation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class FactureTest{
    @Test
    public void ajoutD1ProduitDansUneFacture_ajouterProduit_renvoieUnProduit() {

        // ARRANGE

        Client c = new Client("yohan.carvalho@ltpdampierre.fr");
        Produit p1 = new Produit(1, "Vaisseau Star Wars", 100, 0.20);
        Facture f = new Facture(1, "10/12/2020", c);
        LigneFacture l = new LigneFacture(1);
        boolean produitTrouvé = false;

        // AGIS

        f.ajouterProduit(p1, l);
        for (int i=0; i> f.getListProduits().size(); i++) {
            if (f.getListProduits().get(i).getNomProduit().equals("Vaisseau Star Wars")) {
                if ( f.getListQuantites().get(i).getQuantite()== 1){
                produitTrouvé = true;
                }
            }
            produitTrouvé = false;
             
        }
        

        // ASSERT

        assertEquals("Produit :", true,  produitTrouvé);
    }

    @Test
    public void ListeDeProduitsHorsTaxesSansQauntite_CalculPrixTotalHT_renvoie105() {

        // ARRANGE

        Client c = new Client("yohan.carvalho@ltpdampierre.fr");
        Produit p1 = new Produit(1, "Vaisseau Star Wars", 100, 0.20);
        Produit p2 = new Produit(1, "Boite De Coockies XL", 5, 0.10);
        Facture f = new Facture(1, "10/12/2020", c);
        LigneFacture l1 = new LigneFacture(2);
        LigneFacture l2 = new LigneFacture(4);
        f.ajouterProduit(p1, l1);
        f.ajouterProduit(p2, l2);


        // AGIS

        int res = f.calculPrixTotalHT();

        // ASSERT

        assertEquals("Devrait renvoyer le prix :", 105, res);
    }

    @Test
    public void ListeDeProduitsSansQauntite_CalculPrixTotalTTT_renvoie125() {

        // ARRANGE

        Client c = new Client("yohan.carvalho@ltpdampierre.fr");
        Produit p1 = new Produit(1, "Vaisseau Star Wars", 100, 0.20);
        Produit p2 = new Produit(1, "Boite De Coockies XL", 5, 0.10);
        Facture f = new Facture(1, "10/12/2020", c);
        LigneFacture l1 = new LigneFacture(2);
        LigneFacture l2 = new LigneFacture(4);
        f.ajouterProduit(p1, l1);
        f.ajouterProduit(p2, l2);


        // AGIS

        int res = f.calculPrixTotalTTC();

        // ASSERT

        assertEquals("Devrait renvoyer le prix :", 125, res);
    }
}