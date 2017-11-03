<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - List of all registered actors</jsp:attribute>
    
    <jsp:attribute name="page_title">Registered actors</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
    		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach items="${actors}" var="actor">
					<tr>
						<td><a href="/cinema/ActorController/overview?id=${actor.id}">${actor.id}</a></td>
						<td>${actor.lastname}</td>
						<td>${actor.firstname}</td>
						<td>
							<a class="btn btn-warning" href="/cinema/ActorController/update-form?id=${actor.id}" role="button"><i class="glyphicon glyphicon-pencil"></i></a>
							<a class="btn btn-danger" href="/cinema/ActorController/delete?id=${actor.id}" role="button"><i class="glyphicon glyphicon-remove"></i></a>
						</td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content"></jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>