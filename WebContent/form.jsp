<%@page import="services.Service"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Tp5.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="Client" method="get" action="./client">
				 
		
		<table>
		<tr><th><label for="code"><b>Code </b></label></th>
		<th><input type=text name="code" ></input></th></tr>
		<tr><th><label for="nom"><b>Nom:  </b></label></th>
		<th><input type=text name="nom"></input></th></tr>
		<tr><th><label for="prenom" ><b>Prénom:  </b></label></th>
		<th><input type=text name="prenom"></input></th></tr>
		<tr><th><label for="ville"><b>Ville </b></label></th>
		<th><select name="ville">
				            <option value="Oujda" >Oujda</option> 
				            <option value="Rabat" >Rabat</option>
				            <option value="Fes" >Fes</option> 
		</select></th></tr>
		<tr><th><label for="dn"><b>Date de naissance</b></label></th>
		<th><input type=text name="dn" ></input></th></tr></table>
		<button type=submit>ajouter</button> <button type=reset >réinitialiser</button></form>
		
</body>
</html>