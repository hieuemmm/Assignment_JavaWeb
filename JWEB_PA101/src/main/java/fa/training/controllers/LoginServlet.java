package fa.training.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.entities.Content;
import fa.training.entities.Member;
import fa.training.services.IContentService;
import fa.training.services.ContentService_Impl;
import fa.training.services.IMemberService;
import fa.training.services.MemberService_Impl;
import fa.training.utils.DateUtil;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMemberService memberService = new MemberService_Impl();
	private IContentService contentService = new ContentService_Impl();
	
	public LoginServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action == null || action.isEmpty()) {
			action = "login";
		}
		switch (action) {
		case "register":
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
			break;
		case "login":
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
			break;
		case "logout":
			HttpSession session = request.getSession(false);
			session.removeAttribute("name");
			response.sendRedirect("login");
			break;
		default:
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch (action) {
		case "register":
			postRegister(request, response);
			break;
		case "login":
			postLogin(request, response);
			break;
		case "logout":
			HttpSession session1 = request.getSession(false);
			session1.removeAttribute("username");
			response.sendRedirect("/JWEB_PA101/login");
			break;
		default:
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
			break;
		}
	}
	
	private void postRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/register.jsp");
		String userName = request.getParameter("user_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		request.setAttribute("user_name", userName);
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.setAttribute("rePassword", rePassword);
		if (!password.equals(rePassword)) {
			request.setAttribute("messageErorPasswordIncorrect", "Password incorrect");
			requestDispatcher.forward(request, response);
		} else {
			Member member = new Member(userName, email, password, DateUtil.getDateTime());
			if (memberService.saveRegister(member)) {
				request.setAttribute("messageSuccessRegiter", "Registration success");
				request.getRequestDispatcher("views/login.jsp").forward(request, response);
			} else {
				request.setAttribute("messageErorUserName", "User name exits");
				requestDispatcher.forward(request, response);
			}
		}
	}
	
	private void postLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user_name");
		String password = request.getParameter("password");
		request.setAttribute("user_name", username);
		if (memberService.login(username, password)) {
			//set session for login later
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			//forward
			request.getRequestDispatcher("views/index.jsp").forward(request, response);
		} else {
			request.setAttribute("user_name", username);
			request.setAttribute("error", "Incorrect email or password");
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
		}
	}
}
