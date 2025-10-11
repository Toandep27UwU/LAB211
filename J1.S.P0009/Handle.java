/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg9;

/**
 *
 * @author DELL
 */
public class Handle {
    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void displayFibonacci(int n) {
        System.out.printf("The %d Fibonacci numbers:\n",n);
        for (int i = 0; i < n; i++) {
            long fibNumber = fibonacci(i);
            System.out.print(fibNumber + ", ");
        }
        System.out.println(); 
    }
}
