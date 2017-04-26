package com.gsafety.po;

import java.io.Serializable;

/**
 * @author xiaodh
 * users表所对应的实体类
 */
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2018829718521080357L;
	//实体类的属性和表的字段名称一一对应
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
