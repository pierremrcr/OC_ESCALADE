<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp"%>
    <%@ include file="../_include/header.jsp" %>
</head>
<body>

<h2>Création d'un nouveau secteur :</h2>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>

<s:form action="nouveau_secteur">


<s:select name="spotId" label="Sélectionnez le spot d'escalade"
list="listeSpot" listKey="id" listValue="nom"
emptyOption="true" requiredLabel="true"/>



<s:textfield name="secteur.nom" label="Nom du secteur" requiredLabel="true" required="true" ></s:textfield>
<s:textarea name="secteur.description" label="Description" requiredLabel="true" required="true" />


<s:submit value="OK"/>
 
</s:form>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>