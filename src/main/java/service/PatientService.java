package service;

import java.util.ArrayList;
import java.util.List;
import bean.PatientBean;  // Importez le PatientBean

public class PatientService {

    public List<PatientBean> getListeDesPatientsDuJour() {
        // mocks data en attendant l' API réels
        List<PatientBean> patients = new ArrayList<>();
        
        // Utilisation de PatientBean avec toutes les informations
        patients.add(new PatientBean("Dupont", "Jean", "123456789", "2023-10-26"));
        patients.add(new PatientBean("Durand", "Marie", "987654321", "2023-10-26"));

        // Utilisation de PatientBean avec des informations manquantes
        PatientBean patientSansNumRegNat = new PatientBean();
        patientSansNumRegNat.setNom("Martin");
        patientSansNumRegNat.setPrenom("Alice");
        // Le numéro de registre national est volontairement omis
        patientSansNumRegNat.setHeureRendezVous("2023-10-26");
        patients.add(patientSansNumRegNat);

        // Ajouter plus de patients pour simuler les données

        return patients;
    }
}
