<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>
</head>

<body>

   <h2>Modification des informations du topo</h2>

   <div class="form-group">

      <s:form action="updateTopo" class="col-lg-6 col-lg-offset-3">
      
         <s:hidden name="id" value="%{topo.id}" />

         <fieldset class="scheduler-border">

            <s:textfield name="Nom" class="form-control" value="%{topo.nom}" label="Nom" requiredLabel="true"></s:textfield>
            <s:textfield name="Description" class="form-control" value="%{topo.description}" label="Description" requiredLabel="true"></s:textfield>
            
            
            <s:submit value="Sauvegarder modification" class="btn btn-primary center-block" />

         </fieldset>

      </s:form>

   </div>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>