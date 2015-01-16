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
<body>

    <div class="container">
    <div class="row">
    <div class="col-xs-12">
        
        <div class="main">
                
            <div class="row">
            <div class="col-xs-12 col-sm-6 col-sm-offset-1">
                        
                <h1>AutoLib</h1>
                <h2>Tous vos déplacements en ville</h2>
                        
                <c:out value="${message}"></c:out>
                
                <form action="home" name="logout" role="form" class="form-horizontal" method="post" accept-charset="utf-8">
					<input type="hidden" name="action" value="logout" />
					<input class="btn btn-success btn btn-success" type="submit" value="Déonnexion" />
                </form>
                
            </div>
            </div>
            
        </div>
    </div>
    </div>
    </div>

</body>
</html>