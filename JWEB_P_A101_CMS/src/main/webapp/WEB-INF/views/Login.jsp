<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<title>LOGIN</title>
<link rel="icon" type="image/png" href="https://2ality.com/2011/10/logo-js/js.jpg" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body class="bg-azure-light">
	<section class="w-100 h-100vh container-fluid d-flex align-items-center">
		<form id="form-login" class="form center" action="#">
			<div class="form-title">Please Sign in</div>
			<div class="form-body">
				<div class="form-group">
					<input id="inputEmail" class="form-control h-45" name="inputEmail" type="email" placeholder="E-mail" maxlength="50">
					<span class="form-message"></span>
				</div>
				<div class="form-group">
					<input id="inputPassword" name="inputPassword" type="password" class="form-control h-45" placeholder="PassWord"
						maxlength="50">
					<span class="form-message"></span>
				</div>
				<div class="form-group">
					<div class="form-check d-flex align-items-center">
						<input type="checkbox" class="form-check-input" id="checkRememberme">
						<label class="ml-2 form-check-label" for="checkRememberme">Remember me</label>
					</div>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-block h-45">Login</button>
				</div>
				<a href="./Register">Click here to Register</a>
			</div>
		</form>
	</section>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/resources/js/Validator.js"></script>
	<!-- AJAX -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/ajax.js"></script>
	<script>
		document.addEventListener('DOMContentLoaded',
						function() {
							Validator({
								form : '#form-login',
								formGroupSelector : '.form-group',
								errorSelector : '.form-message',
								rules : [
										Validator.isRequired('#inputEmail'),
										Validator.minLength('#inputEmail', 5),
										Validator.maxLength('#inputEmail', 50),
										Validator.isEmail('#inputEmail'),
										Validator.isRequired('#inputPassword'),
										Validator
												.minLength('#inputPassword', 8),
										Validator.maxLength('#inputPassword',
												30), ],
								onSubmit : function(data) {
									if (data) {
										alert(`Đăng nhập thành công [inputEmail = ${data.inputEmail}, inputPassword = ${data.inputPassword}]`);
										window.location.href = './index.html';
									} else {
										alert("Thất bại");
									}
								}
							});
						});
	</script>
</body>
</html>