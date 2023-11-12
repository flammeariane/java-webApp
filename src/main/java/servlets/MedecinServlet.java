



package servlets;

import bean.PatientBean;
import java.util.List;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.service.PatientService;





@WebServlet(name = "MedecinDashboardServlet", urlPatterns = {"/dashboardMedecin"})
public class MedecinServlet extends HttpServlet {

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            request.setAttribute("username", username);
        }
        PatientService patientService = new PatientService();
        List<PatientBean> patients = patientService.getListeDesPatientsDuJour();

        request.setAttribute("patients", patients);

        request.getRequestDispatcher("/WEB-INF/dashboard_medecin.jsp").forward(request, response);

    }
    
    
}





