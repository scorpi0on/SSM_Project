package com.ssm.po;

import java.util.List;

public class Banji {
    private Integer id;
    private String name;
    private List<Student> studentList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Banji [id =" + id + ", name =" + name + ", studentList =" + studentList + "]";
    }
}
