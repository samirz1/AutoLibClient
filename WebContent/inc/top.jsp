<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="./home"><img src="img/logo_top.png" alt="AutoLib" border="0" /></a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
          
            <li <c:if test="${url == 'home'}">class="active"</c:if>><a href="./home">Accueil</a></li>
            <li <c:if test="${url == 'animation'}">class="active"</c:if>><a href="./animation">Animation</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>