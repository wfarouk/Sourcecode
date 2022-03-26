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
                PreparedStatement insertFeatures= null;
                ResultSet resultSet = null;
                int result = 0;
 
    String deviceID = request.getParameter("deviceID");
    String projectprojectID = request.getParameter("projectprojectID");
    String useruserID = request.getParameter("useruserID");
   // String collectedTime = request.getParameter("collectedTime"); 
    int f1 = Boolean.valueOf(Boolean.valueOf(request.getParameter("f1"))).compareTo( false );
    int f2 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f2"))).compareTo( false );
    int f3 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f3"))).compareTo( false );
    int f4 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f4"))).compareTo( false );
    int f5 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f5"))).compareTo( false );
    int f6 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f6"))).compareTo( false );
    int f7 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f7"))).compareTo( false );
    int f8 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f8"))).compareTo( false );
    int f9 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f9"))).compareTo( false );
    int f10 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f10"))).compareTo( false );
    int f11 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f11"))).compareTo( false );
    int f12 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f12"))).compareTo( false );
    int f13 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f13"))).compareTo( false );
    int f14 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f14"))).compareTo( false );
    int f15 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f15"))).compareTo( false );
    int f16 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f16"))).compareTo( false );
    int f17 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f17"))).compareTo( false );
    int f18 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f18"))).compareTo( false );
    int f19 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f19"))).compareTo( false );
    int f20 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f20"))).compareTo( false );
    int f21 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f21"))).compareTo( false );
    int f22 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f22"))).compareTo( false );
    int f23 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f23"))).compareTo( false );
    int f24 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f24"))).compareTo( false );
    int f25 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f25"))).compareTo( false );
    int f26 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f26"))).compareTo( false );
    int f27 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f27"))).compareTo( false );
    int f28 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f28"))).compareTo( false );
    int f29 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f29"))).compareTo( false );
    int f30 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f30"))).compareTo( false );
    int f31 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f31"))).compareTo( false );
    int f32 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f32"))).compareTo( false );
    int f33 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f33"))).compareTo( false );
    int f34 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f34"))).compareTo( false );
    int f35 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f35"))).compareTo( false );
    int f36 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f36"))).compareTo( false );
    int f37 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f37"))).compareTo( false );
    int f38 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f38"))).compareTo( false );
    int f39 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f39"))).compareTo( false );
    int f40 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f40"))).compareTo( false );
    int f41 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f41"))).compareTo( false );
    int f42 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f42"))).compareTo( false );
    int f43 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f43"))).compareTo( false );
    int f44 = Boolean.valueOf(Boolean.valueOf( request.getParameter("f44"))).compareTo( false );
    int fn1 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn1"))).compareTo( false );
    int fn2 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn2"))).compareTo( false );
    int fn3 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn3"))).compareTo( false );
    int fn4 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn4"))).compareTo( false );
    int fn5 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn5"))).compareTo( false );
    int fn6 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn6"))).compareTo( false );
    int fn7 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn7"))).compareTo( false );
    int fn8 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn8"))).compareTo( false );
    int fn9 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn9"))).compareTo( false );
    int fn10 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn10"))).compareTo( false );
    int fn11 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn11"))).compareTo( false );
    int fn12 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn12"))).compareTo( false );
    int fn13 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn13"))).compareTo( false );
    int fn14 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn14"))).compareTo( false );
    int fn15 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn15"))).compareTo( false );
    int fn16 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn16"))).compareTo( false );
    int fn17 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn17"))).compareTo( false );
    int fn18 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn18"))).compareTo( false );
    int fn19 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn19"))).compareTo( false );
    int fn20 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn20"))).compareTo( false );
    int fn21 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn21"))).compareTo( false );
    int fn22 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn22"))).compareTo( false );
    int fn23 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn23"))).compareTo( false );
    int fn24 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn24"))).compareTo( false );
    int fn25 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn25"))).compareTo( false );
    int fn26 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn26"))).compareTo( false );
    int fn27 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn27"))).compareTo( false );
    int fn28 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn28"))).compareTo( false );
    int fn29 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn29"))).compareTo( false );
    int fn30 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn30"))).compareTo( false );
    int fn31 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn31"))).compareTo( false );
    int fn32 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn32"))).compareTo( false );
    int fn33 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn33"))).compareTo( false );
    int fn34 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn34"))).compareTo( false );
    int fn35 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn35"))).compareTo( false );
    int fn36 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn36"))).compareTo( false );
    int fn37 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn37"))).compareTo( false );
    int fn38 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn38"))).compareTo( false );
    int fn39 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn39"))).compareTo( false );
    int fn40 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn40"))).compareTo( false );
    int fn41 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn41"))).compareTo( false );
    int fn42 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn42"))).compareTo( false );
    int fn43 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn43"))).compareTo( false );
    int fn44 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn44"))).compareTo( false );
    int fn45 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn45"))).compareTo( false );
    int fn46 = Boolean.valueOf(Boolean.valueOf( request.getParameter("fn46"))).compareTo( false );
    int orgLabel = Boolean.valueOf(Boolean.valueOf( request.getParameter("orgLabel"))).compareTo( false );
    
          
                 try {
                  connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                  insertFeatures = connection.prepareStatement("INSERT INTO features VALUES(default,?,?,?,default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
               
                
                insertFeatures.setString(1,deviceID);
                insertFeatures.setString(	2	,	"10"	);
                insertFeatures.setString(	3	,	useruserID	);
                insertFeatures.setInt(	4	,	f1	);
                insertFeatures.setInt(	5	,	f2	);
                insertFeatures.setInt(	6	,	f3	);
                insertFeatures.setInt(	7	,	f4	);
                insertFeatures.setInt(	8	,	f5	);
                insertFeatures.setInt(	9	,	f6	);
                insertFeatures.setInt(	10	,	f7	);
                insertFeatures.setInt(	11	,	f8	);
                insertFeatures.setInt(	12	,	f9	);
                insertFeatures.setInt(	13	,	f10	);
                insertFeatures.setInt(	14	,	f11	);
                insertFeatures.setInt(	15	,	f12	);
                insertFeatures.setInt(	16	,	f13	);
                insertFeatures.setInt(	17	,	f14	);
                insertFeatures.setInt(	18	,	f15	);
                insertFeatures.setInt(	19	,	f16	);
                insertFeatures.setInt(	20	,	f17	);
                insertFeatures.setInt(	21	,	f18	);
                insertFeatures.setInt(	22	,	f19	);
                insertFeatures.setInt(	23	,	f20	);
                insertFeatures.setInt(	24	,	f21	);
                insertFeatures.setInt(	25	,	f22	);
                insertFeatures.setInt(	26	,	f23	);
                insertFeatures.setInt(	27	,	f24	);
                insertFeatures.setInt(	28	,	f25	);
                insertFeatures.setInt(	29	,	f26	);
                insertFeatures.setInt(	30	,	f27	);
                insertFeatures.setInt(	31	,	f28	);
                insertFeatures.setInt(	32	,	f29	);
                insertFeatures.setInt(	33	,	f30	);
                insertFeatures.setInt(	34	,	f31	);
                insertFeatures.setInt(	35	,	f32	);
                insertFeatures.setInt(	36	,	f33	);
                insertFeatures.setInt(	37	,	f34	);
                insertFeatures.setInt(	38	,	f35	);
                insertFeatures.setInt(	39	,	f36	);
                insertFeatures.setInt(	40	,	f37	);
                insertFeatures.setInt(	41	,	f38	);
                insertFeatures.setInt(	42	,	f39	);
                insertFeatures.setInt(	43	,	f40	);
                insertFeatures.setInt(	44	,	f41	);
                insertFeatures.setInt(	45	,	f42	);
                insertFeatures.setInt(	46	,	f43	);
                insertFeatures.setInt(	47	,	f44	);
                insertFeatures.setInt(	48	,	fn1	);
                insertFeatures.setInt(	49	,	fn2	);
                insertFeatures.setInt(	50	,	fn3	);
                insertFeatures.setInt(	51	,	fn4	);
                insertFeatures.setInt(	52	,	fn5	);
                insertFeatures.setInt(	53	,	fn6	);
                insertFeatures.setInt(	54	,	fn7	);
                insertFeatures.setInt(	55	,	fn8	);
                insertFeatures.setInt(	56	,	fn9	);
                insertFeatures.setInt(	57	,	fn10	);
                insertFeatures.setInt(	58	,	fn11	);
                insertFeatures.setInt(	59	,	fn12	);
                insertFeatures.setInt(	60	,	fn13	);
                insertFeatures.setInt(	61	,	fn14	);
                insertFeatures.setInt(	62	,	fn15	);
                insertFeatures.setInt(	63	,	fn16	);
                insertFeatures.setInt(	64	,	fn17	);
                insertFeatures.setInt(	65	,	fn18	);
                insertFeatures.setInt(	66	,	fn19	);
                insertFeatures.setInt(	67	,	fn20	);
                insertFeatures.setInt(	68	,	fn21	);
                insertFeatures.setInt(	69	,	fn22	);
                insertFeatures.setInt(	70	,	fn23	);
                insertFeatures.setInt(	71	,	fn24	);
                insertFeatures.setInt(	72	,	fn25	);
                insertFeatures.setInt(	73	,	fn26	);
                insertFeatures.setInt(	74	,	fn27	);
                insertFeatures.setInt(	75	,	fn28	);
                insertFeatures.setInt(	76	,	fn29	);
                insertFeatures.setInt(	77	,	fn30	);
                insertFeatures.setInt(	78	,	fn31	);
                insertFeatures.setInt(	79	,	fn32	);
                insertFeatures.setInt(	80	,	fn33	);
                insertFeatures.setInt(	81	,	fn34	);
                insertFeatures.setInt(	82	,	fn35	);
                insertFeatures.setInt(	83	,	fn36	);
                insertFeatures.setInt(	84	,	fn37	);
                insertFeatures.setInt(	85	,	fn38	);
                insertFeatures.setInt(	86	,	fn39	);
                insertFeatures.setInt(	87	,	fn40	);
                insertFeatures.setInt(	88	,	fn41	);
                insertFeatures.setInt(	89	,	fn42	);
                insertFeatures.setInt(	90	,	fn43	);
                insertFeatures.setInt(	91	,	fn44	);
                insertFeatures.setInt(	92	,	fn45	);
                insertFeatures.setInt(	93	,	fn46	);
                insertFeatures.setInt(	94	,	orgLabel	);
                insertFeatures.setInt(	95	,	0	);         
                
                result = insertFeatures.executeUpdate(); 
                   
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
             
                
             
    %>
    
    </body>
</html>
