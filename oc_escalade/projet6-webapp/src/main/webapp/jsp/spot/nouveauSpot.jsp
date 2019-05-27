<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp"%>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

<h2>Création d'un nouveau site :</h2>

	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>

	<s:form action="nouveau_spot">

<s:textfield name="spot.nom" label="Nom du spot" requiredLabel="true" ></s:textfield>
<s:textfield name="spot.description" label="Description" requiredLabel="true" ></s:textfield>
<s:textfield name="spot.adresse.rue" label="Rue" requiredLabel="false" ></s:textfield>
<s:textfield name="spot.adresse.numero" label="Numéro de rue" requiredLabel="false" ></s:textfield>
<s:textfield name="spot.adresse.ville" label="Ville" requiredLabel="true" ></s:textfield>
<s:textfield name="spot.adresse.codePostal" label="Code Postal" requiredLabel="true" ></s:textfield>
<s:textfield name="spot.adresse.departement" label="Département" requiredLabel="true" ></s:textfield>
<s:textfield name="spot.region" label="Région" requiredLabel="true" ></s:textfield>


<s:submit value="OK"/>


 
</s:form>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>