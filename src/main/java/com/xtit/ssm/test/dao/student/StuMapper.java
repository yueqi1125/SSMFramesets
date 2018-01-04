package com.xtit.ssm.test.dao.student;

import org.springframework.stereotype.Repository;

import com.xtit.ssm.test.entity.StuInfo;

@Repository("stuDao")
public interface StuMapper {

	public StuInfo queryStuInfoByNo(String stu_no);
}
