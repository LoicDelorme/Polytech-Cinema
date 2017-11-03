<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Character overview</jsp:attribute>
    
    <jsp:attribute name="page_title">Character overview</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
    		<form>
			<div class="form-group">
				<label for="movie">Movie</label>
				<input type="text" class="form-control" id="movie" name="movie" value="${character.movie.title}" readonly>
		    </div>
			<div class="form-group">
				<label for="actor">Actor</label>
				<input type="text" class="form-control" id="actor" name="actor" value="${character.actor.lastname} ${character.actor.firstname}" readonly>
		    </div>
		    <div class="form-group">
				<label for="name">Name</label>
				<input type="text" class="form-control" id="name" name="name" value="${character.name}" readonly>
		    </div>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content"></jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>