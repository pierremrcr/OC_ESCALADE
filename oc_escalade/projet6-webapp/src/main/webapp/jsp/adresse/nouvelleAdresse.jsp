<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp"%>
    <%@ include file="../_include/header.jsp" %>
</head>
<body>

<h2>Création d'un nouveau spot :</h2>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>

<s:form action="nouvelle_adresse">

<s:textfield name="adresse.rue" label="Nom de la rue" requiredLabel="false" ></s:textfield>
<s:textfield name="adresse.numero" label="Numéro de rue" requiredLabel="false" ></s:textfield>
<s:textfield name="adresse.ville" label="Ville" requiredLabel="true" ></s:textfield>
<s:textfield name="adresse.codePostal" label="Code Postal" requiredLabel="true" ></s:textfield>
<s:textfield name="adresse.departement" label="Département" requiredLabel="true" ></s:textfield>


<s:submit value="OK"/>

 
</s:form>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>