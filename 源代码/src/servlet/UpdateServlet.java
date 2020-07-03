package servlet;

import entity.Faculty;
import entity.Sign;
import entity.Student;
import service.impl.FacultyServiceImpl;
import service.impl.SignServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/update")
@MultipartConfig
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Part file =null;
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String studentNumber = request.getParameter("studentNumber");
    	if(studentNumber != null){
			Student student = new Student();
			int id = Integer.parseInt(request.getParameter("id"));

			String studentName = request.getParameter("studentName");
			String studentSex = request.getParameter("studentSex");
			String studentDepartment = request.getParameter("studentDepartment");

			String studentPhone = request.getParameter("studentPhone");
			String studentPwd = request.getParameter("studentPwd");
			String studentSign = request.getParameter("studentSign");

			student.setId(id);
			student.setStudentNumber(studentNumber);
			student.setStudentName(studentName);
			student.setStudentSex(studentSex);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPhone(studentPhone);
			student.setStudentPwd(studentPwd);
			student.setStudentSign(studentSign);

			StudentServiceImpl studentService = new StudentServiceImpl();
			if(studentService.updateAllById(student))
				request.setAttribute("updateResult","success");
			else
				request.setAttribute("updateResult","failed");
			request.getRequestDispatcher("admin/admin_update_student.jsp").forward(request,response);
			return;
		}


    	String pwd = request.getParameter("pwd");
    	if(pwd != null){
			Faculty faculty = new Faculty();
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String department = request.getParameter("department");

			faculty.setId(id);
			faculty.setDepartment(department);
			faculty.setPwd(pwd);
			faculty.setName(name);

			FacultyServiceImpl facultyService = new FacultyServiceImpl();
			if(facultyService.update(faculty))
				request.setAttribute("updateResult","success");
			else
				request.setAttribute("updateResult","failed");
			request.getRequestDispatcher("admin/admin_update_faculty.jsp").forward(request,response);
			return;
		}

    	String signPicOld = request.getParameter("signPicOld");
    	Sign sign = new Sign();

    	sign.setId(Integer.parseInt(request.getParameter("id")));
    	sign.setSignNumber(request.getParameter("signNumber"));
		sign.setSignName(request.getParameter("signName"));
		sign.setSignSex(request.getParameter("signSex"));
		sign.setSignIdNumber(request.getParameter("signIdNumber"));
		sign.setSignDepartment(request.getParameter("signDepartment"));
		sign.setSignSite(request.getParameter("signSite"));
		sign.setSignRoom(request.getParameter("signRoom"));
		sign.setSignSeat(request.getParameter("signSeat"));
		sign.setSignExamNumber(request.getParameter("signExamNumber"));
		sign.setSignLevel(request.getParameter("signLevel"));
		sign.setSignSubject(request.getParameter("signSubject"));
		sign.setSignPhone(request.getParameter("signPhone"));
		sign.setSignPic(signPicOld);

		String isUpload = request.getParameter("isUpload");

		if(isUpload.equals("T")) {
			delpic(signPicOld);//删除旧照片
			String signPic = upload(request,"signPic");
			sign.setSignPic(signPic);
		}

		SignServiceImpl signService = new SignServiceImpl();

		if(signService.update(sign)) {
			request.getRequestDispatcher("page").forward(request,response);
		}
		else{
			request.getRequestDispatcher("common/error.jsp").forward(request,response);
		}
	}

	public String upload(HttpServletRequest request,String picc){
		String newfilename="";
		try{
			file = request.getPart(picc);
			String header = file.getHeader("content-disposition");
			String filename =((header.split(";")[2]).split("=")[1]).replaceAll("\"", "");
			String extname = filename.substring(filename.lastIndexOf('.')+1);
			int i=(int)((Math.random()*9+1)*100000);
			newfilename = System.currentTimeMillis()+"-"+i+"."+extname;
			String uploadpath = getServletContext().getRealPath("/pic");
		
			file.write(uploadpath+File.separator+newfilename);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "pic/"+newfilename;
	}

	public void delpic(String f){
			String path=getServletContext().getRealPath("/pic");
			String file=f.substring(f.lastIndexOf('/')+1);
			File ff=new File(path+File.separator+file);
			if(ff.exists()) ff.delete();
	}
}
