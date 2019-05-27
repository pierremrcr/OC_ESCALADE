<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp"%>
    <%@ include file="../_include/header.jsp" %>
</head>
<body>

<h2>Création d'une nouvelle voie :</h2>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>

<s:form action="nouvelle_voie">

<s:select name="secteurId" label="Sélectionnez le secteur correspondant"
list="listeSecteur" listKey="id" listValue="nom"
emptyOption="true" requiredLabel="true"/>

<s:textfield name="voie.nom" label="Nom de la voie" requiredLabel="true" required="true" ></s:textfield>
<s:textarea name="voie.description" label="Description" requiredLabel="true" required="true" />


<s:submit value="OK"/>
 
</s:form>

     <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>