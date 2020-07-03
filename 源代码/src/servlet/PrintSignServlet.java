package servlet;

import entity.Admin;
import entity.Faculty;
import entity.Sign;
import entity.Student;
import service.impl.SignServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PrintSignServlet",urlPatterns = {"/PrintSign"})
public class PrintSignServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Faculty faculty = (Faculty) session.getAttribute("faculty");

        Student student = (Student)session.getAttribute("student");

        Admin admin = (Admin)session.getAttribute("admin");

        SignServiceImpl signService = new SignServiceImpl();
        if(student != null) {
            Sign sign = signService.select(student.getStudentNumber());
            req.setAttribute("sign",sign);
            req.getRequestDispatcher("student/printSign.jsp").forward(req,resp);
        }
        else if(faculty != null){
            req.getRequestDispatcher("/page").forward(req, resp);
        }
        else if(admin != null){
            req.getRequestDispatcher("/page").forward(req, resp);
        }
        return;
    }
}
