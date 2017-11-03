<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Add a director</jsp:attribute>
    
    <jsp:attribute name="page_title">Add a director</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/resources/js/director-form.js" var="js_director_form" />
	    <script src="${js_director_form}"></script>
    
    		<form name="directorForm" method="post" action="/cinema/DirectorController/insert" onsubmit="return checkInputs()">
			<div class="form-group">
				<label for="lastname">Last name</label>
				<input type="text" class="form-control" id="lastname" name="lastname" placeholder="Enter your last name" maxlength="100">
		    </div>
		    <div class="form-group">
				<label for="firstname">First name</label>
				<input type="text" class="form-control" id="firstname" name="firstname" placeholder="Enter your first name" maxlength="100">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content"></jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>