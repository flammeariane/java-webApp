
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <title>Login professionel</title>
  <%@ include file="/WEB-INF/bootstrap.jsp" %>

</head>
<body>
    <div class="container mt-5">
        <h2>Login Professionnel</h2>
        <form action="loginProfessionnel" method="post">
            <div class="form-group">
                <label for="adresseMail">Adresse Mail:</label>
                <input type="email" class="form-control" id="email" name="adresseMail" required>
            </div>
            <div class="form-group">
                <label for="password">Mot de passe:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Se connecter</button>
        </form>
    </div>
    <c:if test="${not empty errorMessage}">
    <div class="alert alert-danger">${errorMessage}</div>
</c:if>

</body>
</html>
