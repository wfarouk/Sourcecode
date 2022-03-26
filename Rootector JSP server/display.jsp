<%-- 
    Document   : display.jsp
    Created on : Feb 3, 2017, 10:53:40 PM
    Author     : welsersy1
--%>
<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selecting Specific Data From A DB</title>
    </head>
    <body>
        <h1>Selecting Specific Data From A DB</h1>
        <%!
            public class Actor {
                String URL= "jdbc:mysql://localhost:3306/sakila";
                String USERNAME ="root" ;
                String PASSWORD ="allahh";

                Connection connection = null;
                PreparedStatement selectActors= null;
                ResultSet resultSet = null;
                
                public Actor(){
                try {
                  connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                  selectActors = connection.prepareStatement(
                            "SELECT a.first_name, a.last_name, c.title"
                            + " FROM actor a, film_actor b, film c"
                            + " WHERE a.first_name = ?"    
                            + " AND a.last_name =? "
                            + " AND a.actor_id = b.actor_id"
                            + " AND b.film_id = c.film_id"); 
                    
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                 
                 }
                public ResultSet getActors(String first, String last)
                {
                    
                    try { 
                        selectActors.setString(1, first);
                        selectActors.setString(2, last);

                        resultSet = selectActors.executeQuery();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                           return resultSet;
                        }
                    }               

            %>
            <%
                String firstName = new String();
                String lastName = new String();
                
                if (request.getParameter("first")!=null){
                    firstName = request.getParameter("first");
                }

                if (request.getParameter("last")!=null){
                    lastName = request.getParameter("last");
                }
                   Actor actor = new Actor();
                   ResultSet actors = actor.getActors(firstName, lastName);
                   

                %>
                <table border="1">
                   
                    <tbody>
                        <tr>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Title</td>
                        </tr>
                        <% while (actors.next()){ %>
                        <tr>
                            <td><%= actors.getString("first_name") %></td>
                            <td><%= actors.getString("last_name") %></td>
                            <td><%= actors.getString("title") %></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>

    </body>
</html>
