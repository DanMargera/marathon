
import java.io.IOException;

/*
 * Daniel Terenzi Carvalho
 */

public class Faces {
    
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
        Faces main = new Faces();
        main.corpo();
    }
    
    void corpo() {
        String input;
        String VE[];
        int group[];
        int s1, s2;
        int vertexCount[];
        int edgeCount[];
        int currentComponent;
        
        while ((input = Faces.ReadLn (255)) != null) {
            VE = input.split(" ");
            int edges = Integer.parseInt(VE[1]);
            vertexCount = new int[256];
            edgeCount = new int[256];
            group = new int[256];
            currentComponent = 0;
            
            for (int i=0;i<edges;i++) {
                input = Faces.ReadLn(255);
                s1 = input.charAt(0);
                s2 = input.charAt(2);
                
                if (group[s1] == group[s2]) {
                    if (group[s1] == 0) {
                        currentComponent++;
                        group[s1] = currentComponent;
                        group[s2] = currentComponent;
                        vertexCount[currentComponent] += s1==s2?1:2;
                    }
                    edgeCount[group[s1]]++;
                }
                else {
                    if (group[s1] == 0) {
                        vertexCount[group[s2]]++;
                        edgeCount[group[s2]]++;
                        group[s1] = group[s2];
                    }
                    else if (group[s2] == 0) {
                        vertexCount[group[s1]]++;
                        edgeCount[group[s1]]++;
                        group[s2] = group[s1];
                    }
                    else {
                        int grupo2 = group[s2];
                        for (int j=0;j<group.length;j++) {
                            if (group[j] == grupo2)
                                group[j] = group[s1];
                        }
                        vertexCount[group[s1]] += vertexCount[grupo2];
                        edgeCount[group[s1]] += edgeCount[grupo2]+1;
                        vertexCount[grupo2] = 0;
                        edgeCount[grupo2] = 0;
                    }
                }
            }
            int faces = 1;
            for (int i=0;i<vertexCount.length;i++) {
                if (vertexCount[i]>0) {
                    System.out.println(vertexCount[i]+"   "+edgeCount[i]);
                    System.out.println(edgeCount[i]-vertexCount[i]+1);
                    faces += edgeCount[i]-vertexCount[i]+1;
                }
            }
            System.out.println("Faces: " + faces);
        }
    }
}
