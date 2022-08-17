import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import school.Student;
import school.Subject;
import school.Teacher;
import school.Class;


@WebServlet("/HelperServlet")
public class HelperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DataHelper DataHelper;

	@Resource(name = "jdbc_database")
	private DataSource datasource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			DataHelper = new DataHelper(datasource);

		} 
		catch (Exception e) {
			throw new ServletException(e);
		}

	}


	public HelperServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String command = request.getParameter("command");
			if (command == null) {
				command = "CLASSES";
			}
			if (!getCookies(request, response) && (!command.equals("LOGIN"))) {
				response.sendRedirect("login.jsp");
			}

			else {
				switch (command) {

				case "STUDENTS":
					studentsList(request, response);
					break;

				case "TEACHERS":
					teachersList(request, response);
					break;

				case "SUBJECTS":
					subjectList(request, response);
					break;

				case "CLASSES":
					classestList(request, response);
					break;

				case "ST_LIST":
					classStudentsList(request, response);
					break;

				case "LOGIN":
					login(request, response);
					break;

				default:
					classestList(request, response);
				}
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	private void studentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Student> students = DataHelper.getStudents();
		request.setAttribute("STUDENT_LIST", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentsList.jsp");
		dispatcher.forward(request, response);
	}

	private void teachersList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Teacher> teachers = DataHelper.getTeachers();
		request.setAttribute("TEACHERS_LIST", teachers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teachersList.jsp");
		dispatcher.forward(request, response);

	}

	private void subjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Subject> subjects = DataHelper.getSubjects();
		request.setAttribute("SUBJECTS_LIST", subjects);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subjectsList.jsp");
		dispatcher.forward(request, response);
	}

	private void classestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Class> classes = DataHelper.getClasses();
		request.setAttribute("CLASSES_LIST", classes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classesList.jsp");
		dispatcher.forward(request, response);

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {
			Cookie cookie = new Cookie(username, password);
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			cookie.setMaxAge(86400);
			response.addCookie(cookie);
			classestList(request, response);
		} 
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void classStudentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int classId = Integer.parseInt(request.getParameter("classId"));
		String section = request.getParameter("section");
		String subject = request.getParameter("subject");
		List<Student> students = DataHelper.loadClassStudents(classId);
		request.setAttribute("STUDENTS_LIST", students);
		request.setAttribute("SECTION", section);
		request.setAttribute("SUBJECT", subject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classStudentsList.jsp");
		dispatcher.forward(request, response);
	}

	private boolean getCookies(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean check = false;
		Cookie[] cookies = request.getCookies();
		try {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("admin") && cookie.getValue().equals("admin")) {
					check = true;
					break;
				} 
			}
		}
		catch (Exception e) {
			String site = new String("login.jsp");
		    response.setStatus(response.SC_MOVED_TEMPORARILY);
		    response.setHeader("Location", site);
			return false;
		}
		return check;
	}
}
