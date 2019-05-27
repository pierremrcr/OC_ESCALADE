<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="../_include/head.jsp"%>
 <%@ include file="../_include/header.jsp" %>
</head>
<body>

	<div class="container content center">
	 <s:form action="update_comment" class="col-lg-6 col-lg-offset-3">
	 <s:hidden name="id" value="%{commentaire.id}"/>
	   <fieldset class="scheduler-border">
        <legend class="scheduler-border">Modification du commentaire</legend>
 
		<div class="form-group">
			<s:label for="user" class="form_control">Posté par: <s:property value="commentaire.utilisateur.nom"/></s:label>
		</div>
		
		<div class="form-group">	
			<s:label for="contenu" class="espace">Contenu :</s:label>
			<s:textfield name="contenu" class="form-control" value="%{commentaire.contenu}"/>	
		</div>
	
	<s:submit value="Sauvegarder modification" class="btn btn-primary center-block"/>
 
</fieldset>
</s:form>
	</div>
   
      <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>