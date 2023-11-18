package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PatientLogin;
import model.service.PatientService;

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


 private void redirectToDashboard(String userRole, HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    String path = null;
    switch (userRole) {
        case "patient":
            path = "/dashboard_patient.jsp";
            break;
        case "médecin":
            path = "/dashboard_medecin.jsp";
            break;
        case "acceuillant entrée":
        case "acceuillant sortie":
            response.sendRedirect(request.getContextPath() + "/dashboardAccueillant"); // Redirection vers le servlet accueillant
            return; // Arrête l'exécution après la redirection
        case "responsable centre":
        case "responsable générale":
            path = "/dashboard_responsable.jsp";
            break;
        default:
            path = "/login.jsp";
            break;
    }

    if (path != null) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF" + path);
        dispatcher.forward(request, response);
    }
}

    private boolean authenticate(String username, String password) {
        // Simulation de l'API
        return "med".equals(username) && "password".equals(password);
    }

    private String getUserRole(String username) {
        // Simulation de la réponse en fonction du nom d'utilisateur
        switch (username.toLowerCase()) {
            case "admin":
                return "responsable générale";
            case "med":
                return "médecin";
            case "acc":
                return "acceuillant entrée";
            case "accsort":
                return "acceuillant sortie";
            case "responsable":
                return "responsable centre";
            case "patient":
                return "patient";
            default:
                return "role inconnu";
        }
    }
}
