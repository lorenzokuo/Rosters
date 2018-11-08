<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Player</title>
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
	<h4>Add a player to team <c:out value="${ user_team.getTeamName() }"/></h4>
	</div>
	
	<form action="Players?id=${ user_id }" method="POST">
		<div class="row">
			<label for="firstName">First Name</label>
			<input type="text" name="firstName">
		</div>
		<div class="row">
			<label for="lastName">Last Name</label>
			<input type="text" name="lastName">
		</div>
		<div class="row">
			<label for="age">Age</label>
			<input type="number" name="age">
		</div>
		<div class="row">
			<div class="col-sm-5"></div>
			<div class="col-sm">
				<button class="btn btn-warning" type="submit">Add</button>
			</div>
		</div>
	</form>
	
	</div> <!-- end of container -->
</body>
</html>