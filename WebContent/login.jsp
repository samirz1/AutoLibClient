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
                <form action="home" name="login" role="form" class="form-horizontal" method="post" accept-charset="utf-8">
                    <div class="form-group">
                    <div class="col-md-8"><input name="login" placeholder="Idenfiant" class="form-control" type="text" id="UserUsername"/></div>
                    </div>
                    
                    <div class="form-group">
                    <div class="col-md-8"><input name="password" placeholder="Mot de passe" class="form-control" type="password" id="UserPassword"/></div>
                    </div>
                    
                    <div class="form-group">
                    <div class="col-md-offset-0 col-md-8"><input class="btn btn-success btn btn-success" type="submit" value="Connexion"/></div>
                    </div>
                    
                    <input type="hidden" name="action" value="login" />
                
                </form>
                <p class="credits">Projet Polytech AutoLib WebServices - &copy; 2015.</p>
            </div>
            </div>
            
        </div>
    </div>
    </div>
    </div>

</body>
</html>