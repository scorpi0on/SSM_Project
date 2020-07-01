package com.ssm.po;

import java.util.List;

public class Course {
    private Integer id;
    private String name;
    private String code;
    private List<Student> studentsList;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public String toString() {
        return "Course [id =" + id + ", name =" + name + ", code =" + code + ", studentsList" + studentsList + "]";
    }
}
