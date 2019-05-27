<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@ include file="../_include/head.jsp"%>

<title>Mes réservations</title>

</head>

<body>

   <header>

      <%@ include file="../_include/header.jsp"%>

   </header>

   <h2>Mes réservations de topo</h2>

   <div class="table-responsive">
      <table class="table table-hover table-border">
         <thead>
            <tr>
               <th>date début</th>
               <th>date fin</th>
               <th>Nom du topo réservé</th>
               <th>Annuler</th>

            </tr>
         </thead>
         <tbody>
            <s:iterator value="listeBorrowedTopo">
               <tr>
                  <td><s:property value="dateDebut" /></td>
                  <td><s:property value="dateFin" /></td>
                  <td><s:a action="topo_detail">
                        <s:param name="id" value="topo_id" />
                        <s:property value="topo.nom" />
                       </s:a></td>
                  
                  <td><s:a action="delete_resa">
                        <s:param name="id" value="id" />
                        <button class="btn btn-danger">Annuler cette réservation</button>
                     </s:a></td>
               </tr>
            </s:iterator>
         <tbody>
      </table>
   </div>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>


</body>
</html>