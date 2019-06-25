<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>
</head>

<body>

   <h2>Modification des informations de votre compte</h2>

   <div class="form-group">

      <s:form action="update_Account" class="col-lg-6 col-lg-offset-3">
       <s:hidden name="id" value="%{utilisateur.id}"/>

         <fieldset class="scheduler-border">

            <s:textfield name="Nom" class="form-control" value="%{utilisateur.nom}" label="Nom" requiredLabel="true"></s:textfield>
            <s:textfield name="Prenom" class="form-control" value="%{utilisateur.prenom}" label="Prénom" requiredLabel="true"></s:textfield>
            <s:textfield name="Email" class="form-control" value="%{utilisateur.adresseMail}" label="Email" requiredLabel="true"></s:textfield>
            <s:textfield name="MotDePasse" class="form-control" value="%{utilisateur.motDePasse}" label="Mot de passe" requiredLabel="true"
               type="password"></s:textfield>
            <s:textfield name="Presentation" class="form-control" value="%{utilisateur.presentation}" label="Présentation" requiredLabel="true"></s:textfield>
            <s:textfield name="Niveau" class="form-control" value="%{utilisateur.niveau}" label="Niveau" requiredLabel="true"></s:textfield>
            
              <s:submit value="Sauvegarder modification" class="btn btn-primary center-block" />
        
         </fieldset>

      </s:form>

   </div>


   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>






