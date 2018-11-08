<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Team</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" type="text/css">
	<style>
		* {
			margin: 10px auto;
		}
	</style>
</head>
<body>
	<div class="container">
	
	<div class="row">
	<h4>Create a new Team</h4>
	</div>
	
	<form action="Teams" method="POST">
		<div class="row">
			<label for="teamName">Team Name</label>
			<input type="text" name="teamName">
		</div>
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm">
				<button class="btn btn-warning" type="submit">Create</button>
			</div>
		</div>
	</form>
	
	</div> <!-- end of container -->
</body>
</html>