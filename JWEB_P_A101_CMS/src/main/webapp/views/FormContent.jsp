<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<h3>Add Content</h3>
<hr>
<form id="form-content" class="form">
	<div class="form-title">Content Form Elements</div>
	<div class="form-body ">
		<div class="form-group">
			<label for="inputTitle">Title</label>
			<input id="inputTitle" class="form-control h-45" name="inputTitle" type="text" placeholder="Enter the title"
				type="text" maxlength="50">
			<span class="form-message"></span>
		</div>
		<div class="form-group">
			<label for="inputBrief">Brief</label>
			<textarea id="inputBrief" class="form-control" name="inputBrief" rows="2"></textarea>
			<span class="form-message"></span>
		</div>
		<div class="form-group">
			<label for="inputContent">Content</label>
			<textarea id="inputContent" class="form-control" name="inputContent" rows="4"></textarea>
			<span class="form-message"></span>
		</div>
		<div class="form-group">
			<button type="submit" class="btn">Submit button</button>
			<button type="reset" class="btn">Reset button</button>
		</div>
	</div>
</form>