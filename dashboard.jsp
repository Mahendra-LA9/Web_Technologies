<%@ page import="javax.servlet.http.Cookie" %>
<%
    String name = (String) request.getAttribute("name");
    String course = (String) request.getAttribute("course");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 500px;
            margin: 80px auto;
            padding: 40px;
            background-color: #ffffff;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
            border-radius: 12px;
            text-align: center;
        }

        h2 {
            color: #2c3e50;
        }

        p {
            font-size: 18px;
            color: #34495e;
        }

        a.logout-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #e74c3c;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            transition: background-color 0.3s ease;
        }

        a.logout-btn:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Welcome, <%= name %>!</h2>
    <p><strong>Your Course:</strong> <%= course %></p>
    <a class="logout-btn" href="LogoutServlet">Logout</a>
</div>

</body>
</html>
