<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp" %>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

    <h2>Connexion</h2>

    <s:form action="login">
        <s:textfield name="adresseMail" label="Adresse Mail" requiredLabel="true" />
        <s:password name="password" label="Mot de passe" requiredLabel="true" />

        <s:submit value="Connexion"/>
    </s:form>
</body>

    <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</html>