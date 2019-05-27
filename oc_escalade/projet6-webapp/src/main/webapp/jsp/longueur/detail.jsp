<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp" %>
</head>
<body>

	<h2>Détail d'une longueur</h2>

	<ul>
		<li>Nom : <s:property value="longueur.nom" /></li><br/>
		<li>Nombre de points : <s:property value="longueur.nombreDePoints" /></li><br/>
		<li>Cotation : <s:property value="longueur.cotation" />
		<li>Hauteur : <s:property value="longueur.hauteur" />
		</li>

	</ul>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>
</body>
</html>