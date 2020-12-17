package fr.yohan.facturation;

public class Entreprise extends Client {
    private String siret;


    public Entreprise(String mail, String siret){
        super(mail);
        this.siret = siret;
    }
}


