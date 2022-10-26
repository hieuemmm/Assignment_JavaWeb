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
<title>CM | Register to use the service</title>
<link rel="stylesheet" href="/GeneralAssignmentATJBopt2/resources/css/index.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container mt-2">
		<div class="d-flex justify-content-center my-2">
			<h3>Register to use the service</h3>
		</div>
		<form:form id="form" class="border p-4" method="POST"
			action="/GeneralAssignmentATJBopt2/useService/saveAdd"
			modelAttribute="useService">
			<c:if test='${messageError != null}'>
				<div class="form-group">
					<div class="alert alert-danger" role="alert">
					  ${messageError}
					</div>
				</div>
			</c:if>
				
			<div class="form-group">
				<label for="maKH">Mã khách hàng</label>  
				<form:select class="custom-select" id="maKH" path="maKH" value="${useService.maKH}">
					<form:option value="">--Không chọn--</form:option>
					<c:forEach items="${customers}" var="customer">
						<form:option value="${customer.maKH}">${customer.maKH}</form:option>
					</c:forEach>
				</form:select> 
				<span class="form-message">Messeage...</span>
			</div>
			<div class="form-group">
				<label for="maDV">Mã dịch vụ</label> 
				<form:select class="custom-select" id="maDV" path="maDV" value="${useService.maDV}">
					<form:option value="">--Không chọn--</form:option>
					<c:forEach items="${services}" var="service">
						<form:option value="${service.maDV}">${service.maDV}</form:option>
					</c:forEach>
				</form:select> 
				<span class="form-message">Messeage...</span>
			</div>
			<div class="form-group">
				<label for="ngaySuDung">Ngày sử dụng</label> 
				<form:input type="date" class="form-control" id="ngaySuDung" path="ngaySuDung" value="${useService.ngaySuDung}"/> 
				<span class="form-message">Messeage...</span>
			</div>
			<div class="form-group">
				<label for="gioSuDung">Thời gian sử dụng</label> 
				<form:input type="time" class="form-control without_ampm" id="gioSuDung" path="gioSuDung" value="${useService.gioSuDung}"/> 
				<span class="form-message">Messeage...</span>
			</div>
			<div class="form-group">
				<label for="soLuong">Số lượng</label> 
				<form:input type="number" class="form-control" id="soLuong" path="soLuong" placeholder="Nhập số lượng..." value="${useService.soLuong}"/> 
				<span class="form-message">Messeage...</span>
			</div>
			<div class="d-flex justify-content-end w-100">
				<button type="reset" class="btn btn-outline-white border mr-auto">Clear</button>
				<button type="submit" class="btn btn-primary mr-2">Create</button>
				<a href="/GeneralAssignmentATJBopt2/useService/" class="mr-2">
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
			var currentDate = new Date().toISOString().split("T")[0];
			var currentTime = new Date().toISOString().substring(11,16);
			document.getElementById("ngaySuDung").value = currentDate;
			document.getElementById("ngaySuDung").setAttribute("max",currentDate);
			document.getElementById("gioSuDung").value = currentTime;
			
			Validator({
				form : '#form',
				formGroupSelector : '.form-group',
				errorSelector : '.form-message',
				rules : [ 
							Validator.isRequired('#maKH'),
							Validator.isPattern('#maKH',/^(KH)[0-9]+$/,"Vui lòng nhập đúng format KHxxxxx"),
							Validator.isLength('#maKH',7),
							Validator.isRequired('#maDV'),
							Validator.isPattern('#maDV',/^(DV)[0-9]+$/,"Vui lòng nhập đúng format DVxxxxx"),
							Validator.isLength('#maDV',6),
							Validator.isRequired('#ngaySuDung'), 
							Validator.isRequired('#gioSuDung'),
							Validator.isRequired('#soLuong'), 
							Validator.isGreaterThanZero('#soLuong'), 
						],
			});
		});
	</script>
</body>
</html>