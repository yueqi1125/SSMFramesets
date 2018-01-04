package com.xtit.ssm.test.entity;

import java.io.Serializable;

public class StuInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String stu_no;
	
	private String stu_Name;
	
	private String stu_coll;
	
	private String stu_tel;
	
	private int stu_age;

	public String getStu_no() {
		return stu_no;
	}

	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}

	public String getStu_Name() {
		return stu_Name;
	}

	public void setStu_Name(String stu_Name) {
		this.stu_Name = stu_Name;
	}

	public String getStu_coll() {
		return stu_coll;
	}

	public void setStu_coll(String stu_coll) {
		this.stu_coll = stu_coll;
	}

	public String getStu_tel() {
		return stu_tel;
	}

	public void setStu_tel(String stu_tel) {
		this.stu_tel = stu_tel;
	}

	public int getStu_age() {
		return stu_age;
	}

	public void setStu_age(int stu_age) {
		this.stu_age = stu_age;
	}

	@Override
	public String toString() {
		return "StuInfo [stu_no=" + stu_no + ", stu_Name=" + stu_Name + ", stu_coll=" + stu_coll + ", stu_tel="
				+ stu_tel + ", stu_age=" + stu_age + "]";
	}
	
}
