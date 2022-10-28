<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<h3>Edit Profile</h3>
<hr>
<form id="form-edit-profile" class="form">
	<div class="form-title">Profile Form Elements</div>
	<div class="form-body ">
		<div class="form-group">
			<label for="inputFirstName">First Name</label>
			<input id="inputFirstName" name="inputFirstName" class="form-control h-45" type="text"
				placeholder="Enter the first name" maxlength="50">
			<span class="form-message"></span>
		</div>
		<div class="form-group">
			<label for="inputLastName">Last Name</label>
			<input id="inputLastName" name="inputLastName" class="form-control h-45" type="text"
				placeholder="Enter the last name" maxlength="50">
			<span class="form-message"></span>
		</div>
		<div class="form-group">
			<label for="inputEmail">Email</label> <span id="inputEmail" class="d-block" name="inputEmail">your_email@example.com</span>
		</div>
		<div class="form-group">
			<label for="inputPhone">Phone</label>
			<input id="inputPhone" class="form-control h-45" name="inputPhone" type="text" placeholder="Enter the phone">
			<span class="form-message"></span>
		</div>
		<div class="form-group">
			<label for="inputDescription">Description</label>
			<textarea id="inputDescription" class="form-control" name="inputDescription" rows="2"></textarea>
			<span class="form-message"></span>
		</div>
		<div class="form-group">
			<button type="submit" class="btn">Submit button</button>
			<button type="button" class="btn">Reset button</button>
		</div>
	</div>
</form>