/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg21_duc;

/**
 *
 * @author DELL
 */
public class Student {
    private String id;
    private String name;
    private int semester;
    private String courseName;

    public Student() {
    }

    public Student(String id, String name, int semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public void print(){
        System.out.printf("%-15s %-15s %-5d %-10s\n",id,name,semester,courseName);
    }
}            