<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Subjects</title>
<link type="text/css" rel="stylesheet" href="style.css">
</head>
<body >
	<div id="page">
		<jsp:include page="navList.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Subjects List</h3>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>Name</th>
						<th>Shortcut</th>
					</tr>
					<c:forEach var="tempSubject" items="${SUBJECTS_LIST }">
						<tr>
							<td>${tempSubject.name}</td>
							<td>${tempSubject.shortcut}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>