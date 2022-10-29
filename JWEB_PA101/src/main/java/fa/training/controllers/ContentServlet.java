package fa.training.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.entities.Content;
import fa.training.services.IContentService;
import fa.training.utils.DateUtil;
import fa.training.services.ContentService_Impl;

import javax.servlet.annotation.*;
import javax.servlet.*;

@WebServlet(name = "ContentServlet", urlPatterns = "/content")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IContentService contentService = new ContentService_Impl();

	public ContentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkLogin(request, response)) {
			response.sendRedirect("login");
			return;
		}
		String action = request.getParameter("action");
		if (action == null || action.isEmpty()) {
			action = "";
		}
		switch (action) {
		case "view":
			getListContent(request, response);
			break;
		case "form":
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/formContent.jsp");
			requestDispatcher.forward(request, response);
		default:
			getListContent(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String brief = request.getParameter("brief");
		String content = request.getParameter("content");
		String createDate = DateUtil.getDateTime();
		String userName = (String) request.getSession().getAttribute("username");
		Content contentArticle = new Content(title, brief, content, createDate);
		contentArticle.setUseName(userName);
		contentService.saveContent(contentArticle);
		//get all
		request.setAttribute("contentList", contentService.findAllByUser(userName));
		
		request.getRequestDispatcher("views/contentList.jsp").forward(request, response);
	}

	private boolean checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null || username.isEmpty()) {
			return true;
		}
		return false;
	}

	private void getListContent(HttpServletRequest request, HttpServletResponse response) {
		String userName = (String) request.getSession().getAttribute("username");
		request.setAttribute("contentList", contentService.findAllByUser(userName));
		try {
			request.getRequestDispatcher("views/contentList.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
