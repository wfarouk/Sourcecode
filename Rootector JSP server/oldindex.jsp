<%-- 
    Document   : index
    Created on : Feb 6, 2017, 11:34:33 PM
    Author     : welsersy1
--%>
<%@page import="java.sql.*" %>
<%@page import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
                String URL= "jdbc:mysql://localhost:3306/rootector";
                String USERNAME ="root" ;
                String PASSWORD ="allahh";
                Connection connection = null;
                PreparedStatement insertUsers= null;
                ResultSet resultSet = null;
                int result = 0;
                
                String fname= request.getParameter("fname");
                String lname= request.getParameter("lname");
                String uname = request.getParameter("uname");
                String password =request.getParameter("pwd");
      
                /* String fname = "fname";
                String lname= "lname";
                String uname = "uname3";
                String password = "pwd";
                */
                 try {
                  connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                  insertUsers = connection.prepareStatement(
                            "INSERT INTO users (fname, lname, uname, password )"
                            + " VALUES ('" +fname+ "' , '" +lname +"' , '"  + uname + "' , '" + password + "' )"); 
                   
                  result = insertUsers.executeUpdate(); 
                   
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                 
                
             
    %>
    
    </body>
</html>
