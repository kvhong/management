package entity;

import java.sql.Date;

public class skill {
	private String skillnum;
	private String skillname;
	private String skillgrade;
	private Date time;
	private String place;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getSkillnum() {
		return skillnum;
	}
	public void setSkillnum(String skillnum) {
		this.skillnum = skillnum;
	}
	public String getSkillname() {
		return skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	public String getSkillgrade() {
		return skillgrade;
	}
	public void setSkillgrade(String skillgrade) {
		this.skillgrade = skillgrade;
	}
}
