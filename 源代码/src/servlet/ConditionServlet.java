package servlet;

import entity.Sign;
import service.impl.SignServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/condition")
public class ConditionServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前页
        String num = req.getParameter("num");
        int curNum = Integer.parseInt((num == null ? "1" : num));

        Sign sign = new Sign();
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        sign.setSignNumber(sno);
        sign.setSignName(sname);

        SignServiceImpl signService = new SignServiceImpl();
        try {
            signService.confind(sign);
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/page2").forward(req, resp);
    }
}
