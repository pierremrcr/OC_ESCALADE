<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>
</head>
<body>
  <h2>Gestion des commentaires</h2>
  <div class="container content center">
    <div class="col-lg-8 col-lg-offset-2">
      <div class="table-responsive">
        <table class="table table-hover ">
          <thead>
            <tr>
              <th>Posté par</th>
              <th>Contenue</th>
              <th>Modifier</th>
              <th>Supprimer</th>
            </tr>
          </thead>
          <tbody>
            <s:iterator value="listeCommentaires">
              <tr>
                <td><s:property value="utilisateur.nom" /></td>
                <td><s:property value="contenu" /></td>
                <td><s:a action="detail_comment">
                    <s:param name="id" value="id" />
                    <button class="btn btn-warning">modifier</button>
                  </s:a></td>
                <td><s:a action="delete_comment">
                    <s:param name="id" value="id" />
                    <button class="btn btn-danger">supprimer</button>
                  </s:a></td>
              </tr>
            </s:iterator>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  
     <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>
</body>
</html>