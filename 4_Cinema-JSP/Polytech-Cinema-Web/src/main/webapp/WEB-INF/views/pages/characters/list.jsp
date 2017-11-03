<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - List of all registered characters</jsp:attribute>
    
    <jsp:attribute name="page_title">Registered characters</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
    		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Movie</th>
					<th>Actor</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach items="${characters}" var="character">
					<tr>
						<td><a href="/cinema/CharacterController/overview?movieId=${character.movie.id}&actorId=${character.actor.id}">${character.movie.id}-${character.actor.id}</a></td>
						<td>${character.movie.title}</td>
						<td>${character.actor.lastname} ${character.actor.firstname}</td>
						<td>
							<a class="btn btn-warning" href="/cinema/CharacterController/update-form?movieId=${character.movie.id}&actorId=${character.actor.id}" role="button"><i class="glyphicon glyphicon-pencil"></i></a>
							<a class="btn btn-danger" href="/cinema/CharacterController/delete?movieId=${character.movie.id}&actorId=${character.actor.id}" role="button"><i class="glyphicon glyphicon-remove"></i></a>
						</td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content"></jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>