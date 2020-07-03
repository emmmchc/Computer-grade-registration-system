package entity;

public class Sign {
	private int id;
	//学号
	private String signNumber;
	//姓名
	private String signName;
	//性别
	private String signSex;
	//身份证号
	private String signIdNumber;
	//院系
	private String signDepartment;
	//考试地点
	private String signSite;
	//考场
	private String signRoom;
	//座位
	private String signSeat;
	//准考证号
	private String signExamNumber;
	//考试等级
	private String signLevel;
	//考试科目
	private String signSubject;
	//电话
	private String signPhone;
	//照片
	private String signPic;

	public Sign() {
	}

	public Sign(int id, String signNumber, String signName, String signSex, String signIdNumber, String signDepartment, String signSite, String signRoom, String signSeat, String signExamNumber, String signLevel, String signSubject, String signPhone, String signPic) {
		this.id = id;
		this.signNumber = signNumber;
		this.signName = signName;
		this.signSex = signSex;
		this.signIdNumber = signIdNumber;
		this.signDepartment = signDepartment;
		this.signSite = signSite;
		this.signRoom = signRoom;
		this.signSeat = signSeat;
		this.signExamNumber = signExamNumber;
		this.signLevel = signLevel;
		this.signSubject = signSubject;
		this.signPhone = signPhone;
		this.signPic = signPic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSignNumber() {
		return signNumber;
	}

	public void setSignNumber(String signNumber) {
		this.signNumber = signNumber;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getSignSex() {
		return signSex;
	}

	public void setSignSex(String signSex) {
		this.signSex = signSex;
	}

	public String getSignIdNumber() {
		return signIdNumber;
	}

	public void setSignIdNumber(String signIdNumber) {
		this.signIdNumber = signIdNumber;
	}

	public String getSignDepartment() {
		return signDepartment;
	}

	public void setSignDepartment(String signDepartment) {
		this.signDepartment = signDepartment;
	}

	public String getSignSite() {
		return signSite;
	}

	public void setSignSite(String signSite) {
		this.signSite = signSite;
	}

	public String getSignRoom() {
		return signRoom;
	}

	public void setSignRoom(String signRoom) {
		this.signRoom = signRoom;
	}

	public String getSignSeat() {
		return signSeat;
	}

	public void setSignSeat(String signSeat) {
		this.signSeat = signSeat;
	}

	public String getSignExamNumber() {
		return signExamNumber;
	}

	public void setSignExamNumber(String signExamNumber) {
		this.signExamNumber = signExamNumber;
	}

	public String getSignLevel() {
		return signLevel;
	}

	public void setSignLevel(String signLevel) {
		this.signLevel = signLevel;
	}

	public String getSignSubject() {
		return signSubject;
	}

	public void setSignSubject(String signSubject) {
		this.signSubject = signSubject;
	}

	public String getSignPhone() {
		return signPhone;
	}

	public void setSignPhone(String signPhone) {
		this.signPhone = signPhone;
	}

	public String getSignPic() {
		return signPic;
	}

	public void setSignPic(String signPic) {
		this.signPic = signPic;
	}
}
