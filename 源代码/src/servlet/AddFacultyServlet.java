package servlet;

import entity.Faculty;
import service.impl.FacultyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddFaculty")
public class AddFacultyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String department = req.getParameter("department");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");


        FacultyServiceImpl facultyService = new FacultyServiceImpl();


        Faculty faculty = facultyService.selectByName(name);
        if(faculty.getName() == null) {
            faculty.setDepartment(department);
            faculty.setName(name);
            faculty.setPwd(pwd);

            if(facultyService.insert(faculty))
                req.setAttribute("addFacultyResult","success");
            else
                req.setAttribute("addFacultyResult","failed");
        }
        else
            req.setAttribute("addFacultyResult","nameExist");

        req.getRequestDispatcher("admin/admin_add_faculty.jsp").forward(req,resp);
     }

}
