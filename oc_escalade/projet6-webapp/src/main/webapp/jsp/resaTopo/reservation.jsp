<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp" %>
</head>
<body>
	
    <!-- Page Content -->
	<div class="container content">
    <s:form action="topo_reservation" class="col-lg-6 col-lg-offset-3">

      <fieldset class="scheduler-border">
        <legend class="scheduler-border">Réservation</legend>
 
  <div class="form-inline">
  
  	<s:label for="dateDebut" class="espace">Date de début</s:label>
  	
	<input type="date" name="dateDebut">
	
	
   	<s:label for="dateFin" class="espace">Date de fin</s:label>
   	
	<input type="date"  name="dateFin">
		  
  </div>
  
    <s:hidden name="id" value="%{topo.id}" /> 
	<s:submit value="Réserver le topo" id="connecter" class="btn btn-primary center-block"/>
 <div>

</div>
</fieldset>
</s:form>


<!-- mettre liste réservation -->
 <s:if test="%{listeEmprunt != null}">

	<div class="col-lg-6 col-lg-offset-3">
	 <div class="text-center">
 <h3>Historique de réservations</h3>
 </div>
	<div class="table-responsive">
  		<table class="table table-hover table-border">
  		 <thead>
	      <tr>
	        <th>date début</th>
	        <th>date fin</th>
	      </tr>
   		</thead>
   		  <tbody>
		<s:iterator value="listeEmprunt">
		 <tr>
		        <td><s:property value="dateDebut"/></td>
		        <td><s:property value="dateFin"/></td>              
		 </tr>
		</s:iterator>
		<tbody>
		</table>
		</div>
		</div>
	</s:if>

    </div>
    
       <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>