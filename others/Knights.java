
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * Autores: Daniel Terenzi Carvalho e Bruno Soares Chien.
 */

public class Knights {
    static final int STRING_SIZE = 25;
    static int moves = 0, bestDistance = 99;
    static int[] corners = {3,4,9,15,20,21};
    static int[] jumps = {-11, -9, -7, -3, 3, 7, 9, 11};
    static String solved = "111110111100 110000100000";
    
    static int distance(char[] s) {
        int dist = 0;
        for (int i=0;i<STRING_SIZE;i++) {
            if (solved.charAt(i) != s[i]) {
                dist++;
            }
        }
        for (int i=0;i<corners.length/2;i++) {
            if (s[corners[i]] == '0') {
                dist++;
            }
            if (s[corners[corners.length-i-1]] == '1') {
                dist++;
            }
        }
        return dist;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String input = in.readLine();
        
        int cases = Integer.parseInt(input);
        
        for (int i=0;i<cases;i++) {
            StringBuilder sb = new StringBuilder();
            for (int k=0;k<5;k++) {
                sb.append(in.readLine());
            }
            int dist = check(sb.toString());
            if (dist>=0) {
                System.out.println("Solvable in " + dist + " move(s).");
            } else {
                System.out.println("Unsolvable in less than 11 move(s).");
            }
        }
    }
    
    static int check(String s) {
        bestDistance = distance(s.toCharArray());
        
        if (bestDistance>10) {
            return -1;
        }
        
        int blankPos = s.indexOf(' ');
        
        return search(s.toCharArray(), blankPos);
        
    }
    
    static int search(char[] s, int bpos) {
        for (int i=0;i<jumps.length;i++) {
            if (bpos+jumps[i] >= 0 && bpos+jumps[i]<STRING_SIZE) {
                char temp;
                temp = s[bpos];
                s[bpos] = s[bpos+jumps[i]];
                s[bpos+jumps[i]] = temp;
                int dist = distance(s);
                moves++;
                if (dist == 0) {
                    return moves;
                }
                else if (dist<=bestDistance && moves<11) {
                    bestDistance = dist;
                    return search(s, bpos+jumps[i]);
                }
                temp = s[bpos];
                s[bpos] = s[bpos+jumps[i]];
                s[bpos+jumps[i]] = temp;
                moves--;
            }
        }
        return -1;
    }
    
    
    
}
