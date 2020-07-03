package servlet;

import entity.Faculty;
import service.impl.FacultyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Faculties")
public class FacultyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FacultyServiceImpl facultyService = new FacultyServiceImpl();
        List<Faculty> faculties = facultyService.findAll();
        req.setAttribute("faculties",faculties);
        req.getRequestDispatcher("admin/admin_manage_faculties.jsp").forward(req,resp);
    }
}
