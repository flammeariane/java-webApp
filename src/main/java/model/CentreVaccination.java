
package model;

import java.sql.Time;


public class CentreVaccination {
     private String nomCentre ;
        private int  codePostal;
        private String adresse ;
        private String numero ;
        private String telephone ;
        private String jourSemaineOuverture ;
        private String heureFermeture;

    public String getHeureFermeture() {
        return heureFermeture;
    }

    public void setHeureFermeture(String heureFermeture) {
        this.heureFermeture = heureFermeture;
    }

    public String getHeureOuverture() {
        return heureOuverture;
    }

    public void setHeureOuverture(String heureOuverture) {
        this.heureOuverture = heureOuverture;
    }
        private String heureOuverture;

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
}