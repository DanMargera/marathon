import java.io.*;

class Dollar {
    
    int[] notas = {5, 10, 20, 50, 100, 200, 500, 1000, 5000, 10000};
    
    int[] resp = new int[5001];
    
    static String ReadLn (int maxLg) {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";
        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }
    
    public static void main(String[] args) {
        Dollar main = new Dollar();
        main.corpo();
    }
    
    void corpo() {
        String input;
        
        resp[0] = 1;
        for (int i=0;i<notas.length;i++) {
            for (int j=notas[i];j<resp.length;j++) {
                resp[j] += resp[j-notas[i]];
            }
        }

        while ((input = Dollar.ReadLn (255)) != null) {
            findCombinations(input, Double.parseDouble(input));
        }
    }
    
    void findCombinations(String amt, double amount) {
        int dinheiro = (int)(amount*100);
        System.out.println(amt+"    "+resp[dinheiro]);
    }
}