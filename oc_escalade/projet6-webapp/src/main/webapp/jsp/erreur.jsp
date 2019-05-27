<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/head.jsp"%>
    <%@ include file="_include/header.jsp" %>
</head>
<body>

<h2>Une erreur s'est produite !</h2>

<s:actionerror/>

     <footer>

      <%@ include file="_include/footer.jsp"%>
      
   </footer>

</body>

</html>