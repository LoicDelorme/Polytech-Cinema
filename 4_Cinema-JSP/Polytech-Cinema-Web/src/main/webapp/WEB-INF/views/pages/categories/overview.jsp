<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Category overview</jsp:attribute>
    
    <jsp:attribute name="page_title">Category overview</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
    		<form>
			<div class="form-group">
				<label for="id">ID</label>
				<input type="number" class="form-control" id="id" name="id" value="${category.id}" readonly>
		    </div>
			<div class="form-group">
				<label for="restrictedLabel">Restricted label</label>
				<input type="text" class="form-control" id="restrictedLabel" name="restrictedLabel" value="${category.restrictedLabel}" readonly>
		    </div>
		    <div class="form-group">
				<label for="fullLabel">Full label</label>
				<input type="text" class="form-control" id="fullLabel" name="fullLabel" value="${category.fullLabel}" readonly>
		    </div>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content">
    		<div class="row">
            <div class="col-lg-12">
            		<h1 class="page-header">Movies</h1>
            </div>
	    </div>
    		
    		<div class="row">
            <div class="col-lg-12">
            		<table class="table table-striped">
					<thead>
						<tr>
							<th>Title</th>
							<th>Duration</th>
						</tr>
					</thead>
					<tbody>
						<core:forEach items="${category.movies}" var="movie">
							<tr>
								<td>${movie.title}</td>
								<td>${movie.duration}</td>
							</tr>
						</core:forEach>
					</tbody>
				</table>
            </div>
	    </div>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>