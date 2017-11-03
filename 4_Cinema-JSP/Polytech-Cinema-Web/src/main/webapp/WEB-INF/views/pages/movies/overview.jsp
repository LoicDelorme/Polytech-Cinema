<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Movie overview</jsp:attribute>
    
    <jsp:attribute name="page_title">Movie overview</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
    		<form>
			<div class="form-group">
				<label for="id">ID</label>
				<input type="number" class="form-control" id="id" name="id" value="${movie.id}" readonly>
		    </div>
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" class="form-control" id="title" name="title" value="${movie.title}" readonly>
		    </div>
		    <div class="form-group">
				<label for="duration">Duration</label>
				<input type="number" class="form-control" id="duration" name="duration" value="${movie.duration}" readonly>
		    </div>
		    <div class="form-group">
				<label for="releaseDate">Release date</label>
				<input type="text" class="form-control" id="releaseDate" name="releaseDate" value="<fmt:formatDate value="${movie.releaseDate}" pattern="dd-MM-yyyy"/>" readonly>
		    </div>
		    <div class="form-group">
				<label for="budget">Budget</label>
				<input type="number" class="form-control" id="budget" name="budget" value="${movie.budget}" readonly>
		    </div>
		    <div class="form-group">
				<label for="amountOfRevenue">Amount of revenue</label>
				<input type="number" class="form-control" id="amountOfRevenue" name="amountOfRevenue" value="${movie.amountOfRevenue}" readonly>
		    </div>
		    <div class="form-group">
				<label for="director">Director</label>
				<input type="text" class="form-control" id="director" name="director" value="${movie.director.lastname} ${movie.director.firstname}" readonly>
		    </div>
		    <div class="form-group">
				<label for="category">Category</label>
				<input type="text" class="form-control" id="category" name="category" value="${movie.category.fullLabel}" readonly>
		    </div>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content">
    		<div class="row">
            <div class="col-lg-12">
            		<h1 class="page-header">Actors</h1>
            </div>
	    </div>
    		
    		<div class="row">
            <div class="col-lg-12">
            		<table class="table table-striped">
					<thead>
						<tr>
							<th>Last name</th>
							<th>First name</th>
						</tr>
					</thead>
					<tbody>
						<core:forEach items="${movie.actors}" var="actor">
							<tr>
								<td>${actor.lastname}</td>
								<td>${actor.firstname}</td>
							</tr>
						</core:forEach>
					</tbody>
				</table>
            </div>
	    </div>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>