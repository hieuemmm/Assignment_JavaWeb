<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
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
<title>CM | Add Computer</title>
<link rel="stylesheet"
	href="/GeneralAssignmentATJBopt2/resources/css/index.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container mt-2">
		<div class="d-flex justify-content-center my-2">
			<h3>Add computer</h3>
		</div>
		<form:form id="form" class="border p-4" method="POST"
			action="/GeneralAssignmentATJBopt2/computer/saveAdd"
			modelAttribute="computer">
				<c:if test='${messageError != null}'>
					<div class="form-group">
						<div class="alert alert-danger" role="alert">
						  ${messageError}
						</div>
					</div>
				</c:if>
				
			<div class="form-group">
				<label for="inputMaMay">Mã máy</label> 
				<form:input type="text" class="form-control" id="inputMaMay" path="maMay" placeholder="Nhập mã máy..." value="${computer.maMay}"/> 
					<span class="form-message">Messeage...</span>
			</div>
			<div class="form-group">
				<label for="inputViTri">Vị trí</label> 
				<form:input type="text" class="form-control" id="inputViTri" path="viTri" placeholder="Nhập vị trí..." value="${computer.viTri}"/> 
					<span class="form-message">Messeage...</span>
			</div>
			<div class="form-group">
				<label for="inputMaMay">Trạng thái</label> <form:select
					class="custom-select" id="inputTrangThai" path="trangThai" value="${computer.trangThai}">
					<form:option value="">--Không chọn--</form:option>
					<form:option value="Dang ranh">Đang rảnh</form:option>
					<form:option value="Dang dung">Đang dùng</form:option>
					<form:option value="Dang sua chua">Đang sửa chữa</form:option>
				</form:select> 
				<span class="form-message">Messeage...</span>
			</div>
			<div class="d-flex justify-content-end w-100">
				<button type="reset" class="btn btn-outline-white border mr-auto">Clear</button>
				<button type="submit" class="btn btn-primary mr-2">Create</button>
				<a href="/GeneralAssignmentATJBopt2/customer/" class="mr-2">
					<button type="button" class="btn btn-outline-white border">Back</button>
				</a>
			</div>
		</form:form>
	</div>
	<%@ include file="../footer.jsp"%>
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
	<script src="/GeneralAssignmentATJBopt2/resources/js/Validator.js"></script>
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			Validator({
				form : '#form',
				formGroupSelector : '.form-group',
				errorSelector : '.form-message',
				rules : [ Validator.isRequired('#inputMaMay'),
						Validator.isRequired('#inputViTri'),
						Validator.isRequired('#inputTrangThai'), ],
			});
		});
	</script>
</body>
</html>