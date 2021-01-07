<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="services.Service"%>
<%@page import="Tp5.Contact"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Contact c=(Contact)request.getAttribute("contact"); %>
<form name="Client" method="get" action="./modifierFinal">
				 
		
		<table>
		<tr><th><label for="code"><b>Code </b></label></th>
		<th><input type=text name="code" value="<%=c.getCode()%>"></input></th></tr>
		<tr><th><label for="nom"><b>Nom:  </b></label></th>
		<th><input type=text name="nom" value="<%=c.getNom()%>"></input></th></tr>
		<tr><th><label for="prenom" ><b>Prénom:  </b></label></th>
		<th><input type=text name="prenom" value="<%=c.getPrenom()%>"></input></th></tr>
		<tr><th><label for="ville"><b>Ville </b></label></th>
		<th><select name="ville" >
				            <option value="Oujda" >Oujda</option> 
				            <option value="Rabat" >Rabat</option>
				            <option value="Fes" >Fes</option> 
		</select></th></tr>
		<tr><th><label for="dn" ><b>Date de naissance</b></label></th>
		<th><input type=text name="dn" value="<%=c.getDn()%>"></input></th></tr></table>
		<button type=submit>modifier</button> 
		</form>
		
</body>
</html>