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

	<h2>Détail d'un commentaire</h2>

	<ul>
		<li>Contenu : <s:property value="commentaireTopo.contenu" /></li><br/>
		<li>Date : <s:property value="commentaireTopo.date" /></li><br/>
		<li>Auteur du commentaire : <s:property value="commentaire.utilisateur.nom"/>
		                            <s:property value="topo.utilisateur.prenom"/>
		</li>

	</ul>
	
	
	</body>
</html>