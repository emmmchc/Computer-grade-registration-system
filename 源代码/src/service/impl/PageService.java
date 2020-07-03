package service.impl;

import dao.impl.SignDaoImpl;
import dao.impl.StudentDaoImpl;
import entity.Admin;
import entity.Faculty;
import entity.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PageService {
	public Page pageService(int curNum, HttpServletRequest req) throws Exception {

		String pp = req.getParameter("printStudent");

		if(pp != null)
		{
			StudentDaoImpl studentDao = new StudentDaoImpl();
			String sql = "";
			if(req.getAttribute("isQuery")!=null) {
				sql = "select count(*) as result from student2";
			}
			else {
				sql = "select count(*) as result from student";
			}

			int totalRecords = studentDao.findtotalRecords(sql);
			Page page=new Page(curNum, totalRecords, 9);
			String sql2 = "";
			if(req.getAttribute("isQuery")!=null) {
				sql2 = "select * from student limit ?,?";
				//关联url
				page.setUrl("page2?method=pageServlet&printStudent=yes&");
			}
			else {
				sql2 = "select * from student limit ?,?";
				//关联url
				page.setUrl("page?method=pageServlet&printStudent=yes&");
			}
			List list=studentDao.studentPage(page.getStartIndex(),page.getPageSize(),sql2);
			page.setList(list);

			return page;
		}
		else {
			HttpSession session = req.getSession();
			Faculty faculty = (Faculty) session.getAttribute("faculty");
			Admin admin = (Admin) session.getAttribute("admin");
			//1 创建pageModel对象  目的：计算分页参数
			//统计当前总记录数  select count(*) from sign
			SignDaoImpl signDao = new SignDaoImpl();
			String sql = "";
			if(faculty != null){
				if(req.getAttribute("isQuery")!=null) {
					sql = "select count(*) as result from sign2 where sign_department = '" + faculty.getDepartment() + "'";
				}
				else {
					sql = "select count(*) as result from sign where sign_department = '" + faculty.getDepartment() + "'";
				}
			}
			else if(admin != null){
				if(req.getAttribute("isQuery")!=null) {
					sql = "select count(*) as result from sign2";
				}
				else {
					sql = "select count(*) as result from sign";
				}
			}
			int totalRecords = signDao.findtotalRecords(sql);
			Page page=new Page(curNum, totalRecords, 3);
			//2.关联集合   select * form sign limit ?,?
			String sql2 = "";

			if(faculty != null){
				if(req.getAttribute("isQuery")!=null) {
					sql2 = "select * from sign2 where sign_department = '"+ faculty.getDepartment() + "' limit ?,?";
					//关联url
					page.setUrl("page2?method=pageServlet&");
				}
				else {
					sql2 = "select * from sign where sign_department = '"+ faculty.getDepartment() + "' limit ?,?";
					//关联url
					page.setUrl("page?method=pageServlet&");
				}
			}
			else if(admin != null){
				if(req.getAttribute("isQuery")!=null) {
					sql2 = "select * from sign2 limit ?,?";
					//关联url
					page.setUrl("page2?method=pageServlet&");
				}
				else {
					sql2 = "select * from sign limit ?,?";
					//关联url
					page.setUrl("page?method=pageServlet&");
				}
			}

			List list=signDao.signPage(page.getStartIndex(),page.getPageSize(),sql2);
			page.setList(list);

			return page;
		}
	}
}
