package servlets;

import model.MembrePersonnel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.service.ProfessionnelService;

@WebServlet(name = "LoginProfessionnelServlet", urlPatterns = "/loginProfessionnel")
public class LoginProfessionnelServlet extends HttpServlet {

    private ProfessionnelService professionnelService = new ProfessionnelService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adresseMail = request.getParameter("adresseMail");
        String password = request.getParameter("password");

        try {
            MembrePersonnel membre = professionnelService.login(adresseMail, password);
            if (membre != null) {
                String role = membre.getRole();
                switch (role) {
                    case "Infirmier":
                    case "Medecin":
                         request.getRequestDispatcher("/WEB-INF/dashboard_medecin.jsp").forward(request, response);
                      
                        break;
                    case "Accueillant en entree":
                    case "Accueillant de sortie":
                        request.getRequestDispatcher("/WEB-INF/dashboard_acceuillant.jsp").forward(request, response);
                        
                        break;
                    case "Responsable de centre":
                    case "Responsable generale":
                        request.getRequestDispatcher("/WEB-INF/dashboard_responsable.jsp").forward(request, response);
                   
                        break;
                    default:
            
                        request.getRequestDispatcher("/WEB-INF/login_pro.jsp").forward(request, response); // Rediriger vers la page de login avec un message d'erreur
                        break;
                }
            } else {
                request.setAttribute("errorMessage", "Identifiants incorrects");
                request.getRequestDispatcher("/WEB-INF/loginProfessionnel.jsp").forward(request, response);
            }
        } catch (InterruptedException e) {
            e.printStackTrace(); // Ceci est un exemple minimal pour afficher la trace de l'exception
        }
    }
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login_pro.jsp").forward(request, response);
    }
}

