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
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChangePwd",urlPatterns = {"/ChangePwd"})
public class ChangePwd extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String type = req.getParameter("type");
		String name = req.getParameter("name");
		String oldPwd = req.getParameter("oldPwd");
		String newPwd = req.getParameter("newPwd");

		PrintWriter out = resp.getWriter();

		if (type.equals("faculty")) {
			FacultyServiceImpl facultyService = new FacultyServiceImpl();
			Faculty faculty = facultyService.selectByName(name);
			if(faculty.getPwd().equals(oldPwd)){
				if (facultyService.updateByPwd(newPwd,faculty.getName())) {
					//密码修改成功
					out.print("密码修改成功");
				} else {
					//密码修改失败，错误未知
					out.print("密码修改失败，错误未知");
				}
			}
			else{
				//旧密码错误
				out.print("旧密码错误");
			}
		}
		else if(type.equals("admin")){
			AdminServiceImpl adminService = new AdminServiceImpl();
			Admin admin = adminService.selectByName(name);
			if(admin.getPwd().equals(oldPwd)){
				admin.setPwd(newPwd);
				int res = adminService.update(admin);
				if (res>0) {
					//密码修改成功
					out.print("密码修改成功");
				} else {
					//密码修改失败，错误未知
					out.print("密码修改失败，错误未知");
				}
			}
			else{
				//旧密码错误
				out.print("旧密码错误");
			}
		}
		else if(type.equals("student")){
			StudentServiceImpl studentService = new StudentServiceImpl();
			Student student = studentService.selectByStudentNumber(name);
			if(student.getStudentPwd().equals(oldPwd)){
				student.setStudentPwd(newPwd);
				if (studentService.updatePwd(student)) {
					//密码修改成功
					out.print("密码修改成功");
				} else {
					//密码修改失败，错误未知
					out.print("密码修改失败，错误未知");
				}
			}
			else{
				//旧密码错误
				out.print("旧密码错误");
			}
		}
		return;
	}

}
