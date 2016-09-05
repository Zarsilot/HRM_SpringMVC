package com.icss.dao;

import java.util.List;

import javax.annotation.Resource;

import com.icss.model.EmpData;

@Resource
public interface IEmpDataDao {
	public List<EmpData> getAnalyzeData();
}
