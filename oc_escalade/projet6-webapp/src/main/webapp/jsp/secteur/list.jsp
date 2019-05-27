<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp"%>
    <%@ include file="../_include/header.jsp" %>
</head>
<body>

<h2>Liste des secteurs</h2>

<ul>
<s:iterator value="listeSecteur">
<li>
 <s:a action="secteur_detail">
<s:param name="id" value="id" />
<s:property value="nom" />
</s:a>


</li>
</s:iterator>
</ul>

</body>
</html>