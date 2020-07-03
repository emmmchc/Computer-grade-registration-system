package servlet;

import entity.Admin;
import entity.Page;
import service.impl.PageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/page2")
public class PageServlet2 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pageServlet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pageServlet(req, resp);
    }

    protected void pageServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Admin admin = (Admin)session.getAttribute("admin");

        req.setAttribute("isQuery", true);
        //获取num
        String num = req.getParameter("num");
        int curNum = Integer.parseInt((num == null ? "1" : num));

        //调用业务层的功能：以分页的形式查询当前页下信息
        //返回PageModel对象（1当前页信息2分页3url）
        PageService pageService=new PageService();
        Page page=null;
        try {
            page = pageService.pageService(curNum,req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将PageModel对象放入request
        req.setAttribute("page", page);
        if(admin != null)
            req.getRequestDispatcher("admin/admin_search_sign.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("faculty/faculty_search_sign.jsp").forward(req, resp);
    }
}

