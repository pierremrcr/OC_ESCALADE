<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<head>

<%@ include file="../_include/head.jsp"%>

</head>


<header>

	<%@ include file="../_include/header.jsp"%>

</header>

<div class="container">

    <h2><s:actionmessage/></h2>

    <div class="row">
        <div class="col-md-12" style="margin-top: 10px; margin-bottom: 10px; text-align: center">
            <h2>Résultat de votre recherche</h2>
            <hr width="100%" color="#DCDCDC">
        </div>
    </div>
    
    <div class="container">
    <s:if test="%{!listeSpot.isEmpty()}">
        <h3 style="text-align: center">Site(s)</h3>
        <s:iterator value="listeSpot">
            <div class="row">
                <div class="col-md-9">
                    <h6>Nom : <s:property value="nom"/></h6>
                </div>
                <div class="col-md-3 align-self-center">
                    <s:a  action="spot_detail" class="btn btn-outline-info" role="button">
                        <s:param name="id" value="id"/>
                        Voir détail du site
                    </s:a>
                </div>
            </div>
        </s:iterator>
    </s:if>
</div>

</div>

   <footer>

      <%@ include file="../_include/footer.jsp"%>

   </footer>
