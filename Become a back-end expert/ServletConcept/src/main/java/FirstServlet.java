import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //to configure properties of Servlet by using ServletConfig Object
	public void init(ServletConfig config) throws ServletException {
		System.out.println(config.getServletName());
	}

	
	public void destroy() {
		
		System.out.println("Destory Servlet Object");
		
	}

	//request- give data to cleint to server
	//response- give data to server to client
	//HttpServletRequest,HttpServletResponse- 2 interfaces
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service Method");
	}

}
