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

<h2>Liste des utilisateurs</h2>

<ul>
<s:iterator value="listUtilisateur">
<li>
 <s:a action="utilisateur_detail">
<s:param name="id" value="id" />
<s:property value="nom" />
<s:property value="prenom" />
  </s:a>


</li>
</s:iterator>
</ul>

    <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>


</body>
</html>