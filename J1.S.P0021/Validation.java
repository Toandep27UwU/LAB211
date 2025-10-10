/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg21_duc;
import java.util.*;
/**
 *
 * @author DELL
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    public static String checkInput(){
        while (true){
            String input = sc.nextLine().trim();
            if (!input.isEmpty()){
                return input;
            }
            System.out.println("Empty input!!!");
        }
    }
    
    public static int checkInt(int min, int max){
        while (true){
            String input = checkInput();
            try {
                int result = Integer.parseInt(input);
                if (result >= min && result <= max){
                    return result;
                } else {
                    System.out.println("Invalid integer!!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer!!!");
            }
        }
    }
    
    public static String checkCourseName(){
        while (true){
            String input = checkInput();
            if (input.equalsIgnoreCase("java") || input.equalsIgnoreCase(".net") || input.equalsIgnoreCase("c/c++")){
                return input;
            }
            else {
                System.out.println("Invalid course name!!!");
            }
        }
    }
    
    public static boolean checkYN(){
        while (true){
            String input = checkInput();
            if (input.equalsIgnoreCase("Y")){
                return true;
            }
            if (input.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("Invalid input!!!");
        }
    }
    
    public static boolean checkUD(){
        while (true){
            String input = checkInput();
            if (input.equalsIgnoreCase("U")){
                return true;
            }
            if (input.equalsIgnoreCase("D")){
                return false;
            }
            System.out.println("Invalid input!!!");
        }
    }
    
    public static boolean checkDuplicatedStudent(ArrayList<Student> studentList, String id, String name, int semester, String courseName){
        boolean check = true;
        for (Student student : studentList){
            if (student.getId().equalsIgnoreCase(id) && student.getName().equalsIgnoreCase(name) && student.getSemester() == semester && student.getCourseName().equalsIgnoreCase(courseName)){
                check = false;
                break;
            }
        }
        return check;
    }
}
