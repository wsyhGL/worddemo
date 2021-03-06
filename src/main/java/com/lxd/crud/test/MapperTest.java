package com.lxd.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lxd.crud.bean.Department;
import com.lxd.crud.bean.Employee;
import com.lxd.crud.dao.DepartmentMapper;
import com.lxd.crud.dao.EmployeeMapper;

/**
 * 测试dao层的工作
 * 推荐使用Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 导入SpringTest模块
 * @ContextConfiguration指定Spring配置文件的位置
 * @author lilua
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	@Test
	public void testCRUD() {
		
/*		System.out.println(departmentMapper);
		departmentMapper.insertSelective(new Department(null,"开发部"));
		departmentMapper.insertSelective(new Department(null,"测试部"));*/
		
		//2.生成员工信息
		//employeeMapper.insertSelective(new Employee(null,"GUU","M","GUU@lxd.com",1));
		//3.批量插入多个员工，批量，使用可以执行批量操作的sqlSession
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@lxd.com",1));
			
		}
		System.out.println("批量完成");
	}

}
