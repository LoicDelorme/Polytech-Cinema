<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Update a movie</jsp:attribute>
    
    <jsp:attribute name="page_title">Update a movie</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/resources/js/movie-form.js" var="js_movie_form" />
	    <script src="${js_movie_form}"></script>
    
    		<form name="movieForm" method="post" action="/cinema/MovieController/update" onsubmit="return checkInputs()">
    			<div class="form-group">
				<label for="id">ID</label>
				<input type="number" class="form-control" id="id" name="id" value="${movie.id}" readonly>
		    </div>
		    <div class="form-group">
				<label for="title">Title</label>
				<input type="text" class="form-control" id="title" name="title" placeholder="Enter your title" value="${movie.title}" maxlength="20">
		    </div>
		    <div class="form-group">
				<label for="duration">Duration</label>
				<input type="number" class="form-control" id="duration" name="duration" placeholder="Enter your duration" value="${movie.duration}">
		    </div>
		    <div class="form-group">
				<label for="releaseDate">Release date</label>
				<input type="text" class="form-control" id="releaseDate" name="releaseDate" placeholder="Enter your release date (dd-MM-yyyy)" value="<fmt:formatDate value="${movie.releaseDate}" pattern="dd-MM-yyyy"/>">
		    </div>
		    <div class="form-group">
				<label for="budget">Budget</label>
				<input type="number" class="form-control" id="budget" name="budget" placeholder="Enter your budget" value="${movie.budget}">
		    </div>
		    <div class="form-group">
				<label for="amountOfRevenue">Amount of revenue</label>
				<input type="number" class="form-control" id="amountOfRevenue" name="amountOfRevenue" placeholder="Enter your amount of revenue" value="${movie.amountOfRevenue}">
		    </div>
		    <div class="form-group">
				<label for="directorId">Director</label>
				<select class="form-control" id="directorId" name="directorId">
					<core:forEach items="${directors}" var="director">
						<core:choose>
							<core:when test="${director.id == movie.director.id}">
								<option value="${director.id}" selected>${director.lastname} ${director.firstname}</option>
							</core:when>
							<core:otherwise>
								<option value="${director.id}">${director.lastname} ${director.firstname}</option>
							</core:otherwise>
						</core:choose>
					</core:forEach>
				</select>
		    </div>
		    <div class="form-group">
				<label for="directorId">Category</label>
				<select class="form-control" id="categoryId" name="categoryId">
					<core:forEach items="${categories}" var="category">
						<core:choose>
							<core:when test="${category.id == movie.category.id}">
								<option value="${category.id}" selected>${category.fullLabel}</option>
							</core:when>
							<core:otherwise>
								<option value="${category.id}">${category.fullLabel}</option>
							</core:otherwise>
						</core:choose>
					</core:forEach>
				</select>
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content"></jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>