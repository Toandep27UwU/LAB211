/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg71;
import java.util.*;
/**
 *
 * @author DELL
 */
public class TaskManager {
    private static ArrayList<Task> taskList = new ArrayList<>();
    
    public static void option(){
        int id = 1;
        while (true){
            int choice;
            System.out.println("======= Task program =======");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("Enter choice: ");
            choice = Validation.checkInt(4,1);
            switch (choice){
                case 1:
                    addTask(taskList, id);
                    id++;
                    break;
                case 2:
                    deleteTask(taskList);
                    id--;
                    break;
                case 3: 
                    getDataTasks(taskList);
                    break;
                case 4:
                    System.out.print("Exit....");
                    return;
            }
        }
    }
    
    
    private static void addTask(ArrayList<Task> taskList, int id){
        System.out.println("-------Add Task-------");
        System.out.print("Requirement Name: ");
        String requirementName = Validation.checkInput();
        System.out.print("Task Type: ");
        int taskType = Validation.checkInt(4,1);   // TaskType
        System.out.print("Date: ");
        String date = Validation.checkInputDate();
        //double[] time = new double[2];
        double[] time = Validation.checkTimeValid();
        double planFrom = time[0];
        double planTo = time[1];
        double taskDuration = planTo - planFrom;
        //System.out.println("Assignee: ");
        String assignee = checkAssigneeHours(taskList, date, taskDuration);
        System.out.println("Reviewer: ");
        String reviewer = Validation.checkInput();
        Task task = new Task(id,taskType, requirementName, date, planFrom,  planTo, assignee, reviewer);
        taskList.add(task);
    }
    
    private static void deleteTask(ArrayList<Task> taskList){  
        int findID = Validation.checkInt(Integer.MAX_VALUE,1);
        if (taskList.isEmpty()){
            System.out.println("None information");           
        } else {
            for (Task task : taskList){
                if (task.getId()==findID){
                    taskList.remove(task);
                    for (int i = 0; i<taskList.size(); i++){
                        taskList.get(i).setId(i+1);
                    }
                    return;
                }
            }
        }  
    }
    
    private static void getDataTasks(ArrayList<Task> taskList){
        System.out.println("---------------------Task------------------\n");
        for (Task task : taskList){
            task.print();
        }
    }
    
    private static String checkAssigneeHours(ArrayList<Task> taskList, String date, double taskDuration) {
        while (true) {
            System.out.println("Assignee: ");
            String assignee = Validation.checkInput();
            double totalHours = getTotalHoursForAssigneeOnDate(assignee, date, taskList) + taskDuration;
            if (totalHours <= 8) {
                return assignee; 
            } else {
                System.out.println("Error: Total working hours for " + assignee + " on " + date + " exceeds 8 hours. Please choose another assignee.");
            }
        }
    }
    
    private static double getTotalHoursForAssigneeOnDate(String assignee, String date, ArrayList<Task> taskList) {
        double totalHours = 0.0;
        for (Task task : taskList){
            if (task.getAssignee().equalsIgnoreCase(assignee) && task.getDate().equalsIgnoreCase(date)){
                totalHours += task.getPlanTo() - task.getPlanFrom();
            }
        }
        return totalHours;
    }
}
