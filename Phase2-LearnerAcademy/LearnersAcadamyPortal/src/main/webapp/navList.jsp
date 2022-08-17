<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #04AA6D;
}
</style>
</head>
<body>
<div class="nav">
	<c:url var="classesLink" value="AdminServlet">
		<c:param name="command" value="CLASSES" />
	</c:url>

	<c:url var="subjectsLink" value="AdminServlet">
		<c:param name="command" value="SUBJECTS" />
	</c:url>

	<c:url var="teachersLink" value="AdminServlet">
		<c:param name="command" value="TEACHERS" />
	</c:url>

	<c:url var="studentsLink" value="AdminServlet">
		<c:param name="command" value="STUDENTS" />
	</c:url>
	<div class="items">
	<ul>
	   <li><a class="bar-item active" href="#">Admin Dashboard</a> </li>
		<li><a class="bar-item" href="${classesLink}">Classes</a> </li>
		<li><a class="bar-item" href="${subjectsLink}">Subjects</a></li>
		<li><a class="bar-item" href="${teachersLink}">Teachers</a> </li>
		<li><a class="bar-item" href="${studentsLink}">Students</a> </li>
		<li><a class="bar-item" href="login.jsp">Log out</a></li>
		</ul>
	</div>
	
	
</div>
</body>