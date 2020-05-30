package com.example.demo.dao;

import com.example.demo.pojo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
//模拟员工
public class EmployeeDao {
    //模拟数据库数据
    private  static Map<Integer, Employee> employees=null;

    static {
        employees=new HashMap<Integer, Employee>();//创建一个部门表
        employees.put(101,new Employee(101,"123","123456",2,"zhangjie"));
        employees.put(102,new Employee(102,"1234", "25869",2,"zhuli"));
        employees.put(103,new Employee(103,"146","1583 ",  2,"mahua"));
        employees.put(104,new Employee(104,"zhou","15895", 2,"lihahe"));
        employees.put(105,new Employee(105,"10086","10086",1,"zhuqizhao"));

    }
    //主键自增
    private  static  Integer initid =106;
    //增加
    public  void add(Employee employee)
    {
        if(employee.getId()==null)
        {
            employee.setId(initid++);
        }
         employees.put(employee.getId(),employee);
    }
    //查询全体
    public Collection<Employee> getAll()
    {
        return employees.values();
    }
    //通过id查询
    public  Employee getEmployeeByid(Integer id)
    {
        return employees.get(id);
    }
    //删除
    public  void delete(Integer id)
    {
        employees.remove(id);
    }
}
