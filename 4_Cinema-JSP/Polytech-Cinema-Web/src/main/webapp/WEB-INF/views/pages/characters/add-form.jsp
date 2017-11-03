<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Add a character</jsp:attribute>
    
    <jsp:attribute name="page_title">Add a character</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/resources/js/character-form.js" var="js_character_form" />
	    <script src="${js_character_form}"></script>
    
    		<form name="characterForm" method="post" action="/cinema/CharacterController/insert" onsubmit="return checkInputs()">
			<div class="form-group">
				<label for="movieId">Movie</label>
				<select class="form-control" id="movieId" name="movieId">
					<core:forEach items="${movies}" var="movie">
						<option value="${movie.id}">${movie.title}</option>
					</core:forEach>
				</select>
		    </div>
		    <div class="form-group">
				<label for="actorId">Actor</label>
				<select class="form-control" id="actorId" name="actorId">
					<core:forEach items="${actors}" var="actor">
						<option value="${actor.id}">${actor.lastname} ${actor.firstname}</option>
					</core:forEach>
				</select>
		    </div>
		    <div class="form-group">
				<label for="name">Name</label>
				<input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" maxlength="100">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content"></jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>