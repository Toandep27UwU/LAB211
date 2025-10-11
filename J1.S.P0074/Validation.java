/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg74;
import java.util.*;
/**
 *
 * @author DELL
 */
public class Validation {
    private static Scanner sc = new Scanner (System.in);
    
    public static int checkIntLimit(int max, int min){
        while (true){
            try{
                int num = Integer.parseInt(sc.nextLine());
                if (num > max || num < min){
                    throw new NumberFormatException();
                }
                return num;
            } catch (NumberFormatException e){
                System.out.println("Invalid number");
                System.out.print("Re-try: ");
            }
        }
    }
}
