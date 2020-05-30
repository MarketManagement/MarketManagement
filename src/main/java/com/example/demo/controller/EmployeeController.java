package com.example.demo.controller;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @RequestMapping("/emps")
    public String list(Model model)
    {
        Collection<Employee>employees=employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public  String toAddpage(Model model)
    {

        return "emp/add";
    }
    @PostMapping("/emp")
    public  String addEmp(Employee employee)
    {     //添加操作
        employeeDao.add(employee); //调用底层业务方法保存员工
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    //去修改页面
    public String toupdateEmp(@PathVariable("id")Integer id ,Model model)
    {
        Employee employee=employeeDao.getEmployeeByid(id);
        model.addAttribute("emp",employee);


        return "emp/update";
    }
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee)
    {
        employeeDao.add(employee);
        return "redirect:/emps";
    }
    //删除
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")int id)
    {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
