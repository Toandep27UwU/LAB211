/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg65;
import java.util.*;
/**
 *
 * @author DELL
 */
public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();
     
    public static ArrayList<Student> averageStudent(ArrayList<Student> students) {
        for (Student student : students) {
            double avg = (student.getMath() + student.getPhysics() + student.getChemistry()) / 3.0;
            student.setAverage(avg);
            String type;
            if (avg > 7.5) {
                type = "A";
            } else if (avg >= 6.0) {
                type = "B";
            } else if (avg >= 4.0) {
                type = "C";
            } else {
                type = "D";
            }
            student.setType(type);
        }
        return students;
    }
    
    public static HashMap<String, Double> getPercentTypeStudent(ArrayList<Student> students) {
        HashMap<String, Double> percentMap = new HashMap<>(); 
        if (students.isEmpty()) {
            percentMap.put("A", 0.0);
            percentMap.put("B", 0.0);
            percentMap.put("C", 0.0);
            percentMap.put("D", 0.0);
            return percentMap;
        }

        int countA = 0, countB = 0, countC = 0, countD = 0;
        for (Student student : students) {
            switch (student.getType()) {
                case "A": countA++; break;
                case "B": countB++; break;
                case "C": countC++; break;
                case "D": countD++; break;
            }
        }
        
        int total = students.size();
        percentMap.put("A", (countA * 100.0) / total);
        percentMap.put("B", (countB * 100.0) / total);
        percentMap.put("C", (countC * 100.0) / total);
        percentMap.put("D", (countD * 100.0) / total);
        
        return percentMap;
    }
    
    public static void inputStudents() {
        System.out.println("=====  STUDENT MANAGEMENT PROGRAM =====");  
        while (true) {
            System.out.println("\n----- Enter Student Information -----");
            System.out.print("Enter student name: ");
            String name = Validation.checkInput();            
            System.out.print("Enter class name: ");
            String className = Validation.checkInput();          
            System.out.print("Enter Math mark (1-10): ");
            double math = Validation.checkDouble(1, 10);
            System.out.print("Enter Physics mark (1-10): ");
            double physics = Validation.checkDouble(1, 10);
            System.out.print("Enter Chemistry mark (1-10): ");
            double chemistry = Validation.checkDouble(1, 10);
            Student student = new Student(name, className, math, physics, chemistry);
            students.add(student);       
            System.out.println("Student added successfully!");       
            System.out.print("Do you want to add more students? (Y/N): ");
            boolean continueInput = Validation.checkYN();
            if (!continueInput) {
                break;
            }
        }
    }

    public static void processAndDisplay() {
        students = averageStudent(students);
        System.out.println("\n========== STUDENT CLASSIFICATION RESULTS ==========");
        for (Student student : students) {
            System.out.println(student);
        }
        HashMap<String, Double> percentMap = getPercentTypeStudent(students);
        System.out.println("\n========== STUDENT TYPE STATISTICS ==========");
        System.out.printf("A: %.2f%%\n", percentMap.get("A"));
        System.out.printf("B: %.2f%%\n", percentMap.get("B"));
        System.out.printf("C: %.2f%%\n", percentMap.get("C"));
        System.out.printf("D: %.2f%%\n", percentMap.get("D"));
    }
}

