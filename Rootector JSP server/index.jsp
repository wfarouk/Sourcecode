<%-- 
    Document   : index
    Created on : Feb 3, 2017, 12:13:38 AM
    Author     : welsersy1
--%>
<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selecting a Data from DB</title>
    </head>
    <body>
        <h1>List of scanned devices</h1>
        <%!
            public class Actor {
                String URL= "jdbc:mysql://localhost:3306/rootector";
                String USERNAME ="root" ;
                String PASSWORD ="allahh";

                Connection connection = null;
                PreparedStatement selectActors= null;
                ResultSet resultSet = null;
                
                public Actor(){
                try {
                  connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                  selectActors = connection.prepareStatement("SELECT projectprojectID, useruserID , BuildFingerPrint, BuildID, KernelVersion, BuildBrand, BuildManuf, BuildModel, BuildRelease, BuildSDK, BuildABIList, imeistring, imsistring, serialnum, serialnum2, androidId FROM devices"); 
                    
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                 
                 }
                public ResultSet getActors()
                {
                    try { 
                        resultSet = selectActors.executeQuery();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                           return resultSet;
                        }
                    }               

            %>
            <% 
               Actor actor = new Actor();
               ResultSet actors = actor.getActors();
                %>
                <table border="1">
                    
                    <tbody>
                        <tr>
                            <td>Project ID</td>
                            <td>User ID</td>
                            <td>Android ID</td>
                        </tr>
                        <% while (actors.next()){ %>
                        <tr>
                            <td><%= actors.getString("projectprojectID")%></td>
                            <td><%= actors.getString("useruserID") %></td>
                            <td><href=display.jsp><%= actors.getString("androidId") %></href></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>

                
    </body>
</html>
