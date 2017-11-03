<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - List of all registered directors</jsp:attribute>
    
    <jsp:attribute name="page_title">Registered directors</jsp:attribute>
    
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
				<core:forEach items="${directors}" var="director">
					<tr>
						<td><a href="/cinema/DirectorController/overview?id=${director.id}">${director.id}</a></td>
						<td>${director.lastname}</td>
						<td>${director.firstname}</td>
						<td>
							<a class="btn btn-warning" href="/cinema/DirectorController/update-form?id=${director.id}" role="button"><i class="glyphicon glyphicon-pencil"></i></a>
							<a class="btn btn-danger" href="/cinema/DirectorController/delete?id=${director.id}" role="button"><i class="glyphicon glyphicon-remove"></i></a>
						</td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content"></jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>