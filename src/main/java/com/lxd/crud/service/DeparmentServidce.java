package com.lxd.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxd.crud.bean.Department;
import com.lxd.crud.dao.DepartmentMapper;
@Service//业务逻辑组件
public class DeparmentServidce {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<Department> getDepts() {
		// TODO Auto-generated method stub
		List<Department> list = departmentMapper.selectByExample(null);
		
		return list;
	}

}
