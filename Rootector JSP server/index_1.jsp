<%-- 
    Document   : index
    Created on : Feb 4, 2017, 3:14:32 PM
    Author     : welsersy1
--%>
<%@page import="java.sql.*" %>
<%@page import="java.util.Date" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserting data to DB</title>
    </head>
    <body onload="displayResults()">
        <h1>Inserting data to DB</h1>
        <%!
            public class Actor {
                String URL= "jdbc:mysql://localhost:3306/rootector";
                String USERNAME ="root" ;
                String PASSWORD ="allahh";

                Connection connection = null;
                PreparedStatement insertActors= null;
                ResultSet resultSet = null;
                
                public Actor(){
                try {
                  connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                  insertActors = connection.prepareStatement(
                            "INSERT INTO users (fname, lname, uname, password)"
                            + " VALUES (?, ?, ?, ?)"); 
                    
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                 
                 }
               public int setActors (String first, String last, String uname , String pwd){
                int result = 0;
                try{   
                insertActors.setString(1, first);
                insertActors.setString(2, last);
                insertActors.setString(3, uname);
                insertActors.setString(4, pwd);
                //insertActors.setTimestamp(3, timeStamp);
                result= insertActors.executeUpdate();
                } catch (SQLException e){
                    e.printStackTrace();
                }
                return result;

                } 
            }               

            %>
            <% 
                int result= 0;
                
                if (request.getParameter("submit") != null) {
                
                String firstName= new String();
                 String lastName = new String();
                  String uname = new String();
                   String pwd = new String();
                
                
                if (request.getParameter("fname") !=null){
                firstName = request.getParameter("fname");
                }
                if (request.getParameter("lname") !=null){
               lastName = request.getParameter("lname");
                }
                if (request.getParameter("uname") !=null){
               uname = request.getParameter("uname");
                }
                if (request.getParameter("pwd") !=null){
               pwd = request.getParameter("pwd");
                }
                 Date date = new Date();
                 Timestamp timeStamp = new Timestamp(date.getTime());
                 
                 Actor actor = new Actor();
                 result = actor.setActors(firstName, lastName, uname, pwd);
                }
                %>
            
        <form name="myForm" action="index_1.jsp" method="POST">
            <table border="1">
                
                <tbody>
                    <tr>
                        <td>First Name :</td>
                        <td><input type="text" name="fname" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Last Name :</td>
                        <td><input type="text" name="lname" value="" size="50" /></td>
                    </tr>
                     <tr>
                        <td>user Name :</td>
                        <td><input type="text" name="uname" value="" size="50" /></td>
                    </tr>
                     <tr>
                        <td>password :</td>
                        <td><input type="text" name="pwd" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            
            <input type="hidden" name="hidden" value="<%= result%>" />
            <input type="reset" value="Reset" name="rest" />
            <input type="submit" value="Submit" name="submit" />
        </form>
            <SCRIPT LANGUAGE="JavaScript" >
              <!--
              function displayResults()
              {
                    if(document.myForm.hidden.value == 1){
                        alert("Data Inserted");
                    }
                 }     
               // -->    
            </SCRIPT>
    </body>
</html>
