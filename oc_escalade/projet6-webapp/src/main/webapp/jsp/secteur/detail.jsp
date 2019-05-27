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

	<h2>Détail d'un secteur</h2>

	<ul>
		<li>Nom : <s:property value="secteur.nom" /></li><br/>
		<li>Description : <s:property value="secteur.description" /></li><br/>
		<li>Propriétaire du topo : <s:property value="topo.utilisateur.nom"/>
		                           <s:property value="topo.utilisateur.prenom"/></li>
			
	</ul>
	
	
	      <s:a action="deleteSecteur">
        <s:param value="secteur.id" name="id"/>
        <button class="btn btn-primary">Supprimer ce secteur</button>
        </s:a>
        

</body>
</html>