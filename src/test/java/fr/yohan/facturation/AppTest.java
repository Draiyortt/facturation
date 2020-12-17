package fr.yohan.facturation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    

    @Test
    public void produitSansTVA_getPrixTTC_renvoiePrixHT() {

        // ARRANGE

        int prixHT = 100;
        Produit p = new Produit(1, "produit", prixHT, 0);

        // AGIS

        int res = p.calculerPrixTTC();

        // ASSERT

        assertEquals("Devrait renvoyer le prix ht", prixHT, res);
    }

    @Test
    public void produitAvec20PourcentTVA_getPrixTTC_renvoie120() {

        // ARRANGE

        int prixHT = 100;
        
        Produit p = new Produit(1, "produit", prixHT, 0.20);

        // AGIS

        int res = p.calculerPrixTTC();

        // ASSERT

        assertEquals("Devrait renvoyer le prix :", 120, res);
    }

    @Test
    public void produitAvec20PourcentTVA_getPrixTTC_renvoie8() {

        // ARRANGE

        int prixHT = 7;
        
        Produit p = new Produit(1, "produit", prixHT, 0.20);

        // AGIS

        int res = p.calculerPrixTTC();

        // ASSERT

        assertEquals("Devrait renvoyer le prix :", 8, res);
    }

    

    
}
