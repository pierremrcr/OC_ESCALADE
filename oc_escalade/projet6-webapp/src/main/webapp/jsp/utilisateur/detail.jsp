<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>
</head>
<body>

   <h2>Détail du compte</h2>

   <ul>

      <li>Nom : <s:property value="utilisateur.nom" /></li>
      <li>Prénom : <s:property value="utilisateur.prenom" /></li>
      <li>Adresse Mail : <s:property value="utilisateur.adressemail" /></li>
      <li>Mot de passe : <s:property value="utilisateur.motdepasse" /></li>
      <li>Présentation : <s:property value="utilisateur.presentation" /></li>
      <li>Niveau : <s:property value="utilisateur.niveau" /></li>

   </ul>

   <s:a action="detail_account">
      <button class="btn btn-danger">Modifier mes informations</button>
   </s:a>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>


</body>
</html>