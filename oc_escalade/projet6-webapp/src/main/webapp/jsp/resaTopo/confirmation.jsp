<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>


<html>

<head>

<%@include file="../_include/head.jsp" %>

<%@ include file="../_include/header.jsp" %>

</head>

<body>
<div class="container-fluid">

    <h5>Votre réservation a été enregistrée</h5>
    
    <s:a action="index">Retour à l'accueil</s:a>
    
</div>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>
</body>
</html>