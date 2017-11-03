<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Actor overview</jsp:attribute>
    
    <jsp:attribute name="page_title">Actor overview</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
    		<form>
			<div class="form-group">
				<label for="id">ID</label>
				<input type="number" class="form-control" id="id" name="id" value="${actor.id}" readonly>
		    </div>
			<div class="form-group">
				<label for="lastname">Last name</label>
				<input type="text" class="form-control" id="lastname" name="lastname" value="${actor.lastname}" readonly>
		    </div>
		    <div class="form-group">
				<label for="firstname">First name</label>
				<input type="text" class="form-control" id="firstname" name="firstname" value="${actor.firstname}" readonly>
		    </div>
		    <div class="form-group">
				<label for="birthDate">Birth date</label>
				<input type="text" class="form-control" id="birthDate" name="birthDate" value="<fmt:formatDate value="${actor.birthDate}" pattern="dd-MM-yyyy"/>" readonly>
		    </div>
		    <div class="form-group">
				<label for="dateOfDeath">Date of death</label>
				<input type="text" class="form-control" id="dateOfDeath" name="dateOfDeath" value="<fmt:formatDate value="${actor.dateOfDeath}" pattern="dd-MM-yyyy"/>" readonly>
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
						<core:forEach items="${actor.movies}" var="movie">
							<tr>
								<td>${movie.title}</td>
								<td>${movie.duration}</td>
							</tr>
						</core:forEach>
					</tbody>
				</table>
            </div>
	    </div>
		
		<div class="row">
            <div class="col-lg-12">
            		<h1 class="page-header">Characters</h1>
            </div>
	    </div>
	    
	    <div class="row">
            <div class="col-lg-12">
            		<table class="table table-striped">
					<thead>
						<tr>
							<th>Movie</th>
							<th>Name</th>
						</tr>
					</thead>
					<tbody>
						<core:forEach items="${actor.characters}" var="character">
							<tr>
								<td>${character.movie.title}</td>
								<td>${character.name}</td>
							</tr>
						</core:forEach>
					</tbody>
				</table>
            </div>
	    </div>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>