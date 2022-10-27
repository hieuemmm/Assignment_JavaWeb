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
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
<title>CM | Computer registration history</title>
<link rel="stylesheet" href="/GeneralAssignmentATJBopt2/resources/css/index.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container mt-2">
		<!--Header of page-->
		<div class="d-flex justify-content-between my-2">
			<h3>Computer registration history</h3>
			<a href="/GeneralAssignmentATJBopt2/useComputer/add">
				<button class="btn btn-success btn-search">Regiter computer</button>
			</a>
		</div>
		<div class="d-flex justify-content-between mt-2">
			<form id="formSearch" class="w-100 d-flex justify-content-between" method="GET" action="/GeneralAssignmentATJBopt2/useComputer/search">
				<div class="form-group col pl-0 mb-0">
					<input type="text" class="form-control" id="inputSearch" name="search" placeholder="Enter keyword..." value="${search}"/> 
					<span class="form-message"></span>
				</div>
				<button type="submit" class="btn btn-primary ml-auto btn-search">Search</button>
			</form>
		</div>
		<!--Báo thành công-->
		<p class="text-center text-success">${messageSuccess}</p>
		<!--Danh sách dữ liệu-->
		<table class="table">
			<thead>
				<tr>
					<th scope="col">STT</th>
					<th scope="col">Mã KH</th>
					<th scope="col">Mã Máy</th>
					<th scope="col">Ngày bắt đầu sử dụng</th>
					<th scope="col">Giờ bắt đầu sử dụng</th>
					<th scope="col">Thời gian sử dụng</th>
					<th scope="col">Thao tác</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${useComputers}" var="useComputer" varStatus="var">
					<tr>
						<th scope="row">${var.count}</th>
						<td>${useComputer.maKH}</td>
						<td>${useComputer.maMay}</td>
						<td>${useComputer.ngayBatDauSuDung}</td>
						<td>${useComputer.gioBatDauSuDung}</td>
						<td>${useComputer.thoiGianSuDung}</td>
						<td >
							<a class="text-decoration-none" href="/GeneralAssignmentATJBopt2/useComputer/edit/${useComputer.maKH}/${useComputer.maMay}/${useComputer.ngayBatDauSuDung}/${useComputer.gioBatDauSuDung}">
								<i class="bi bi-pencil-square" style="font-size: 25px; color:blue"></i>
							</a>
							<i 
								class="bi bi-trash3-fill" 
								style="font-size: 25px;color:red"
								dataURL="/GeneralAssignmentATJBopt2/useComputer/delete/${useComputer.maKH}/${useComputer.maMay}/${useComputer.ngayBatDauSuDung}/${useComputer.gioBatDauSuDung}/${currentPage}"
								onclick="deleteFunction(event)"
							></i>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!--Phân trang nếu không phải là search-->
		<c:if test="${search == null}">
			<div class="d-flex align-items-center">
				<p class="mr-auto">Total page: ${totalPages}</p>
				<nav class="d-flex justify-content-center">
					<ul class="pagination">
						<c:if test="${currentPage > 1}">
							<li class="page-item">
								<a class="page-link" href="/GeneralAssignmentATJBopt2/useComputer/${currentPage - 1}">Previous</a>
							</li>
						</c:if>
						<c:if test="${currentPage <= 1}">
							<li class="page-item disabled">
								<a class="page-link" >Previous</a>
							</li>
						</c:if>
						<c:forEach begin="1" end="${totalPages}" var="i">
							<c:if test="${currentPage == i}">
								<li class="page-item active">
									<a class="page-link" href="/GeneralAssignmentATJBopt2/useComputer/${i}">${i}</a>
								</li>
							</c:if>
							<c:if test="${currentPage != i}">
								<li class="page-item">
									<a class="page-link" href="/GeneralAssignmentATJBopt2/useComputer/${i}">${i}</a>
								</li>
							</c:if>
						</c:forEach>
						<c:if test="${currentPage < totalPages}">
							<li class="page-item">
								<a class="page-link" href="/GeneralAssignmentATJBopt2/useComputer/${currentPage + 1}">Next</a>
							</li>
						</c:if>
						<c:if test="${currentPage >= totalPages}">
							<li class="page-item disabled">
								<a class="page-link">Next</a>
							</li>
						</c:if>
					</ul>
				</nav>
			</div>
		</c:if>
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
	<script>
		function deleteFunction(event) {
		  let resultConfirm  = confirm("Bạn có muốn xoá không?");
		  if(resultConfirm){
			  window.location.href = event.target.getAttribute("dataURL");
		  }
		}
	</script>
</body>
</html>