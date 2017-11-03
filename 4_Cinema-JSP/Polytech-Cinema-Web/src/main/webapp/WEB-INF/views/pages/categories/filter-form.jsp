<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Filter categories</jsp:attribute>
    
    <jsp:attribute name="page_title">Filter categories</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
    		<form name="categoryForm" method="post" action="/cinema/CategoryController/filter">
			<div class="form-group">
				<label for="restrictedLabel">Restricted label</label>
				<input type="text" class="form-control" id="restrictedLabel" name="restrictedLabel" placeholder="Enter your restricted label" maxlength="2">
		    </div>
		    <div class="form-group">
				<label for="fullLabel">Full label</label>
				<input type="text" class="form-control" id="fullLabel" name="fullLabel" placeholder="Enter your full label" maxlength="20">
		    </div>
		    <button type="submit" class="btn btn-primary">Search</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="additional_content"></jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>