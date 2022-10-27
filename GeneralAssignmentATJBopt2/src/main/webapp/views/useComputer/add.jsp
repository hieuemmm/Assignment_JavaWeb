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
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>	
<title>CM | Register to use the computer</title>
<link rel="stylesheet" href="/GeneralAssignmentATJBopt2/resources/css/index.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container mt-2">
		<div class="d-flex justify-content-center my-2">
			<h3>Register to use the computer</h3>
		</div>
		<form:form id="form" class="border p-4" method="POST"
			action="/GeneralAssignmentATJBopt2/useComputer/saveAdd"
			modelAttribute="useComputer">
			<c:if test='${messageError != null}'>
				<div class="form-group">
					<div class="alert alert-danger" role="alert">
					  ${messageError}
					</div>
				</div>
			</c:if>
				
			<div class="form-group">
				<label for="maKH">Mã khách hàng</label>  
				<form:select class="custom-select" id="maKH" path="maKH" value="${useComputer.maKH}">
					<form:option value="">--Không chọn--</form:option>
					<c:forEach items="${customers}" var="customer">
						<form:option value="${customer.maKH}">${customer.maKH} - ${customer.tenKH}</form:option>
					</c:forEach>
				</form:select> 
				<span class="form-message">Messeage...</span>
			</div>
			<div class="form-group">
				<label for="maMay" data-status="Dang ranh">Mã máy (<i class="bi bi-circle-fill"></i>)</label> 
				<form:select class="custom-select" id="maMay" path="maMay" value="${useComputer.maMay}">
					<form:option value="">--Không chọn--</form:option>
					<c:forEach items="${computers}" var="computer">
					<c:if test="${computer.trangThai == 'Dang ranh'}">
						<form:option value="${computer.maMay}">${computer.maMay} - ${computer.viTri}</form:option>
					</c:if>
					</c:forEach>
				</form:select> 
				<span class="form-message">Messeage...</span>
			</div>
			<div class="form-group">
				<label for="ngayBatDauSuDung">Ngày bắt đầu sử dụng</label> 
				<form:input type="date" class="form-control" id="ngayBatDauSuDung" path="ngayBatDauSuDung" value="${useComputer.ngayBatDauSuDung}"/> 
				<span class="form-message">Messeage...</span>
			</div>
			<div class="form-group">
				<label for="gioBatDauSuDung">Giờ sử dụng</label> 
				<form:input type="time" class="form-control without_ampm" id="gioBatDauSuDung" path="gioBatDauSuDung" value="${useComputer.gioBatDauSuDung}"/> 
				<span class="form-message">Messeage...</span>
			</div>
			<div class="form-group">
				<label for="thoiGianSuDung">Thời gian sử dụng</label> 
				<form:input type="number" class="form-control" id="thoiGianSuDung" path="thoiGianSuDung" placeholder="Nhập thời gian sử dụng..." value="${useComputer.thoiGianSuDung}"/> 
				<span class="form-message">Messeage...</span>
			</div>
			<div class="d-flex justify-content-end w-100">
				<button type="reset" class="btn btn-outline-white border mr-auto">Clear</button>
				<button type="submit" class="btn btn-primary mr-2">Create</button>
				<a href="/GeneralAssignmentATJBopt2/useComputer/" class="mr-2">
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
			document.getElementById("ngayBatDauSuDung").value = currentDate;
			document.getElementById("ngayBatDauSuDung").setAttribute("max",currentDate);
			document.getElementById("gioBatDauSuDung").value = currentTime;
			
			Validator({
				form : '#form',
				formGroupSelector : '.form-group',
				errorSelector : '.form-message',
				rules : [ 
							Validator.isRequired('#maKH'),
							Validator.isPattern('#maKH',/^(KH)[0-9]+$/,"Vui lòng nhập đúng format KHxxxxx"),
							Validator.isLength('#maKH',7),
							Validator.isRequired('#maMay'),
							Validator.isPattern('#maMay',/^(M)[0-9]+$/,"Vui lòng nhập đúng format Mxxxx"),
							Validator.isLength('#maMay',5),
							Validator.isRequired('#ngayBatDauSuDung'), 
							Validator.isRequired('#gioBatDauSuDung'),
							Validator.isRequired('#thoiGianSuDung'), 
							Validator.isGreaterThanZero('#thoiGianSuDung'), 
						],
			});
		});
	</script>
</body>
</html>