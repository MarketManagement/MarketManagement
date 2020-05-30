package com.example.demo.pojo;


import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data

@NoArgsConstructor
public class Employee {
    private  Integer id;  //主键
    private  String  Loginname; //登录名
    private  String  password;  //密码
    private  Integer status;   //权限状态 1管理员 2用户
    private  String  Username; //用户名
    private  Date    Createdate; //创建时间
    public Employee(Integer id, String loginname, String password, Integer status, String username) {
        this.id = id;
        Loginname = loginname;
        this.password = password;
        this.status = status;
        Username = username;
        Createdate =new Date();
    }
}
