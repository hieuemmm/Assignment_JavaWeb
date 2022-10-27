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
<title>CM | All detail</title>
<link rel="stylesheet" href="/GeneralAssignmentATJBopt2/resources/css/index.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container mt-2">
		<!--Header of page-->
		<div class="d-flex justify-content-between my-2">
			<h3>${modeShow=='allToDayOnline'?'All online now':'All past history'}</h3>
			<div>
				<span>Mode:</span>
				<a href="/GeneralAssignmentATJBopt2/allDetail/allHistory/1">
					<button 
						style="width: 100px;"
						class="btn border btn-sm ${modeShow=='allHistory'?'active':''}"
					>All history</button>
				</a>
				<a href="/GeneralAssignmentATJBopt2/allDetail/allToDayOnline/1">
					<button 
						style="width: 100px;"
						class="btn border btn-sm ${modeShow=='allToDayOnline'?'active':''}"
					>Today online</button>
				</a>
			</div>
		</div>
		
		<!--Danh sách dữ liệu-->
		<table class="table">
			${messageSuccess}
			<thead>
				<tr>
					<th scope="col">STT</th>
					<th scope="col">Mã KH</th>
					<th scope="col">Mã máy</th>
					<th scope="col">Trạng thái</th>
					<th scope="col">Ngày BDSD</th>
					<th scope="col">Giờ BDSD</th>
					<th scope="col">Thời gian SD</th>
					<th>Tổng dịch vụ<th>
					<th>Thao tác<th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allDetail}" var="detail" varStatus="var">
					<tr>
						<th scope="row">${var.count}</th>
						<!-- Tên khách hàng -->
						<td title="Tên khách: ${detail.tenKH}">
							<a href="/GeneralAssignmentATJBopt2/customer/search?search=${detail.maKH}">
								<i class="bi bi-person-video3"></i>
								<span>${detail.maKH}</span>
							</a>
						</td>
						<!-- Mã máy -->
						<td title="Vị trí: ${detail.viTri}">
							<span class="computer">${detail.maMay}<span>
						</td>
						<c:if test='${detail.trangThaiThanhToan == true}'>
							<td data-status="Da Thanh Toan"><i class="bi bi-circle-fill"></i></td>
						</c:if>
						<c:if test='${detail.trangThaiThanhToan == false}'>
							<td data-status="${detail.trangThai}"><i class="bi bi-circle-fill"></i></td>
						</c:if>
						<td>
							${detail.ngayBatDauSuDung}
						</td>
						<td>${detail.gioBatDauSuDung}</td>
						<td>${detail.thoiGianSuDung}</td>
						<td>${detail.tongCong != null ? detail.tongCong : "0"} VNĐ</td>
						<td>
							<button class="btn border btn-sm">More detail</button>
							<c:if test='${detail.trangThaiThanhToan == false}'>
								<button 
									class="btn border btn-sm"
									dataMoney = '${detail.tongCong != null ? detail.tongCong : "0"} VNĐ phí dịch vụ + Tiền giờ'
									dataURL="/GeneralAssignmentATJBopt2/allDetail/checkOut/${detail.maKH}/${detail.maMay}/${detail.ngayBatDauSuDung}/${detail.gioBatDauSuDung}/${currentPage}"
									onclick="CheckOut(event)"
								>CheckOut</button>
							</c:if>
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
								<a class="page-link" href="/GeneralAssignmentATJBopt2/allDetail/allHistory/${currentPage - 1}">Previous</a>
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
									<a class="page-link" href="/GeneralAssignmentATJBopt2/allDetail/allHistory/${i}">${i}</a>
								</li>
							</c:if>
							<c:if test="${currentPage != i}">
								<li class="page-item">
									<a class="page-link" href="/GeneralAssignmentATJBopt2/allDetail/allHistory/${i}">${i}</a>
								</li>
							</c:if>
						</c:forEach>
						<c:if test="${currentPage < totalPages}">
							<li class="page-item">
								<a class="page-link" href="/GeneralAssignmentATJBopt2/allDetail/allHistory/${currentPage + 1}">Next</a>
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
		function CheckOut(event) {
		  let resultConfirm  = confirm("Xác nhận thanh toán: "+ event.target.getAttribute("dataMoney"));
		  if(resultConfirm){
			  window.location.href = event.target.getAttribute("dataURL");
		  }
		}
	</script>
</body>
</html>