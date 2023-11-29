package model.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import model.CentreVaccination;
import model.PatientLogin;
import utils.HttpClientUtils;

public class PatientService {
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOGGER = Logger.getLogger(PatientService.class.getName());

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

        HttpResponse<String> response = HttpClientUtils.sendRequest(() -> request);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), PatientLogin.class);
        } else {
            LOGGER.warning("Réponse du serveur avec le code d'état: " + response.statusCode());
            return null;
        }
    }
    
    public List<CentreVaccination> getCentresVaccination() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/Centre_vaccination_SGBD/rendezVous"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClientUtils.sendRequest(() -> request);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), new TypeReference<List<CentreVaccination>>() {});
        } else {
            LOGGER.warning("Réponse du serveur avec le code d'état: " + response.statusCode());
            return Collections.emptyList();
        }
    }

 
}
