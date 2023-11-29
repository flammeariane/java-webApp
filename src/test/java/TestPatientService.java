
import model.service.PatientService;
import model.CentreVaccination;
import java.io.IOException;
import java.util.List;

public class TestPatientService {

    public static void main(String[] args) {
        PatientService patientService = new PatientService();

        try {

            patientService.loginPatient("numeroNational", "codeSecret");

            List<CentreVaccination> centres = patientService.getCentresVaccination();

            if (centres != null) {
                for (CentreVaccination centre : centres) {
                    System.out.println(centre); // Assurez-vous que CentreVaccination a une méthode toString() bien définie
                }
            } else {
                System.out.println("Aucun centre de vaccination trouvé ou erreur lors de la récupération des données.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
