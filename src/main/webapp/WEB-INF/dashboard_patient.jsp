<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Espace Patient</title>
        <%@ include file="/WEB-INF/bootstrap.jsp" %>
        <style>
            .card-header {
                background-color: #007bff;
                color: black;
            }
        </style>
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <div class="container mt-4">
            <div class="card mb-4">
                <div class="card-header">Bienvenue, ${patient.prenom}</div>
                <div class="card-body">
                    <h5 class="card-title">Vos Informations:</h5>
                    <p class="card-text">Nom: ${patient.nomFamille}</p>
                    <p class="card-text">Prénom: ${patient.prenom}</p>
                    <p class="card-text">Numéro National: ${patient.numeroNational}</p>
                    <p class="card-text">Adresse: ${patient.adresse} ${patient.numeroAdresse}, ${patient.ville}, ${patient.codePostal}</p>
                    <p class="card-text">Date de Naissance: ${patient.dateNaissance}</p>
                    <p class="card-text">Email: ${patient.email}</p>

                </div>
            </div>
                    
                        <!-- Liste des centres de vaccination -->
    <c:if test="${not empty centres}">
        <h3>Centres de Vaccination Proches</h3>
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <!-- TODO Entêtes de tableau -->
                </thead>
                <tbody>
                    <c:forEach var="centre" items="${centres}">
                        <tr>
                            <td>${centre.nomCentre}</td>
                            <td>${centre.adresse} ${centre.numero}</td>
                            <td>${centre.heureOuverture} - ${centre.heureFermeture}</td>
                            <td>${centre.jourSemaineOuverture}</td>
                         
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

      
        </div>

        <%@ include file="footer.jsp" %>

    </body>
</html>
