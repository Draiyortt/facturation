package fr.yohan.facturation;

import static org.junit.Assert.assertEquals;


import org.junit.Test;


public class FactureTest{
    @Test
    public void ajoutD1ProduitDansUneFacture_ajouterProduit_renvoieUnProduit() {

        // ARRANGE

        Client c = new Client("yohan.carvalho@ltpdampierre.fr");
        Produit p1 = new Produit(1, "Vaisseau Star Wars", 100, 0.20);
        Facture f = new Facture(1, "10/12/2020", c);
        LigneFacture l = new LigneFacture(1);
        boolean produitTrouve = false;

        // AGIS

        f.ajouterProduit(p1, l);
        for (int i=0; i< f.getListProduits().size(); i++) {
            if (f.getListProduits().get(i).getNomProduit().equals("Vaisseau Star Wars")) {
                if ( f.getListQuantites().get(i).getQuantite()== 1){
                produitTrouve = true;
                break;
                }
            }
            produitTrouve = false;
             
        }
        

        // ASSERT

        assertEquals("Produit :", true,  produitTrouve);
    }

    @Test
    public void ListeDeProduitsHorsTaxesSansQauntite_CalculPrixTotalHT_renvoie220() {

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

        assertEquals("Devrait renvoyer le prix :", 220, res);
    }

    @Test
    public void ListeDeProduitsSansQauntite_CalculPrixTotalTTT_renvoie260() {

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

        assertEquals("Devrait renvoyer le prix :", 260, res);
    }

    @Test
    public void retraitD1ProduitDansUneFacture_retireProduit_renvoieUnProduit() {

        // ARRANGE

        Client c = new Client("yohan.carvalho@ltpdampierre.fr");
        Produit p1 = new Produit(1, "Vaisseau Star Wars", 100, 0.20);
        Produit p2 = new Produit(1, "Boite De Coockies XL", 5, 0.10);
        Facture f = new Facture(1, "10/12/2020", c);
        LigneFacture l1 = new LigneFacture(2);
        LigneFacture l2 = new LigneFacture(4);
        f.ajouterProduit(p1, l1);
        f.ajouterProduit(p2, l2);
        boolean produitTrouve = true;

        // AGIS

        f.retirerProduit(p2, l2);
        for (int i=0; i< f.getListProduits().size(); i++) {
            if (f.getListProduits().get(i).getNomProduit().equals("Boite De Coockies XL")) {
                produitTrouve = false;
                break;
            }
            
            produitTrouve = true;
             
        }
        

        // ASSERT

        assertEquals("le produit à disparue", true,  produitTrouve);
    }
}