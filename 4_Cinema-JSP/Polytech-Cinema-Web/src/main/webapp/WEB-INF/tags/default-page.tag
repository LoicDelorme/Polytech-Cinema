<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ tag description="Default Cinema Page" pageEncoding="UTF-8"%>

<%@attribute name="title"%>
<%@attribute name="page_title"%>
<%@attribute name="header_content" fragment="true" %>
<%@attribute name="body_content" fragment="true" %>
<%@attribute name="additional_content" fragment="true" %>
<%@attribute name="footer_content" fragment="true" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Cinema Project">
    <meta name="author" content="Loïc DELORME">
    
    <title>${title}</title>
    
    <core:url value="/resources/bootstrap/css/bootstrap.min.css" var="css_bootstrap" />
    <core:url value="/resources/metisMenu/metisMenu.min.css" var="css_metisMenu" />
    <core:url value="/resources/font-awesome/css/font-awesome.min.css" var="css_font_awesome" />
    <core:url value="/resources/sb-admin-2/css/sb-admin-2.css" var="css_sb_admin_2" />
    
    <link href="${css_bootstrap}" rel="stylesheet" />
    <link href="${css_metisMenu}" rel="stylesheet" />
    <link href="${css_font_awesome}" rel="stylesheet" />
    <link href="${css_sb_admin_2}" rel="stylesheet" />
    
    <jsp:invoke fragment="header_content"/>
</head>

<body>
    <div id="wrapper">
	    	<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	        <div class="navbar-header">
	            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	                <span class="sr-only">Toggle navigation</span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	            </button>
	            <a class="navbar-brand" href="/cinema/index">Polytech Lyon</a>
	        </div>
	        
	        <ul class="nav navbar-top-links navbar-right">
	            <li class="dropdown">
	                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
	                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
	                </a>
	                <ul class="dropdown-menu dropdown-user">
	                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a></li>
	                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a></li>
	                    <li class="divider"></li>
	                    <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
	                </ul>
	            </li>
	        </ul>
	        
	        <div class="navbar-default sidebar" role="navigation">
	            <div class="sidebar-nav navbar-collapse">
	                <ul class="nav" id="side-menu">
	                    <li>
	                    		<a href="/cinema/index"><i class="glyphicon glyphicon-list-alt"></i> Features</a>
	                    </li>
	                    <li>
	                        <a href="#"><i class="glyphicon glyphicon-user"></i> Actors<span class="fa arrow"></span></a>
	                        <ul class="nav nav-second-level">
	                            <li><a href="/cinema/ActorController/list">List all actors</a></li>
	                            <li><a href="/cinema/ActorController/filter-form">Filter actors</a></li>
	                            <li><a href="/cinema/ActorController/add-form">Add a new actor</a></li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="#"><i class="glyphicon glyphicon-user"></i> Directors<span class="fa arrow"></span></a>
	                        <ul class="nav nav-second-level">
	                            <li><a href="/cinema/DirectorController/list">List all directors</a></li>
	                            <li><a href="/cinema/DirectorController/filter-form">Filter directors</a></li>
	                            <li><a href="/cinema/DirectorController/add-form">Add a new director</a></li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="#"><i class="glyphicon glyphicon-tags"></i> Categories<span class="fa arrow"></span></a>
	                        <ul class="nav nav-second-level">
	                            <li><a href="/cinema/CategoryController/list">List all categories</a></li>
	                            <li><a href="/cinema/CategoryController/filter-form">Filter categories</a></li>
	                            <li><a href="/cinema/CategoryController/add-form">Add a new category</a></li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="#"><i class="glyphicon glyphicon-film"></i> Movies<span class="fa arrow"></span></a>
	                        <ul class="nav nav-second-level">
	                            <li><a href="/cinema/MovieController/list">List all movies</a></li>
	                            <li><a href="/cinema/MovieController/filter-form">Filter movies</a></li>
	                            <li><a href="/cinema/MovieController/add-form">Add a new movie</a></li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="#"><i class="glyphicon glyphicon-user"></i> Characters<span class="fa arrow"></span></a>
	                        <ul class="nav nav-second-level">
	                            <li><a href="/cinema/CharacterController/list">List all characters</a></li>
	                            <li><a href="/cinema/CharacterController/add-form">Add a new character</a></li>
	                        </ul>
	                    </li>
	                </ul>
	            </div>
	        </div>
	    </nav>
        
    		<div id="page-wrapper">
	        <div class="row">
	            <div class="col-lg-12">
	                <h1 class="page-header">${page_title}</h1>
	            </div>
	        </div>
	        
	        <div class="row">
	            <div class="col-lg-12">
	            	<jsp:invoke fragment="body_content"/>
	            </div>
	        </div>
	        
	        <jsp:invoke fragment="additional_content"/>
	    </div>
	</div>
	
	<jsp:invoke fragment="footer_content"/>
    
    <core:url value="/resources/jquery/jquery.min.js" var="js_jquery" />
    <core:url value="/resources/bootstrap/js/bootstrap.min.js" var="js_bootstrap" />
    <core:url value="/resources/metisMenu/metisMenu.min.js" var="js_metisMenu" />
    <core:url value="/resources/sb-admin-2/js/sb-admin-2.min.js" var="js_sb_admin_2" />
    
    <script src="${js_jquery}"></script>
    <script src="${js_bootstrap}"></script>
    <script src="${js_metisMenu}"></script>
    <script src="${js_sb_admin_2}"></script>
</body>

</html>