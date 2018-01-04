package com.xtit.ssm.test.service.student;

import com.xtit.ssm.test.dao.student.StuMapper;
import com.xtit.ssm.test.entity.StuInfo;

public class StuService implements IStuService{

	public StuMapper stuDao;
	
	public StuInfo getStuInfoByNo(String stu_no){
		return stuDao.queryStuInfoByNo(stu_no);
	}

	public void setStuDao(StuMapper stuDao) {
		this.stuDao = stuDao;
	}
	
}
