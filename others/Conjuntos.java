
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author G710
 */
public class Conjuntos {
    
    static final char[] OPERADORES = {'*', '+', '-'};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(parseSentenca(line));
        }
    }
    
    public static String parseSentenca(String line) {
        boolean hasParentesis = false, controle = true;
        String temp = "";
        if (line.contains("(")) {
            temp = parseSentenca(line.substring(0, line.lastIndexOf('('))
                    +parseSentenca(line.substring(line.lastIndexOf('(')+1, line.indexOf(')', line.lastIndexOf('('))))
                    +line.substring(line.indexOf(')')+1, line.length()));
        }
        else {
            temp = line;
            for (int i=0;i<OPERADORES.length;i++) {
                for (int c=0;c<line.length();c++) {
                    if (line.charAt(c) == OPERADORES[i]) {
                        temp = operacao(i, temp);
                    }
                }
            }
        }
        return temp;
    }
    
    public static String operacao(int op, String expressao) {
        int index = expressao.indexOf(OPERADORES[op]);
        boolean achouChave = false;
        int i = 0;
        while (!achouChave) {
            i++;
            if (expressao.charAt(index-i) == '{') {
                achouChave = true;
            }
        }
        int j = expressao.indexOf('}', index);
        String sub1 = expressao.substring(index-i+1, index-1);
        String sub2 = expressao.substring(index+2, j);
        String temp = "";
        switch (op) {
            case 0:
                temp = intersecao(sub1, sub2);
                break;
            case 1:
                temp = uniao(sub1, sub2);
                break;
            case 2:
                temp = subtracao(sub1, sub2);
                break;
        }
        return expressao.substring(0, index-i+1)
                +temp
                +expressao.substring(j, expressao.length());
    }
    
    
    public static String uniao(String a, String b) {
        StringBuilder strB = new StringBuilder();
        strB.append(a);
        for (int i=0;i<b.length();i++) {
            if (!a.contains(""+b.charAt(i))) {
                strB.append(b.charAt(i));
            }
        }
        return strB.toString();
    }
    
    public static String intersecao(String a, String b) {
        StringBuilder strB = new StringBuilder();
        for (int i=0;i<b.length();i++) {
            if (a.contains(""+b.charAt(i))) {
                strB.append(b.charAt(i));
            }
        }
        return strB.toString();
    }
    
    public static String subtracao(String a, String b) {
        String resp = a;
        for (int i=0;i<b.length();i++) {
            resp = resp.replaceFirst(""+b.charAt(i), "");
        }
        return resp;
    }
}
