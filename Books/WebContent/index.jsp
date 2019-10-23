<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>

<form action="fetch.books">
<input type ="text" placeholder ="Enter name" name="name"/>
<input type ="text" placeholder ="Enter price" name="price"/>
<input type ="text" placeholder ="Enter authorname" name="authorname"/>
<button type="submit">Add</button>
</form>

<table>
		<tr>
			<td>Name</td><td>Price</td><td>AuthorName</td>
		</tr>
		<c:forEach var="Books" items="${list}">
			<tr>
				<td>${Books.name}</td>
				<td>${Books.price}</td>
				<td>${Books.authorname}</td>
				
			</tr>
			
		</c:forEach>
	</table>


</body>
</html>