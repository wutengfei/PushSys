package pushsystem;

public class PlanBean {

	private int id;
	private String user;
	private String week;
	private String time;
	private String content;
	private String remark;
	
	
	public PlanBean(String user, String week, String time, String content, String remark) {
		super();
		this.user = user;
		this.week = week;
		this.time = time;
		this.content = content;
		this.remark = remark;
	}
	public PlanBean(int id, String user, String week, String time, String content, String remark) {
		super();
		this.id = id;
		this.user = user;
		this.week = week;
		this.time = time;
		this.content = content;
		this.remark = remark;
	}
	public PlanBean() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
