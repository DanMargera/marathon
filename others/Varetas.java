
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author G710
 */
public class Varetas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int lineCount = 0;
        int pares;
        String[] split;
        while (!(line =  br.readLine()).equals("0")) {
            lineCount = Integer.parseInt(line);
            pares = 0;
            for (int i=0;i<lineCount;i++) {
                line = br.readLine();
                split = line.split(" ");
                pares += Integer.parseInt(split[1])/2;
            }
            System.out.println(pares/2);
        }
    }
}
