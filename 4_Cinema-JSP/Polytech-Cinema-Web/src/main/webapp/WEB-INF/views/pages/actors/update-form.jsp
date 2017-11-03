<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Update an actor</jsp:attribute>
    
    <jsp:attribute name="page_title">Update an actor</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/resources/js/actor-form.js" var="js_actor_form" />
	    <script src="${js_actor_form}"></script>
    
    		<form name="actorForm" method="post" action="/cinema/ActorController/update" onsubmit="return checkInputs()">
    			<div class="form-group">
				<label for="id">ID</label>
				<input type="number" class="form-control" id="id" name="id" value="${actor.id}" readonly>
		    </div>
			<div class="form-group">
				<label for="lastname">Last name</label>
				<input type="text" class="form-control" id="lastname" name="lastname" placeholder="Enter your last name" value="${actor.lastname}" maxlength="100">
		    </div>
		    <div class="form-group">
				<label for="firstname">First name</label>
				<input type="text" class="form-control" id="firstname" name="firstname" placeholder="Enter your first name" value="${actor.firstname}" maxlength="100">
		    </div>
		    <div class="form-group">
				<label for="birthDate">Birth date</label>
				<input type="text" class="form-control" id="birthDate" name="birthDate" placeholder="Enter your birth date (dd-MM-yyyy)"  value="<fmt:formatDate value="${actor.birthDate}" pattern="dd-MM-yyyy"/>">
		    </div>
		    <div class="form-group">
				<label for="dateOfDeath">Date of death</label>
				<input type="text" class="form-control" id="dateOfDeath" name="dateOfDeath" placeholder="Enter your date of death (dd-MM-yyyy)"  value="<fmt:formatDate value="${actor.dateOfDeath}" pattern="dd-MM-yyyy"/>">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content"></jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>