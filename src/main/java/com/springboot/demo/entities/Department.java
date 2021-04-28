package com.springboot.demo.entities;

public class Department {
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    private  Integer id;
    private String departmentName;

    public Department(){}

    public  Department(int i, String string){
        this.id = i;
        this.departmentName = string;
    }


}
