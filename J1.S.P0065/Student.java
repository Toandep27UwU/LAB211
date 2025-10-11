/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg65;

/**
 *
 * @author DELL
 */
public class Student {
    private String studentName;
    private String className;
    private double math;
    private double physics;
    private double chemistry;
    private double average;
    private String type;

    public Student(String studentName, String className, double math, double physics, double chemistry) {
        this.studentName = studentName;
        this.className = className;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s %-10s Math: %.1f Physics: %.1f Chemistry: %.1f Average: %.2f Type: %s",
                studentName, className, math, physics, chemistry, average, type);
    }
}
