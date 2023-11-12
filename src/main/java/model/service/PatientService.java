package model.service;

import bean.PatientBean;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

public class PatientService {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

//    public List<PatientBean> getListeDesPatientsDuJour() {
//        try {
//            HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8080/Centre_vaccination_SGBD/loginPersonnel"))
//                .GET()
//                .build();
//
//            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//            if (response.statusCode() == 200) {
//                // Convertir la réponse JSON en une liste de PatientBean
//                return objectMapper.readValue(response.body(), new TypeReference<List<PatientBean>>(){});
//            } else {
//                // Gérer les réponses non satisfaisantes (comme 404, 500, etc.)
//                throw new RuntimeException("Échec de la requête : " + response.statusCode());
//            }
//        } catch (Exception e) {
//            // Gérer les exceptions
//            throw new RuntimeException("Erreur lors de la communication avec l'API", e);
//        }
//    }


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



        return patients;
    }
}