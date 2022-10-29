<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<title>CMS | Edit Profile</title>
<link rel="icon" type="image/png"
	href="https://2ality.com/2011/10/logo-js/js.jpg" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body class="bg-azure-light">
	<%@ include file="./header.jsp"%>
	<div class="row">
		<%@ include file="./navMenu.jsp"%>
		<section id="body-content">
			<h3>Add Content</h3>
            <hr>
            <form id="form-content" class="form" method="post" action="/JWEB_PA101/content">
                <div class="form-title">
                    Content Form Elements
                </div>
                <div class="form-body ">
                	<span class="server-message">${messageEror}</span>
                    <div class="form-group">
                        <label for="inputTitle">Title</label>
                        <input id="inputTitle" class="form-control h-45" name="title" type="text"
                            placeholder="Enter the title" type="text" maxlength="50">
                        <span class="form-message"></span>
                    </div>
                    <div class="form-group">
                        <label for="inputBrief">Brief</label>
                        <textarea id="inputBrief" class="form-control" name="brief" rows="2"></textarea>
                        <span class="form-message"></span>
                    </div>
                    <div class="form-group">
                        <label for="inputContent">Content</label>
                        <textarea id="inputContent" class="form-control" name="content" rows="4"></textarea>
                        <span class="form-message"></span>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn">Submit button</button>
                        <button type="reset" class="btn">Reset button</button>
                    </div>
                </div>
            </form>
		</section>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/Validator.js"></script>
	<!-- AJAX -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/ajax.js"></script>
	<script>
	document.addEventListener('DOMContentLoaded', function () {
        Validator({
            form: '#form-content',
            formGroupSelector: '.form-group',
            errorSelector: '.form-message',
            rules: [
                Validator.isRequired('#inputTitle'),
                Validator.minLength('#inputTitle', 10),
                Validator.maxLength('#inputTitle', 200),

                Validator.isRequired('#inputBrief'),
                Validator.minLength('#inputBrief', 30),
                Validator.maxLength('#inputBrief', 150),

                Validator.isRequired('#inputContent'),
                Validator.minLength('#inputContent', 50),
                Validator.maxLength('#inputContent', 1000),
            ],
        });
    });
	</script>
</body>
</html>