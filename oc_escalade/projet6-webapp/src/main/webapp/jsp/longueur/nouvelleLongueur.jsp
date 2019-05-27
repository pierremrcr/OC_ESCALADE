<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp"%>
    <%@ include file="../_include/header.jsp" %>
</head>
<body>

<h2>Création d'une nouvelle longueur :</h2>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>

<s:form action="nouvelle_longueur">

<s:select name="voieId" label="Sélectionnez la voie correspondante"
list="listeVoie" listKey="id" listValue="nom"
emptyOption="true" requiredLabel="true"/>

<s:textfield name="longueur.nom" label="Nom de la longueur" requiredLabel="true" ></s:textfield>
<s:textfield name="longueur.nombreDePoints" label="Nombre de points" requiredLabel="true" ></s:textfield>
<s:textfield name="longueur.cotation" label="Cotation" requiredLabel="true" ></s:textfield>
<s:textfield name="longueur.hauteur" label="Hauteur" requiredLabel="true" ></s:textfield>

<s:submit value="OK"/>
 
</s:form>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>