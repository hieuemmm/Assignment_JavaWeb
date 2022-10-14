package fa.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();

	public RegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/Register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("inputUserName");
		String email = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		String inputRepassword = request.getParameter("inputRepassword");
		System.out.println(userName + email + password + inputRepassword);
		if (false) {
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			String employeeJsonString = this.gson.toJson("OK bạn");
			PrintWriter out = response.getWriter();
			out.print(employeeJsonString);
			out.flush();
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			String employeeJsonString = this.gson.toJson("Lỗi rồi");
			PrintWriter out = response.getWriter();
			out.print(employeeJsonString);
			out.flush();
		}
	}

}
