package com.lxd.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxd.crud.bean.Department;
import com.lxd.crud.bean.Msg;
import com.lxd.crud.service.DeparmentServidce;

/**
 * 处理与部门有关的请求
 * @author lilua
 *
 */
@Controller
public class DepartmentController {
	
	@Autowired
	private DeparmentServidce departmentService;
	/**
	 * 返回所有的部门信息
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts() {
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}

}
