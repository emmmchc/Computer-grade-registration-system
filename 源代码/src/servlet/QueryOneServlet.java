package servlet;

import entity.Faculty;
import entity.Sign;
import entity.Student;
import service.impl.FacultyServiceImpl;
import service.impl.SignServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/query")
public class QueryOneServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String signNumber=req.getParameter("signNumber");
		String facultyName = req.getParameter("facultyName");
		String studentNumber = req.getParameter("studentNumber");
		if(signNumber !=null ){
			SignServiceImpl signService = new SignServiceImpl();
			Sign sign=signService.select(signNumber);

			req.setAttribute("sign",sign);
			req.getRequestDispatcher("/GetDepartments?from=updateSign").forward(req,resp);
		}
		else if(facultyName != null){
			FacultyServiceImpl facultyService = new FacultyServiceImpl();
			Faculty faculty = facultyService.selectByName(facultyName);

			req.setAttribute("faculty",faculty);
			req.getRequestDispatcher("/GetDepartments?from=admin").forward(req,resp);
		}
		else if(studentNumber != null){
			StudentServiceImpl studentService = new StudentServiceImpl();
			Student student = studentService.selectByStudentNumber(studentNumber);

			req.setAttribute("student",student);
			req.getRequestDispatcher("/GetDepartments?from=updateStudent").forward(req,resp);
		}
		else{
			req.getRequestDispatcher("error.jsp").forward(req,resp);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
