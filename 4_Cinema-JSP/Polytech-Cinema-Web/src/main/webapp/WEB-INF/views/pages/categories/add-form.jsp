<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Add a category</jsp:attribute>
    
    <jsp:attribute name="page_title">Add a category</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/resources/js/category-form.js" var="js_category_form" />
	    <script src="${js_category_form}"></script>
    
    		<form name="categoryForm" method="post" action="/cinema/CategoryController/insert" onsubmit="return checkInputs()">
			<div class="form-group">
				<label for="restrictedLabel">Restricted label</label>
				<input type="text" class="form-control" id="restrictedLabel" name="restrictedLabel" placeholder="Enter your restricted label" maxlength="2">
		    </div>
		    <div class="form-group">
				<label for="fullLabel">Full label</label>
				<input type="text" class="form-control" id="fullLabel" name="fullLabel" placeholder="Enter your full label" maxlength="20">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content"></jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>