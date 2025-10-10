/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg71;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 *
 * @author DELL
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    public static String checkInput(){
        while (true){
            String input =sc.nextLine().trim();
            if (!input.isEmpty()){
                return input;
            } 
            System.out.println("Invalid String!!!");
            System.out.print("Enter again: ");
        }
    }
    
    public static String checkInputDate(){
        while (true){
            String input = checkInput();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            format.setLenient(false); 
            try {
                Date date = format.parse(input);
                //String result = String.of(date);
                return format.format(date);
            } catch (ParseException e){
                System.out.println("Date format error: ");
            }
        }
    }
    
    
    
    public static Double checkTimeFormat(){
        String format = "^(?:8|9|1[0-6]|17)\\.(?:0|5)$";
        while (true) {
            String input = checkInput();
            if (input.matches(format)){
                double result = Double.parseDouble(input);
                return result;
            }
            System.out.println("Invalid time");
        }    
    }
    
    public static double[] checkTimeValid(){
        while (true){
            System.out.print("From: ");
            double fromTime = checkTimeFormat();
            System.out.print("To: ");
            double toTime = checkTimeFormat();
            if (fromTime - toTime < 0 && toTime - fromTime <= 8){
                return new double[]{fromTime, toTime};
            } else {
                System.out.println("Invalid time (From < To and time > 8)");
            }
        }
    }
    
       
    public static int checkInt(int max, int min){   // limit
        while (true){
            String input = checkInput();
            try {
                int result = Integer.parseInt(input);
                if (result < min || result > max){
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e){
                System.out.println("Invalid number");
            }
        }
    }
    
}
