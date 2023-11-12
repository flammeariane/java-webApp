package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Exemple de redirection si l'utilisateur est déjà connecté
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String userRole = (String) session.getAttribute("role");
            redirectToDashboard(userRole, request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Logique d'authentification
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (authenticate(username, password)) {
            String userRole = getUserRole(username);

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", userRole);

            redirectToDashboard(userRole, request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
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
