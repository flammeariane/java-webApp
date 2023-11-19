package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PatientLogin;
import model.service.PatientService;
import bean.RendezVousBean;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private PatientService patientService = new PatientService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numeroNational = request.getParameter("numeroNational");
        String codeSecret = request.getParameter("codeSecret");

        try {
            PatientLogin patient = patientService.loginPatient(numeroNational, codeSecret);
            if (patient != null) {
                HttpSession session = request.getSession();
                session.setAttribute("patient", patient);
             List<RendezVousBean> rendezVousList = patientService.getListeDesRendezVousDuPatient();
              request.setAttribute("rendezVousList", rendezVousList); 
           

                request.getRequestDispatcher("/WEB-INF/dashboard_patient.jsp").forward(request, response);

            } else {
                request.setAttribute("errorMessage", "Identifiants incorrects");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Erreur de connexion au serveur");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
