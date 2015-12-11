package com.postalong.modle.bean;

/**
 * Created by heshaokang on 2015/12/11.
 */
public class Student {

    private String name;

    private Course[] course;

    public Student(String name,Course[] course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    public Course[] getCourse() {

        return course;
    }

    public void setCourse(Course[] course) {
        this.course = course;
    }


}
