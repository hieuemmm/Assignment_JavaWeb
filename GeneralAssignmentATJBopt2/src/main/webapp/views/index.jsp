<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
<title>CM | Home</title>
<link rel="stylesheet" href="/GeneralAssignmentATJBopt2/resources/css/index.css">
</head>
<body>
	<%@ include file="./header.jsp"%>
	<div class="container-fuild" >
		<div class="row d-flex justify-content-center w-100  mt-4">
			<div class="col-5 border-right">
				<div class="d-flex flex-column align-items-center mt-2 px-2">
					<h3 class="text-left w-100 ml-4">Regiter menu:</h3>
					<div class="list-group mt-3 w-100">
						<a href="/GeneralAssignmentATJBopt2/useService/add" class="list-group-item list-group-item-action">
							<span>[REGITER] </span>⇒ <strong>To use the service</strong>
						</a> 
						<a href="/GeneralAssignmentATJBopt2/useComputer/add" class="list-group-item list-group-item-action">
							<span>[REGITER] </span>⇒ <strong>To use the computer</strong>
						</a> 
					</div>
				</div>
				<div class="d-flex flex-column align-items-center mt-2  px-2">
					<h3 class="text-left w-100 ml-4">History menu:</h3>
					<div class="list-group mt-3 w-100">
						
						<a href="/GeneralAssignmentATJBopt2/useService"class="list-group-item list-group-item-action">
							<span>[GO TO] </span>⇒ <strong>Service registration history</strong>
						</a>
						<a href="/GeneralAssignmentATJBopt2/useComputer"class="list-group-item list-group-item-action">
							<span>[GO TO] </span>⇒ <strong>Computer registration history</strong>
						</a>	
					</div>
				</div>
				<div class="d-flex flex-column align-items-center mt-4 px-2">
					<div class="list-group mt-3 w-100">
						<a href="/GeneralAssignmentATJBopt2/allDetail/" class="alert alert-success text-decoration-none"
							aria-current="true">Manager goodest than</a>
					</div>
				</div>
			</div>
			<div class="col-6 mt-2">
				<img src="https://synnexfpt.com/wp-content/uploads/2022/07/FPT-Services-Banner-2.jpg" style="max-width:100%; height: 413px; object-fit:cover; border-radius:10px;box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;"/>
			</div>
		</div>
	</div>
	<%@ include file="./footer.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
		integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
		crossorigin="anonymous"></script>
</body>
</html>