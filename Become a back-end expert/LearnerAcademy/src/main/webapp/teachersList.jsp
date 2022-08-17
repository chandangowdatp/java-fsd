<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Teachers</title>
<link type="text/css" rel="stylesheet" href="style.css">
</head>
<body>
	<div id="page">
		<jsp:include page="navList.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Teachers List</h3>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<table>
					<tr><th>Name</th></tr>
					<c:forEach var="tempStudent" items="${TEACHERS_LIST }">
						<tr><td>${tempStudent.fname} ${tempStudent.lname}</td></tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>