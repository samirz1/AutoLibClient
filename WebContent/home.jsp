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
                        
                <h1>AutoLib - version <c:out value="${app_version}" /></h1>
                <h2>Tous vos déplacements en ville</h2>
                
                Bonjour.<br />        
                <c:out value="${message}"></c:out><br />
                Cliquez pour entrer.<br />
                <br />
                <a href="./controleurStation?action=plan" id="go"><img src="img/entrance.png" alt="Entrer" /></a>
                
                <form action="home" name="logout" role="form" class="form-horizontal" method="post" accept-charset="utf-8">
					<input type="hidden" name="action" value="logout" />
					<input class="btn btn-success btn btn-warning" type="submit" value="Déconnexion" />
                </form>
                
            </div>
            </div>
            
        </div>
    </div>
    </div>
    </div>
    
    <c:if test="${autoredirect}">
	    <script type="text/javascript">
		$(document).ready(function() {
			setTimeout(function() {
				document.location.replace($('a#go').attr('href'));
			}, 2000);
		});
	    </script>
    </c:if>

</body>
</html>