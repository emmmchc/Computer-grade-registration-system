package servlet;


import entity.Page;
import service.impl.PageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page")
public class PageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pageServlet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pageServlet(req, resp);
	}
	
	protected void pageServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//获取num
		String num = req.getParameter("num");
		int curNum = Integer.parseInt((num == null ? "1" : num));
		//调用业务层的功能：以分页的形式查询当前页下信息
		//返回Page对象（1当前页信息2分页3url）
		PageService pageService=new PageService();
		Page page=null;
		try {
			page = pageService.pageService(curNum,req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//将Page对象放入request
		req.setAttribute("page", page);

		//转发到jsp
		String printStudent = req.getParameter("printStudent");
		if(printStudent != null)
			req.getRequestDispatcher("admin/admin_manage_student.jsp").forward(req, resp);
		else
			req.getRequestDispatcher("faculty/faculty_manage_sign.jsp").forward(req, resp);
		
	}
}
