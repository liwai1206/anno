package com.yc.anno.test;

import java.util.Objects;

/**
 *  定义一些合适的注解，实现根据实体类在数据库mysql中自动创建对应的表
 * @author 外哥
 * @Description:
 * @email : liwai2012220663@163.com
 * @date 2021/1/16 9:47
 */
@Table
public class Student {

    @Type(type = "int" , constraints = @Constraints(primaryKey = true ,autoIncrement = true))
    private int sid;

    @Type(type = "varchar(100)" , constraints = @Constraints( allowNull = false))
    private String sname ;

    @Type(type = "int")
    private int age ;

    @Type(constraints = @Constraints(unique = true))
    private String tel ;

    @Type(type = "varchar(200)")
    private String addr ;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sid == student.sid &&
                age == student.age &&
                sname.equals(student.sname) &&
                tel.equals(student.tel) &&
                addr.equals(student.addr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, age, tel, addr);
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Student() {
    }

    public Student(int sid, String sname, int age, String tel, String addr) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.tel = tel;
        this.addr = addr;
    }
}
