import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            int m = s.nextInt();
            
            printMazePaths(0,0,n-1,m-1, "");    
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr==dr && sc==dc){
            System.out.println(psf);
            return;
        }
        if(sr>dr || sc>dc){
            return;
        }
        
        for(int h=1; h<=dc; h++){    //h=horizontal jump
            printMazePaths(sr, sc+h, dr, dc, psf+"h"+h);
        }
        
        for(int v=1; v<=dr; v++){    //v=vertical jump
            printMazePaths(sr+v, sc, dr, dc, psf+"v"+v);
        }
        
        for(int d=1; d<=dr && d <= dc; d++){    //d=diagonal jump
            printMazePaths(sr+d, sc+d, dr, dc, psf+"d"+d);
        }
        
    }

}