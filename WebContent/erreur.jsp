<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<title>AutoLib - Projet</title>
<jsp:include page="inc/head.jsp"></jsp:include>
</head>
<body class="background">
	
	<jsp:include page="inc/top.jsp"></jsp:include>

    <div class="container">
    <div class="row">
    <div class="col-xs-12">
        
        <div class="page">
                
            <div class="row">
                        
                <h1>Erreur</h1>
                        
                <p>
	                L'application a retourné l'erreur suivante :
                </p>
                
                <p>
               		<em><c:out value="${erreur}" /></em>
               	</p>
            </div>
            
        </div>
    </div>
    </div>
    </div>
    
    <jsp:include page="inc/bottom.jsp"></jsp:include>

</body>
</html>