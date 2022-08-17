<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body style="background:grey;text-align:center;">

  <center> <h1> Login Page</h1> </center>   
    <form action="AdminServlet" method="POST">  
        <div class="container">   
        	<input type="hidden" name="command" value="LOGIN" />
            <label>Enter Username : </label>   
            <input type="text" placeholder="login" name="username" required>  
            <br/>
            <label>Enter Password : </label>   
            <input type="password" placeholder="password" name="password" required>  
            <br/>
            <button type="submit">Login</button>   
            <br/>
        </div>   
    </form>     


</body>
</html>