package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Exit")
public class ExitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String type = req.getParameter("type");

        if(type.equals("student"))
            session.removeAttribute("student");
        else if(type.equals("faculty"))
            session.removeAttribute("faculty");
        else if(type.equals("admin"))
            session.removeAttribute("admin");
        resp.sendRedirect("common/login.jsp");
    }
}
