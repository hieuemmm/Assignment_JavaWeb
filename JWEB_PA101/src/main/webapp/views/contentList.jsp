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
<title>CMS | View Content</title>
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
			<form class="form">
			    <div class="form-title">
			        View Content
			    </div>
			    <div class="form-body ">
			        <table class="table table-striped border">
			            <thead>
			                <tr>
			                    <th scope="col">#</th>
			                    <th scope="col">Title</th>
			                    <th scope="col">Brief</th>
			                    <th scope="col">Created Date</th>
			                </tr>
			            </thead>
			            <tbody>
			           	 	<c:forEach items="${contentList}" varStatus="loop" var="contents">
				                <tr>
				                    <td scope="row">${loop.count}</td>
									<td>${contents.title}</td>
									<td>${contents.brief}</td>
									<td>
										${contents.createdDate} 
										<br/> 
										${contents.updateTime}
									</td>
				                </tr>
			                </c:forEach>
			            </tbody>
			        </table>
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
		document.addEventListener('DOMContentLoaded', function() {
			Validator({
				form : '#form-edit-profile',
				formGroupSelector : '.form-group',
				errorSelector : '.form-message',
				rules : [ Validator.isRequired('#inputFirstName'),
						Validator.minLength('#inputFirstName', 3),
						Validator.maxLength('#inputFirstName', 30),

						Validator.isRequired('#inputLastName'),
						Validator.minLength('#inputLastName', 3),
						Validator.maxLength('#inputLastName', 30),

						Validator.isRequired('#inputPhone'),
						Validator.minLength('#inputPhone', 9),
						Validator.maxLength('#inputPhone', 13),

						Validator.maxLength('#inputDescription', 200), ]
			});
		});
	</script>
</body>
</html>