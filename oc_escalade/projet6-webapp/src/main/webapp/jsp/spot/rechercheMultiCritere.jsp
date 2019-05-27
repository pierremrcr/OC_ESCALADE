<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<head>

<%@ include file="../_include/head.jsp"%>

</head>


<header>

	<%@ include file="../_include/header.jsp"%>

</header>

<h2>Recherchez un site</h2>

<s:form action="rechercheMultiCritere">

	<s:select name="selectRegion"
	label="Région" list="listeSpot" listKey="region" listValue="region"
	emptyOption="true" requiredLabel="true" />

	<s:select name="selectNombreDePoints"
	label="Nombre de points de la longueur" list="nombreDepoints"
	emptyOption="true" requiredLabel="true" />

	<s:select name="selectCotation"
		label="Choix de la difficulté (Cotation longueur)"
		list="listeCotation" emptyOption="true" requiredLabel="true" />
		

 
 <s:submit value="Validez" />

</s:form>

<body>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>