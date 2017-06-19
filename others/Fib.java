/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author G710
 */
public class Fib {
    
    public static void main(String[] args) {
        for (int i=0;i<50;i++) {
            for (int j=0;j<8;j++) {
                long fib = fib(i);
                long pow = (long)Math.pow(2, j);
                System.out.println("i: "+i+"  j: "+j+"   "+fib+"   "+fib%pow);
            }
        }
    }
    
    static long fib(int n) {
        long vec[] = {0, 1};
        long temp = 0;
        
        if (n<2) {
            temp = vec[n];
        }
        
        for (int i=0;i<n-1;i++) {
            temp = vec[0] + vec[1];
            vec[0] = vec[1];
            vec[1] = temp;
        }
        
        return temp;
    }
}
