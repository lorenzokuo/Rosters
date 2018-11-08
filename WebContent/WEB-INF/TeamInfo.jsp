<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Team Info</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" type="text/css">
	
	<style>
		.top-right{
			text-align: right;
		}
	</style>
</head>
<body>
	<div class="container">
	
	<div class="row">
		<div class="col-sm-4"><h3><c:out value="${ user_team.getTeamName() }"/></h3></div>
		<div class="col-sm-4"></div>
		<div class="col-sm-4 top-right"><h4><a href="Players?id=<c:out value="${ user_id }"/>">New Player</a></h4></div>
	</div> <!-- row top end -->
	
	<div class="row">
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">First Name</th>
		      <th scope="col">Last Name</th>
		      <th scope="col">Age</th>
		      <th scope="col">Actions</th>
		    </tr>
		  </thead>
		  
		  <c:forEach var="player" items="${ allPlayers }" varStatus="idx">
		  <tbody>
		    <tr>
		      <td>${ player.getFirstName() }</td>
		      <td>${ player.getLastName() }</td>
		      <td>${ player.getAge() }</td>
		      <td><a href="DeletePlayer?id=<c:out value="${ user_id }"/>&player_id=${ idx.index }">Delete</a></td>
		    </tr>
		  </tbody>
		  </c:forEach>
		  
		</table>
	</div> <!-- row bottom end -->
	
	</div> <!-- container end -->
</body>
</html>