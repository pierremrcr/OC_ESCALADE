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

	<h2>Détail d'une voie</h2>

	<ul>
		<li>Nom : <s:property value="voie.nom" /></li><br/>
		<li>Description : <s:property value="voie.description" /></li><br/>
			
	</ul>

</body>
</html>