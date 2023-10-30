
package model;

public class Patient {

    
    
     private String nom;
    private String prenom;
    private String numRegNat;
    private String heureRendezVous;

    
    
    
      public Patient(String nom, String prenom, String numRegNat, String heureRendezVous) {
        this.nom = nom;
        this.prenom = prenom;
        this.numRegNat = numRegNat;
        this.heureRendezVous = heureRendezVous;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumRegNat() {
        return numRegNat;
    }

    public void setNumRegNat(String numRegNat) {
        this.numRegNat = numRegNat;
    }

    public String getHeureRendezVous() {
        return heureRendezVous;
    }

    public void setHeureRendezVous(String heureRendezVous) {
        this.heureRendezVous = heureRendezVous;
    }

    
}
