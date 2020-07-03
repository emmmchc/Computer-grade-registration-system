package servlet;

import entity.Sign;
import service.impl.SignServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@MultipartConfig
@WebServlet(name = "SignServlet",urlPatterns = {"/Sign"})
public class SignServlet extends HttpServlet {

	Part file = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String signNumber = req.getParameter("signNumber");
		String signName = req.getParameter("signName");
		String signSex = req.getParameter("signSex");
		String signIdNumber = req.getParameter("signIdNumber");
		String signDepartment = req.getParameter("signDepartment");
		String signSite = req.getParameter("signSite");
		String signLevel = req.getParameter("signLevel");
		String signSubject = req.getParameter("signSubject");
		String signPhone = req.getParameter("signPhone");


		//生成准考证号
		SignServiceImpl signService = new SignServiceImpl();
		int  sum = signService.selectLastId()+1;
		String signRoom;
		String signSeat;
		String signExamNumber;
		if(sum != 1){
			signRoom = String.format("%03d", sum/30 + 1);

			if(sum%30==0)
				signSeat = String.format("%03d", 30);
			else
				signSeat = String.format("%03d", sum%30);

			if(signSite.equals("东校区"))
				signExamNumber = "101"+signRoom+signSeat;
			else
				signExamNumber = "102"+signRoom+signSeat;
		}
		else{
			signRoom = "001";
			signSeat = "001";
			if(signSite.equals("东校区"))
				signExamNumber = "101"+signRoom+signSeat;
			else
				signExamNumber = "102"+signRoom+signSeat;
		}

		String signPic = upload(req);
		Sign sign = new Sign();
		Sign signRes = signService.select(signNumber);

		if (signRes.getSignNumber() == null) {
			sign.setSignNumber(signNumber);
			sign.setSignName(signName);
			sign.setSignSex(signSex);
			sign.setSignIdNumber(signIdNumber);
			sign.setSignDepartment(signDepartment);
			sign.setSignSite(signSite);
			sign.setSignRoom(signRoom);
			sign.setSignSeat(signSeat);
			sign.setSignExamNumber(signExamNumber);
			sign.setSignLevel(signLevel);
			sign.setSignSubject(signSubject);
			sign.setSignPhone(signPhone);
			sign.setSignPic(signPic);

			if (signService.insert(sign)) {
				//报名成功
				StudentServiceImpl studentService = new StudentServiceImpl();
				studentService.updateSign("已报名",signNumber);
				req.getRequestDispatcher("./PrintSign").forward(req,resp);
				return;
			} else {
				//报名失败，未知错误
				req.setAttribute("signReslut", "unknownError");
			}
		} else {
			//学号已存在
			req.setAttribute("signReslut", "nameExit");
		}
		req.getRequestDispatcher("student/sign.jsp").forward(req,resp);
	}

	public String upload(HttpServletRequest request) {
		String newfilename = "";
		try {
			this.file = request.getPart("signPic");
			String filename = this.file.getHeader("content-disposition").split(";")[2].split("=")[1].replaceAll("\"", "");
			newfilename = System.currentTimeMillis() + "-" + ((int) (((Math.random() * 9.0d) + 1.0d) * 100000.0d)) + "." + filename.substring(filename.lastIndexOf(46) + 1);
			this.file.write(new StringBuilder(String.valueOf(getServletContext().getRealPath("/pic"))).append(File.separator).append(newfilename).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pic/" + newfilename;
	}
}
