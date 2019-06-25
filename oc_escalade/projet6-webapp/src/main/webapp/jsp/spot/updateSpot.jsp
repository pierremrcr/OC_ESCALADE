<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>
</head>

<body>

   <h2>Modification des informations du site</h2>

   <div class="form-group">

      <s:form action="updateSpot" class="col-lg-6 col-lg-offset-3">

         <s:hidden name="id" value="%{spot.id}" />

         <fieldset class="scheduler-border">

            <s:textfield name="Nom" class="form-control" value="%{spot.nom}" label="Nom" requiredLabel="true"></s:textfield>
            <s:textfield name="Description" class="form-control" value="%{spot.description}" label="Description" requiredLabel="true"></s:textfield>
            <s:textfield name="Rue" class="form-control"  value="%{spot.adresse.rue}" label="Rue" requiredLabel="false"></s:textfield>
            <s:textfield name="Numero" class="form-control"  value="%{spot.adresse.numero}" label="Numero" requiredLabel="false"></s:textfield>
            <s:textfield name="Ville" class="form-control"  value="%{spot.adresse.ville}" label="Ville" requiredLabel="false"></s:textfield>
            <s:textfield name="Code Postal" class="form-control"  value="%{spot.adresse.codePostal}" label="Code Postal" requiredLabel="true"></s:textfield>
            <s:textfield name="Département" class="form-control"  value="%{spot.adresse.departement}" label="Département" requiredLabel="true"></s:textfield>
           
            <s:submit value="Sauvegarder modification" class="btn btn-primary center-block" />

         </fieldset>

      </s:form>

   </div>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>