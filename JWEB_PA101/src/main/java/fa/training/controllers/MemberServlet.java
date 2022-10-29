package fa.training.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.entities.Member;
import fa.training.services.IMemberService;
import fa.training.services.MemberService_Impl;
import fa.training.utils.DateUtil;

@WebServlet(name = "MemberServlet", urlPatterns = { "/member" })
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMemberService memberService = new MemberService_Impl();

	public MemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Member member = memberService.findByUsername(username);
		request.setAttribute("member", member);
		request.getRequestDispatcher("views/editProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/editProfile.jsp");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String description = request.getParameter("description");
		String updateTime = DateUtil.getDateTime();
		//get username session
		String userName = (String) request.getSession().getAttribute("username");
		//save edit member
		Member member = new Member(userName, firstName, lastName, phone, description, updateTime.toString());
		if(memberService.saveEdit(member)) {
			request.setAttribute("member", member);
			request.setAttribute("messageSuccess", "Update success");
		}else {
			request.setAttribute("messageError", "Unexpected error has occurred");
		}
		requestDispatcher.forward(request, response);
	}
}
