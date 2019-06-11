<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>
</head>
<body>

   <h2>Détail d'un topo</h2>

   <ul>
      <li>Nom : <s:property value="topo.nom" /></li>
      <br />
      <li>Description : <s:property value="topo.description" /></li>
      <br />
      <li>Propriétaire du topo : <s:property value="topo.proprietaire.nom" /> <s:property value="topo.proprietaire.prenom" /></li>

   </ul>

   <h2>Commentaires des visiteurs</h2>

   <div class="table-responsive">
      <table class="table table-hover table-border">
         <thead>
            <tr>
               <th>Date du commentaire</th>
               <th>Contenu</th>
               <th>Publié Par</th>
            </tr>
         </thead>

         <ul>
            <s:iterator value="topo.listeCommentaires">
               <tr>
                  <td><s:property value="date" /></td>
                  </br>
                  <td><s:property value="contenu" /></td>

                  <td><s:property value="utilisateur.nom" />
                     <s:property value="utilisateur.prenom" /></td>
               </tr>
            </s:iterator>

         </ul>

         <s:if test="#session.user">
            <s:form action="nouveau_commentaire_topo">
               <s:textarea name="commentaire.contenu" label="Votre commentaire" />
               <s:hidden name="id" value="%{id}" />
               <s:submit value="Ok" />
            </s:form>
         </s:if>


         <div class="text-center">

            <s:if test="#session.user">
               <s:a action="topo_reservation">
                  <s:param value="topo.id" name="id" />
                  <button class="btn btn-primary">Réservation</button>
               </s:a>
               <s:else>
                  <h3>Vous devez être connecté pour réserver ce topo</h3>
               </s:else>
            </s:if>
         </div>


         <s:if test="%{#session.user.nom == topo.proprietaire.nom}">

            <s:a action="deleteTopo">
               <s:param value="topo.id" name="id" />
               <button class="btn btn-primary">Supprimer ce topo</button>
            </s:a>

         </s:if>

         <s:if test="%{listeEmprunt != null}">

            <div class="col-lg-6 col-lg-offset-3">
               <div class="text-center">

                  <h3>Liste des réservations</h3>
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
                              <td><s:property value="dateDebut" /></td>
                              <td><s:property value="dateFin" /></td>
                           </tr>
                        </s:iterator>
                     <tbody>
                  </table>
               </div>
            </div>

         </s:if>

         <footer>

            <%@ include file="../_include/footer.jsp"%>

         </footer>
</body>
</html>