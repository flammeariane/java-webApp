<!DOCTYPE html>
<html>
    <head>
        <title>Votre Application - Centre de Vaccination</title>
        <%@ include file="/WEB-INF/bootstrap.jsp" %>
        <style>
            #header {
                background: url('static/img/banner1.jpg') no-repeat center center;
            
                background-size: cover;
                background-position: top;
                color: black;
                text-align: center; /* Garde le titre centr� */
                padding: 5rem 0;
                position: relative; /* Position relative pour le bouton */
            }

            #header h1 {
                color: whitesmoke;
                margin: 0;
                font-size: 2.5em;
            }
            
  

            .logout-button {
                position: absolute; /* Position absolue pour le bouton */
                bottom: 10px; /* Marge du bas */
                right: 10px; /* Marge de droite */
            }
        </style>
    </head>
    <body>

        <div id="header">
            <h1>Centre de Vaccination</h1>
            <form action="logout" method="post" class="logout-button">
                <button type="submit" class="btn btn-danger">D�connexion</button>
            </form>
             <p class="">Nous somme ouvert tous les jours de 09h00 � 17h00</p>
        </div>

    </body>
</html>
