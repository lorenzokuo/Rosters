<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
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
		<div class="col-sm-4"><h3>Prototype Roaster</h3></div>
		<div class="col-sm-4"></div>
		<div class="col-sm-4 top-right"><h4><a href="Teams">New Team</a></h4></div>
	</div> <!-- row top end -->
	
	<div class="row">
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Team</th>
		      <th scope="col">Players</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <!-- use JSPL iterate attribute -->
		  <c:forEach var = "team" items="${ roster }" varStatus="idx">
		  <tbody>
		    <tr>
		      <td>${ team.getTeamName() }</td>
		      <td>${ team.getPlayers().size() }</td>
		      <td><a href="Teams?id=${ idx.index }">Details |</a> <a href="DeleteTeam?id=${ idx.index }">Delete</a></td>
		    </tr>
		  </tbody>
		  </c:forEach>
		  
		</table>
	</div> <!-- row bottom end -->
	
	</div> <!-- container end -->
</body>
</html>