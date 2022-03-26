<%-- 
    Document   : index
    Created on : Feb 6, 20?7, ??:34:33 PM
    Author     : welsersy?
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
        <h?>Hello World!</h?>
        <% 
                String URL= "jdbc:mysql://localhost:3306/rootector";
                String USERNAME ="root" ;
                String PASSWORD ="allahh";
                Connection connection = null;
                PreparedStatement insertUsers= null;
                ResultSet resultSet = null;
                int result = 0;
                
                                
                String useruserID = request.getParameter("useruserID");
                String projectprojectID = request.getParameter("projectprojectID");
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
                  insertUsers = connection.prepareStatement("INSERT INTO devices VALUES(default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
               
                insertUsers.setString(1,projectprojectID); 
                insertUsers.setString(2,useruserID); 
                insertUsers.setString(3,"BuildFingerPrint");
                insertUsers.setString(4,BuildID);
                insertUsers.setString(5,KernelVersion);
                insertUsers.setString(6,BuildBrand);  
                insertUsers.setString(7,BuildManuf);  
                insertUsers.setString(8,BuildModel);  
                insertUsers.setString(9,BuildRelease);
                insertUsers.setString(10,BuildSDK);  
                insertUsers.setString(11,BuildABIList);
                insertUsers.setString(12,imeistring);  
                insertUsers.setString(13,imsistring);  
                insertUsers.setString(14,serialnum);  
                insertUsers.setString(15,serialnum2); 
                insertUsers.setString(16,androidId); 
                
                result = insertUsers.executeUpdate(); 
                   
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
             
                
             
    %>
    
    </body>
</html>
