package entity;

import java.sql.Date;

public class rewardandpenalty {
	private Date time;
	private String sequencenum;
	private String sign;
	private String project;
	private String money;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getSequencenum() {
		return sequencenum;
	}
	public void setSequencenum(String sequencenum) {
		this.sequencenum = sequencenum;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
}
