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
 * ����dao��Ĺ���
 * �Ƽ�ʹ��Spring����Ŀ�Ϳ���ʹ��Spring�ĵ�Ԫ���ԣ������Զ�ע��������Ҫ�����
 * ����SpringTestģ��
 * @ContextConfigurationָ��Spring�����ļ���λ��
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
		departmentMapper.insertSelective(new Department(null,"������"));
		departmentMapper.insertSelective(new Department(null,"���Բ�"));*/
		
		//2.����Ա����Ϣ
		//employeeMapper.insertSelective(new Employee(null,"GUU","M","GUU@lxd.com",1));
		//3.����������Ա����������ʹ�ÿ���ִ������������sqlSession
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@lxd.com",1));
			
		}
		System.out.println("�������");
	}

}
