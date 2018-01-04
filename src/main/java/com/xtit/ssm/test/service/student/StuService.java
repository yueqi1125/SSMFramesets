package com.xtit.ssm.test.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtit.ssm.test.dao.student.StuMapper;
import com.xtit.ssm.test.entity.StuInfo;

@Service
public class StuService implements IStuService{

	@Autowired
	public StuMapper stu;
	
	public StuInfo getStuInfoByNo(String stu_no){
		return stu.queryStuInfoByNo(stu_no);
	}
}
