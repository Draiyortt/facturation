package fr.yohan.facturation;

public class LigneFacture {
    private int quantite;

    public LigneFacture(int quantite){
        this.quantite=quantite;
    }


    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite){
        this.quantite = quantite;
    }


}
