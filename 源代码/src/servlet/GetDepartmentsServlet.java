package servlet;


import entity.Departments;
import service.impl.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetDepartmentsServlet",urlPatterns = {"/GetDepartments"})
public class GetDepartmentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DepartmentsServiceImpl departmentsService = new DepartmentsServiceImpl();
        List<Departments> departments = departmentsService.findAll();
        req.setAttribute("departments",departments);

        String from = req.getParameter("from");
        if(from.equals("reg"))
            req.getRequestDispatcher("common/register.jsp").forward(req,resp);
        else if(from.equals("updateSign"))
            req.getRequestDispatcher("faculty/faculty_update_sign.jsp").forward(req,resp);
        else if(from.equals("admin"))
            req.getRequestDispatcher("admin/admin_update_faculty.jsp").forward(req,resp);
        else if(from.equals("addFaculty"))
            req.getRequestDispatcher("admin/admin_add_faculty.jsp").forward(req,resp);
        else if(from.equals("updateStudent"))
            req.getRequestDispatcher("admin/admin_update_student.jsp").forward(req,resp);

    }
}
