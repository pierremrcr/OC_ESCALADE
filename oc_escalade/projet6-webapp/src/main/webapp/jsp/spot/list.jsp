<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>
</head>
<body>

   <h2>Liste des sites consultables</h2>

   <div class="table-responsive">
      <table class="table table-hover table-border">
         <thead>
            <tr>
               <th>Nom</th>
               <th>Région</th>

            </tr>


            <s:iterator value="listeSpots">
               <tr>
                  <td><s:a action="spot_detail">
                        <s:param name="id" value="id" />
                        <s:property value="nom" />
                     </s:a></td>
                  <td><s:property value="region" />
               </tr>
            </s:iterator>

            <footer>

               <%@ include file="../_include/footer.jsp"%>

            </footer>
</body>
</html>