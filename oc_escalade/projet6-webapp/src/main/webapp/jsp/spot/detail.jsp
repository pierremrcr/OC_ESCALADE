<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>
</head>
<body>

   <h2>Détail d'un site</h2>

   <ul>
      <li>Nom : <s:property value="spot.nom" /></li>
      <br />
      <li>Description : <s:property value="spot.description" /></li>
   </ul>

   <h2>Adresse du site</h2>

   <li>Ville : <s:property value="spot.adresse.ville" /></li>
   <br />
   <li>Code Postal : <s:property value="spot.adresse.codepostal" /></li>
   <br />
   <li>Département : <s:property value="spot.adresse.departement" /></li>
   <li>Région : <s:property value="spot.region" /></li>

   </ul>


   <h2>Secteurs voies et longueurs</h2>

   <ul>
      <s:iterator value="spot.listeSecteurs">
         <li>Nom du secteur : <s:property value="nom" /></li>
         <br />
         <li>Description du secteur : <s:property value="description" /></li>
         <br />
         <ul>



            <s:iterator value="listeVoies">


               <li>Nom de la voie : <s:property value="nom" /></li>
               </br>
               <li>Description de la voie : <s:property value="description" /></li>
               <br />

               <ul>



                  <s:iterator value="listeLongueurs">



                     <li>Nom de la longueur : <s:property value="nom" /></li>
                     <li>Nombre de points : <s:property value="nombreDePoints" /></li>
                     <li>Cotation : <s:property value="cotation" /></li>
                     <li>Hauteur de la longueur : <s:property value="hauteur" />mètres
                     </li>
                     </br>
                  </s:iterator>
               </ul>
            </s:iterator>
         </ul>
      </s:iterator>



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

            <s:iterator value="spot.listeCommentaires">
               <tr>
                  <td><s:property value="date" /></td>
                  <td><s:property value="contenu" /></td>
                  <td><s:property value="utilisateur.nom" /> <s:property value="utilisateur.prenom" /></td>
               </tr>
            </s:iterator>

         </table>
      </div>



      <s:if test="#session.user">
         <s:form action="nouveau_commentaire_site">
            <s:textarea name="commentaire.contenu" label="Votre commentaire" />
            <s:hidden name="id" value="%{id}" />
            <s:submit value="Ok" />
         </s:form>
      </s:if>


 <s:if test="%{#session.user.adresseMail =='pierremercier@fakemail.com'}">

      <s:a action="deleteSpot">
         <s:param value="spot.id" name="id" />
         <button class="btn btn-primary">Supprimer ce site</button>
      </s:a>
      
         <s:a action="detail_Spot">
         <s:param value="spot.id" name="id" />
         <button class="btn btn-primary">Modifier ce site</button>
      </s:a>
      
</s:if>

      <footer>

         <%@ include file="../_include/footer.jsp"%>

      </footer>
</body>
</html>