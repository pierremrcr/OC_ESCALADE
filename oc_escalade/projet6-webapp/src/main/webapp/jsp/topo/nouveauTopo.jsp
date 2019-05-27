<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp"%>

</head>

<body>

	<header>

		<%@ include file="../_include/header.jsp"%>

</header>

<h2>Création d'un nouveau topo :</h2>

<s:form action="nouveau_topo">

<s:textfield name="topo.nom" label="Nom du topo" requiredLabel="true" required="true" ></s:textfield>
<s:textfield name="topo.description" label="Description" requiredLabel="true" required="true" ></s:textfield>

<s:submit value="OK"/>
 
</s:form>

 <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>