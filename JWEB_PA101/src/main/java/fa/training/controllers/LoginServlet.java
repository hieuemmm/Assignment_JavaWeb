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
		String userName = request.getParameter("user_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		if (!password.equals(rePassword)) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/register.jsp");
			request.setAttribute("mess", "Password incorrect");
			request.setAttribute("user_name", userName);
			request.setAttribute("email", email);
			requestDispatcher.forward(request, response);
		} else {
			Member member = new Member(userName, password, email);
			System.out.println("userName"+userName);
			System.out.println("password"+password);
			System.out.println("email"+email);
			boolean check = memberService.saveRegister(member);
			if (check) {
				request.setAttribute("mess", "Registration Success");
			} else {
				request.setAttribute("mess", "Registration failed");
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login.jsp");
			try {
				requestDispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void postLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		if (memberService.login(username, password)) {
			List<Content> contentList = contentService.findAll();
			request.setAttribute("contentList", contentList);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			request.getRequestDispatcher("views/contentList.jsp").forward(request, response);
		} else {
			request.setAttribute("name", username);
			request.setAttribute("error", "Incorrect email or password");
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
		}
	}

}
