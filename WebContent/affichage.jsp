<%@page import="java.util.ArrayList"%>
<%@page import="services.Service"%>
<%@page import="Tp5.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="affichage.jsp">
<label >Ville :</label>
<input type="text" name="v"/>
<button type=submit >Rechercher</button>
</form>
<%
List<Contact> lc=null;
Service s =new Service();
lc=s.afficherVille(request.getParameter("v"));
if(request.getParameter("v")==""){
	lc=s.afficher();
}else{
	lc=s.afficherVille(request.getParameter("v"));
}%>

<table border="1">
<tr>
	<th>Code</th>
	<th>Nom</th>
	<th>Prenom</th>
	<th>Ville</th>
	<th>Date de naissance</th>
	<th>Modifier</th>
	<th>Supprimer</th>
</tr>

<%for(Contact c:lc){%>
<tr>
<td><%=c.getCode() %></td>
<td><%=c.getNom() %></td>
<td><%=c.getPrenom() %></td>
<td><%=c.getVille() %></td>
<td><%=c.getDn() %></td>
<td><form method="get" action="modifier">
<input type="hidden" name="mod" value="<%=c.getCode()%>">
<button type="submit">mod</button>
</form></td>
<td>
<form method="get" action="supprimer">
<input type="hidden" name="sup" value="<%=c.getCode()%>">
<button type="submit">supp</button>
</form></td>
<td></td>
</tr>

<% }%>

</table>
<a href="form.jsp" >Ajouter nouveau contatc</a>

<%
int nbrp=1;
int nbr=s.nbrPages(3);
if(request.getParameter("nbr")!=null){
	nbrp=Integer.parseInt(request.getParameter("nbr"));
	if(nbrp>nbr||nbrp<0){
	response.sendRedirect("affichage.jsp?nbr=1");
	//request.getRequestDispatcher("affichage.jsp?nbr=1").forward(request, response);
	}
}


lc=s.afficherPagination(nbrp, 3);
%>

<table border="1">
<tr>
	<th>Code</th>
	<th>Nom</th>
	<th>Prenom</th>
	<th>Ville</th>
	<th>Date de naissance</th>
	<th>Modifier</th>
	<th>Supprimer</th>
</tr>

<%for(Contact c:lc){%>
<tr>
<td><%=c.getCode() %></td>
<td><%=c.getNom() %></td>
<td><%=c.getPrenom() %></td>
<td><%=c.getVille() %></td>
<td><%=c.getDn() %></td>
<td><form method="get" action="modifier">
<input type="hidden" name="mod" value="<%=c.getCode()%>">
<button type="submit">mod</button>
</form></td>
<td>
<form method="get" action="supprimer">
<input type="hidden" name="sup" value="<%=c.getCode()%>">
<button type="submit">supp</button>
</form></td>
<td></td>
</tr>

<% }%>

</table>

<%for(int i=1;i<=nbr;i++){%>
<center><a href="affichage.jsp?nbr=<%=i%>"><%=i %></a></center>
<%} %>


</body>
</html>