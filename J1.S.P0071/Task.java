/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg71;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Task {
    private int id;
    private int tasktypeID;
    private String requirementName;
    private String Date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String expert;

    public Task() {
    }

    public Task(int id, int tasktypeID, String requirementName, String Date, double planFrom, double planTo, String assignee, String expert) {
        this.id = id;
        this.tasktypeID = tasktypeID;
        this.requirementName = requirementName;
        this.Date = Date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.expert = expert;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTasktypeID() {
        return tasktypeID;
    }

    public void setTasktypeID(int tasktypeID) {
        this.tasktypeID = tasktypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    
    public void print() {
        System.out.printf("%-5d %-20s %-20s %-15s %-10.2f %-15s %-15s\n",id,requirementName, taskChoice.choice(tasktypeID), Date, planTo-planFrom, assignee, expert);
    }
    
    
}
