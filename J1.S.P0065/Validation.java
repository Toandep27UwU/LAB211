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
    
    public static double checkDouble(double min, double max){
        while (true){
            String input = checkInput();
            try {
                double result = Double.parseDouble(input);
                if (result >= min && result <= max){
                    return result;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid double!!!");
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
    
}
