<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
              
<%@ include file="header.jsp" %>
        <h1>Welcome, ${loggedInUser}! patient dashboard</h1> 

  <%@ include file="footer.jsp" %>
  
    </body>
</html>
