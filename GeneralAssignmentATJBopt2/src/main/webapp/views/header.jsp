<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="/GeneralAssignmentATJBopt2/"><strong><span style="color: rgb(0,152,218);font-size:27px;line-height:20px">Computer</span><span style="color: rgb(245,134,52)">Manager</span></strong></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item"><a class="nav-link" href="/GeneralAssignmentATJBopt2/computer">Computer</a></li>
			<li class="nav-item"><a class="nav-link" href="/GeneralAssignmentATJBopt2/customer">Customer</a></li>
			<li class="nav-item"><a class="nav-link" href="/GeneralAssignmentATJBopt2/service">Service</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search....">
		</form>
		<button type="button" class="btn btn-success btn-search">Sign in</button>
	</div>
</nav>