package servlet;

import entity.Sign;
import service.impl.FacultyServiceImpl;
import service.impl.SignServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "DeleteServlet",urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String signNumber=req.getParameter("signNumber");

        String facultyName = req.getParameter("facultyName");

        String studentNumber = req.getParameter("studentNumber");

        if(studentNumber != null){
            StudentServiceImpl studentService = new StudentServiceImpl();
            if(studentService.deleteByStudentNumber(studentNumber))
                req.getRequestDispatcher("./PrintStudent").forward(req,resp);;
        }
        else if(signNumber != null){
            SignServiceImpl signService = new SignServiceImpl();
            Sign sign = signService.select(signNumber);
            if(signService.delete(signNumber)) {
                delpic(sign.getSignPic());
                StudentServiceImpl studentService = new StudentServiceImpl();
                studentService.updateSign("未报名",signNumber);
                req.getRequestDispatcher("page").forward(req,resp);
            }
            else{
                req.getRequestDispatcher("common/error.jsp").forward(req,resp);
            }
        }else if(facultyName != null){
            FacultyServiceImpl facultyService = new FacultyServiceImpl();
            if(facultyService.deleteByName(facultyName))
                resp.sendRedirect("./Faculties");
        }
    }

    public void delpic(String f){
        String path=getServletContext().getRealPath("/pic");
        String file=f.substring(f.lastIndexOf('/')+1);
        File ff=new File(path+File.separator+file);
        if(ff.exists()) ff.delete();
    }
}
