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

<h2>Liste des topos</h2>

<ul>
<s:iterator value="listeTopo">
<li>
 <s:a action="topo_detail">
<s:param name="id" value="id" />
<s:property value="nom" />
  </s:a>

</li>
</s:iterator>
</ul>

 <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>

</body>
</html>