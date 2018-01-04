package com.xtit.ssm.test.dao;

import org.springframework.stereotype.Repository;

import com.xtit.ssm.test.entity.StuInfo;

@Repository
public interface StuMapper {

	public StuInfo queryStuInfoByNo(String stu_no);
}
