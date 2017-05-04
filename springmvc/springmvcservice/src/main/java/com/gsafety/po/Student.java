package com.gsafety.po;

import java.beans.Transient;
import java.io.Serializable;
/**
 * 验证序列化和反序列化的问题
 * @author xiaodh
 * 2017年5月4日 下午5:04:24
 */
public class Student implements Serializable {
	public void setSname(String sname) {
		Sname = sname;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private static final long serialVersionUID = -9155244872283801827L;
	private String Sname;
    private String Sex;
  
    private int age;
    public Student() {
        // TODO 自动生成的构造函数存根
    }
    public Student(String Sname,String Sex,int age){
        this.Sname=Sname;
        this.Sex=Sex;
        this.age=age;
    }
    public String getSname() {
        return Sname;
    }
    public String getSex() {
        return Sex;
    }
    @Transient
    public int getAge() {
        return age;
    }
}
