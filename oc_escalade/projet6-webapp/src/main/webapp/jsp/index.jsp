<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<html>


<head>

<%@ include file="_include/head.jsp"%>

</head>


<body>

   <header>

      <%@ include file="_include/header.jsp"%>

   </header>

   <s:if test="!#session.user">

      <body>

         <div class="container-fluid">

            <div class="jumbotron">
               <h1 class="display-4">Escalade.com</h1>
               <p class="lead">Bienvenue sur escalade.com, le site communautaire dédié à la pratique de la grimpe !</p>
               <hr class="my-4">


               <p>Pour commencer, connectez-vous pour un accès étendu au site.</p>
               <p class="lead">
                  <a class="btn btn-primary btn-lg" href="login.action" role="button">Connectez-vous</a> <a class="btn btn-primary btn-lg"
                     href="nouvel_utilisateur.action" role="button">Nouveau compte</a>

               </p>



            </div>
      </body>

   </s:if>

   <s:else>
   
    <div class="container-fluid">

      <img class=img-responsive alt="Escalade" src="images/escalade.jpg">
      
   </div>

   </s:else>


   <footer>

      <%@ include file="_include/footer.jsp"%>

   </footer>

</body>


</html>






