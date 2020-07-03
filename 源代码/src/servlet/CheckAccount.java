package servlet;

import entity.Admin;
import entity.Faculty;
import entity.Student;
import service.impl.AdminServiceImpl;
import service.impl.FacultyServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CheckAccount",urlPatterns = {"/CheckAccount"})
public class CheckAccount extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();

		//学生用学号登录
		String name = req.getParameter("userName");
		String pwd = req.getParameter("userPwd");
		String role = req.getParameter("role");

		if(role.equals("student")) {
			//学生
			StudentServiceImpl studentService = new StudentServiceImpl();
			Student studentRes = studentService.selectByStudentNumber(name);
			//存在该名学生
			if(studentRes.getStudentNumber() != null) {
				if(pwd.equals(studentRes.getStudentPwd())) {
					//密码匹配成功
					session.setAttribute("student", studentRes);
					resp.sendRedirect("student/student.jsp");
					return;
				} else {
					//密码错误
					req.setAttribute("loginResult", "pwdError");
				}
			} else {
				//名字不存在
				req.setAttribute("loginResult", "nameError");
			}
		} else if (role.equals("faculty")) {
			//院系管理员
			FacultyServiceImpl facultyService = new FacultyServiceImpl();
			Faculty facultyRes = facultyService.selectByName(name);
			//存在该院系管理员
			if(facultyRes.getName() != null) {
				if(pwd.equals(facultyRes.getPwd())) {
					//密码匹配成功
					session.setAttribute("faculty", facultyRes);
					resp.sendRedirect("faculty/faculty.jsp");
					return;
				} else {
					//密码错误
					req.setAttribute("loginResult", "pwdError");
				}
			} else {
				//名字不存在
				req.setAttribute("loginResult", "nameError");
			}
		}
		else if (role.equals("admin")) {
			//系统管理员
			AdminServiceImpl adminService = new AdminServiceImpl();
			Admin adminRes = adminService.selectByName(name);
			//存在该院系管理员
			if(adminRes.getName() != null) {
				if(pwd.equals(adminRes.getPwd())) {
					//密码匹配成功
					session.setAttribute("admin", adminRes);
					resp.sendRedirect("admin/admin.jsp");
					return;
				} else {
					//密码错误
					req.setAttribute("loginResult", "pwdError");
				}
			} else {
				//名字不存在
				req.setAttribute("loginResult", "nameError");
			}
		}
		req.getRequestDispatcher("common/login.jsp").forward(req,resp);
	}
}
