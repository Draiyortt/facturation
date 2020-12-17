package fr.yohan.facturation;

public class Particulier extends Client {
    private String nom;


    public Particulier(String mail, String nom){
        super(mail);
        this.nom = nom;
    }
}
