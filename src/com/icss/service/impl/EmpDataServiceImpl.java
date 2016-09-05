package com.icss.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.icss.dao.IEmpDataDao;
import com.icss.model.EmpData;
import com.icss.service.IEmpDataService;
@Service("empDataService")
public class EmpDataServiceImpl implements IEmpDataService {

	@Resource
	private IEmpDataDao empDataDao;
	
	@Override
	public List<EmpData> getAnalyzeData() {
		// TODO Auto-generated method stub
		return empDataDao.getAnalyzeData();
	}

}
