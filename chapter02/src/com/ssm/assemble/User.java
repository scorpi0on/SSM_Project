package com.ssm.assemble;

import java.util.List;

public class User {
    private String userName;
    private String passWord;
    private List<String> list;

    //1.提供参数构造方法
    public User(String userName, String passWord, List<String> list){
        super();
        this.userName = userName;
        this.passWord = passWord;
        this.list = list;

    }
    //2.提供值注入方法
    @Override
    public String toString() {
        return "User [userName=" + userName + ", passWord=" + passWord + ", list = " + list + "]";
    }
    //条件2.1：默认无参数构造方法
    public User(){
        super();
    }
    //条件2.2：注入属性的setter方法
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
