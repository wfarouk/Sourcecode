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
                
                             
                int useruserID = Integer.valueOf(request.getParameter("useruserID"));
                int projectprojectID = Integer.valueOf(request.getParameter("projectprojectID"));
                String BuildFingerPrint = request.getParameter("BuildFingerPrint");
                String BuildID = request.getParameter("BuildID");
                String KernelVersion = request.getParameter("KernelVersion");
                String BuildBrand = request.getParameter("BuildBrand");
                String BuildManuf = request.getParameter("BuildManuf");
                String BuildModel = request.getParameter("BuildModel");
                String BuildRelease = request.getParameter("BuildRelease");
                String BuildSDK = request.getParameter("BuildSDK");
                String BuildABIList = request.getParameter("BuildABIList");
                String imeistring = request.getParameter("imeistring");
                String imsistring = request.getParameter("imsistring");
                String serialnum = request.getParameter("serialnum");
                String serialnum2 = request.getParameter("serialnum2");
                String androidId = request.getParameter("androidId");
                
                                               
                 try {
                  connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                  insertUsers = connection.prepareStatement(
                            "INSERT INTO devices ( projectprojectID, useruserID , BuildFingerPrint, BuildID, KernelVersion, BuildBrand, BuildManuf, BuildModel, BuildRelease, BuildSDK, BuildABIList, imeistring, imsistring, serialnum, serialnum2, androidId)"
                              + " VALUES ( " +projectprojectID+ " , " +useruserID+" , '" +BuildFingerPrint+ "' , '" + BuildID + "' + '" +KernelVersion+ "' , '" +BuildBrand +"' , '"  + BuildManuf + "' , '" + BuildModel + "' , '" +BuildRelease+ "' ,'" +BuildSDK+ "' ,'" +BuildABIList+ "' ,'" +imeistring+ "' ,'" +imsistring+ "' ,'" +serialnum+ "' ,'" +serialnum2+ "' ,'" +androidId + "' )"); 
                                        
               
                
                result = insertUsers.executeUpdate(); 
                   
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                 
                
             
    %>
    
    </body>
</html>
