
package model;

import java.sql.Time;


public class CentreVaccination {
     private String nomCentre ;
        private int  codePostal;
        private String adresse ;
        private String numero ;
        private String telephone ;
        private String jourSemaineOuverture ;

    public String getNomCentre() {
        return nomCentre;
    }

    public void setNomCentre(String nomCentre) {
        this.nomCentre = nomCentre;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getJourSemaineOuverture() {
        return jourSemaineOuverture;
    }

    public void setJourSemaineOuverture(String jourSemaineOuverture) {
        this.jourSemaineOuverture = jourSemaineOuverture;
    }

    public Time getHeureFermeture() {
        return heureFermeture;
    }

    public void setHeureFermeture(Time heureFermeture) {
        this.heureFermeture = heureFermeture;
    }

    public Time getHeureOuverture() {
        return heureOuverture;
    }

    public void setHeureOuverture(Time heureOuverture) {
        this.heureOuverture = heureOuverture;
    }
        private Time heureFermeture ;
        private Time heureOuverture ;
}
