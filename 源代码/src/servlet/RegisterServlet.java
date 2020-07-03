package servlet;

import entity.Student;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String studentNumber = req.getParameter("studentNumber");
		String studentName = req.getParameter("studentName");
		String studentSex = req.getParameter("studentSex");
		String studentDepartment = req.getParameter("studentDepartment");;
		String studentPhone = req.getParameter("studentPhone");
		String studentPwd = req.getParameter("studentPwd");

		StudentServiceImpl studentService = new StudentServiceImpl();
		Student studentRes = studentService.selectByStudentNumber(studentNumber);

		if (studentRes.getStudentNumber() == null) {
			Student student = new Student();
			student.setStudentDepartment(studentDepartment);
			student.setStudentNumber(studentNumber);
			student.setStudentName(studentName);
			student.setStudentSex(studentSex);
			student.setStudentPhone(studentPhone);
			student.setStudentPwd(studentPwd);
			student.setStudentSign("未报名");
			if (studentService.insert(student)) {
				//注册成功
				req.setAttribute("registerResult", "success");
			} else {
				//注册失败，未知错误
				req.setAttribute("registerResult", "unknownError");
			}
		} else {
			//学号已存在
			req.setAttribute("registerResult", "nameExit");
		}
		req.getRequestDispatcher("common/register.jsp").forward(req,resp);
	}
}
