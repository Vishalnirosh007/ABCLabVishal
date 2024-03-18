<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Login</title>
<script>
    function displayErrorMessage(message) {
        var errorMessageDiv = document.getElementById("errorMessage");
        errorMessageDiv.innerText = message;
        errorMessageDiv.style.display = "block";
    }
</script>
</head>
<body>
    <h2>Patient Login</h2>
    <form action="patientLoginController" method="post">
        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Login" onclick="return validateForm()">
        
        <div id="errorMessage" style="display: none; color: red;"></div>
    </form>
    <p><a href="PatientRegister.jsp">Register</a></p>

    <script>
        function validateForm() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            
            // You can add client-side validation if needed
            
            // If the username or password is empty, display an error message
            if (username.trim() === "" || password.trim() === "") {
                displayErrorMessage("Username and password are required.");
                return false;
            }
            
            // If no validation errors, submit the form
            return true;
        }
    </script>
</body>
</html>
