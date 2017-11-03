<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Features</jsp:attribute>
    
    <jsp:attribute name="page_title">Features</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
		<core:if test="${message != null}">
   			<div class="alert alert-success alert-dismissible" role="alert">
	  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  			<strong>${message}</strong>
			</div>
		</core:if>
    	
		<dl>
			<dt>Actors</dt>
			<dd><a href="/cinema/ActorController/list">List all actors</a></dd>
            	<dd><a href="/cinema/ActorController/filter-form">Filter actors</a></dd>
            	<dd><a href="/cinema/ActorController/add-form">Add a new actor</a></dd>
		</dl>
		
		<dl>
			<dt>Directors</dt>
			<dd><a href="/cinema/DirectorController/list">List all directors</a></dd>
           	<dd><a href="/cinema/DirectorController/filter-form">Filter directors</a></dd>
           	<dd><a href="/cinema/DirectorController/add-form">Add a new director</a></dd>
		</dl>
		
		<dl>
			<dt>Categories</dt>
			<dd><a href="/cinema/CategoryController/list">List all categories</a></dd>
           	<dd><a href="/cinema/CategoryController/filter-form">Filter categories</a></dd>
	     	<dd><a href="/cinema/CategoryController/add-form">Add a new category</a></dd>
		</dl>
		
		<dl>
			<dt>Movies</dt>
			<dd><a href="/cinema/MovieController/list">List all movies</a></dd>
	       	<dd><a href="/cinema/MovieController/filter-form">Filter movies</a></dd>
	     	<dd><a href="/cinema/MovieController/add-form">Add a new movie</a></dd>
		</dl>
		
		<dl>
			<dt>Characters</dt>
			<dd><a href="/cinema/CharacterController/list">List all characters</a></dd>
	      	<dd><a href="/cinema/CharacterController/add-form">Add a new character</a></dd>
		</dl>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content"></jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>