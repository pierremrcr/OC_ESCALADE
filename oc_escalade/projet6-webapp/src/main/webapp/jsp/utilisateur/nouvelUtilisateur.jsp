<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp"%>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

<h2>Inscription au Site Escalade P6</h2>

<s:form action="nouvel_utilisateur">


<s:textfield name="utilisateur.nom" label="Nom" requiredLabel="true" ></s:textfield>
<s:textfield name="utilisateur.prenom" label="Prénom" requiredLabel="true" ></s:textfield>
<s:textfield name="utilisateur.adresseMail" label="Email" requiredLabel="true" ></s:textfield>
<s:textfield name="utilisateur.motDePasse" label="Mot de passe" requiredLabel="true" type="password" ></s:textfield>
<s:textfield name="utilisateur.presentation" label="Présentation" requiredLabel="true" ></s:textfield>
<s:textfield name="utilisateur.niveau" label="Niveau" requiredLabel="true" ></s:textfield>


<s:submit value="OK"/>



</s:form>

     <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>