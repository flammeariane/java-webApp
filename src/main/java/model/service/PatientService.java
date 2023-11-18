package model.service;

import bean.PatientBean;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.PatientLogin;


public class PatientService {
    
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PatientLogin loginPatient(String numeroNational, String codeSecret) throws IOException, InterruptedException {
        Map<String, String> loginData = new HashMap<>();
        loginData.put("numeroNational", numeroNational);
        loginData.put("codeSecret", codeSecret);

        String requestBody = objectMapper.writeValueAsString(loginData);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/Centre_vaccination_SGBD/login"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            // Suppose que l'API renvoie les détails du patient en cas de succès
            return objectMapper.readValue(response.body(), PatientLogin.class);
        } else {
            // En cas d'échec, renvoie null ou gère selon les besoins de votre application
            return null;
        }
    }
 


    public List<PatientBean> getListeDesPatientsDuJour() {
        return null;
    }
}

