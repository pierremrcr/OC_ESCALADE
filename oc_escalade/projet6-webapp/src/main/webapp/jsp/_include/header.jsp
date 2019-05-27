<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
   <a class="navbar-brand" href="index">ESCALADE</a>
   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02"
      aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
   </button>

   <div class="collapse navbar-collapse" id="navbarColor02">
      <ul class="navbar-nav mr-auto">

         <s:if test="!#session.user">
            <li class="nav-item"><a class="nav-link" href="spot_list">Liste des sites</a></li>
            <li class="nav-item"><a class="nav-link" href="topo_list">Liste des topos</a></li>
            <li class="nav-item"><a class="nav-link" href="rechercheMultiCritere">Recherchez un site</a></li>
            <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
               aria-expanded="false">Mon compte</a>
               <div class="dropdown-menu" x-placement="bottom-start"
                  style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 40px, 0px);">
                  <a class="dropdown-item" href="login">Connexion</a>
               </div></li>
         </s:if>

         <s:if test="%{#session.user.adresseMail =='pierremercier@fakemail.com'}">
            <li class="nav-item"><a class="nav-link" href="spot_list">Liste des sites</a></li>
            <li class="nav-item"><a class="nav-link" href="topo_list">Liste des topos</a></li>
            <li class="nav-item"><a class="nav-link" href="nouveau_topo">Créer un nouveau topo</a></li>
            <li class="nav-item"><a class="nav-link" href="nouveau_spot">Créer un nouveau site</a></li>
            <li class="nav-item"><a class="nav-link" href="rechercheMultiCritere">Recherchez un site</a></li>
            <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
               aria-expanded="false">Administration</a>
               <div class="dropdown-menu" x-placement="bottom-start"
                  style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 40px, 0px);">
                  <a class="dropdown-item" href="spot_gestion">Gestion Spot</a> 
                  <a class="dropdown-item" href="topo_gestion">Gestion Topo</a> 
                  <a class="dropdown-item" href="utilisateur_gestion">Gestion Utilisateur</a> 
                  <a class="dropdown-item" href="gestion_comment">Gestion Commentaire</a> 
                  <a class="dropdown-item" href="logout">Déconnexion</a>
               </div></li>
         </s:if>

         <s:if test="%{#session.user.adresseMail !='pierremercier@fakemail.com'}">
            <li class="nav-item"><a class="nav-link" href="spot_list">Liste des sites</a></li>
            <li class="nav-item"><a class="nav-link" href="topo_list">Liste des topos</a></li>
            <li class="nav-item"><a class="nav-link" href="nouveau_topo">Créer un nouveau topo</a></li>
            <li class="nav-item"><a class="nav-link" href="nouveau_spot">Créer un nouveau site</a></li>
            <li class="nav-item"><a class="nav-link" href="rechercheMultiCritere">Recherchez un site</a></li>
            <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
               aria-expanded="false">Mon compte</a>
               <div class="dropdown-menu" x-placement="bottom-start"
                  style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 40px, 0px);">
                  <a class="dropdown-item" href="ResaTopo">Mes réservations</a> 
                  <a class="dropdown-item" href="logout">Déconnexion</a> 
                  <a class="dropdown-item" href="deleteAccount">Supprimer le compte</a> 
                  <a class="dropdown-item" href="utilisateur_detail">Modifier mes informations</a>
               </div></li>
         </s:if>

      </ul>
   </div>
</nav>
