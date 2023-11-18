
package bean;

public class PatientBean {
    
    private String nom;
    private String prenom;
    private String numeroNational;
    private String heureRendezVous;

    public PatientBean() {
    }

    public PatientBean(String nom, String prenom, String numRegNat, String heureRendezVous) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroNational = numRegNat;
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

    public String getNumeroNational() {
        return numeroNational;
    }

    public void setNumeroNational(String numeroNational) {
        this.numeroNational = numeroNational;
    }

    public String getHeureRendezVous() {
        return heureRendezVous;
    }

    public void setHeureRendezVous(String heureRendezVous) {
        this.heureRendezVous = heureRendezVous;
    }

    @Override
    public String toString() {
        return "PatientBean{" + "nom=" + nom + ", prenom=" + prenom + ", numRegNat=" + numeroNational + ", heureRendezVous=" + heureRendezVous + '}';
    }
    
}
