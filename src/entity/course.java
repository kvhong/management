package entity;

import java.sql.Date;

public class course {
	private String coursenum;
	private String coursename;
	private String material;
	private String studytime;
	private Date time;
	private String score;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getCoursenum() {
		return coursenum;
	}
	public void setCoursenum(String coursenum) {
		this.coursenum = coursenum;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getStudytime() {
		return studytime;
	}
	public void setStudytime(String studytime) {
		this.studytime = studytime;
	}
}
