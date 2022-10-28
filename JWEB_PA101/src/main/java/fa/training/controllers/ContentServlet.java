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
		LocalDateTime ldt = LocalDateTime.now();

		String createDate = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINESE).format(ldt);
		String updateTime = DateTimeFormatter.ofPattern("hh:mm", Locale.CHINESE).format(ldt);
		Content content1 = new Content(title, brief, content, createDate, updateTime);
		boolean check = contentService.saveContent(content1);
		if (check) {
			request.setAttribute("mess", "Thêm thành công");
		} else {
			request.setAttribute("mess", "Thêm thất bại");
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contentList.jsp");
		request.setAttribute("contentList", contentService.findAll());
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contentList.jsp");
		List<Content> contentList = contentService.findAll();
		request.setAttribute("contentList", contentList);
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
