import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        System.out.println(getMazePaths(0,0,n-1,m-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc) {
            ArrayList<String> basepath = new ArrayList<>();
            basepath.add("");
            return basepath;
        } else if(sr > dr) {
            return new ArrayList<>();
        } else if(sc > dc) {
            return new ArrayList<>();            
        }
        
        ArrayList<String> mypaths = new ArrayList<>();
        
        for(int hjump=1; hjump<=dc; hjump++){
            ArrayList<String> hpaths = getMazePaths(sr, sc+hjump, dr, dc);
            for(String hstr: hpaths){
                mypaths.add("h"+hjump+hstr);
            }
        }
        
        for(int vjump=1; vjump<=dr; vjump++){
            ArrayList<String> vpaths = getMazePaths(sr+vjump, sc, dr, dc);
            for(String vstr: vpaths){
                mypaths.add("v"+vjump+vstr);
            }
        }
        
        for(int djump=1; djump<=dc && djump<=dr; djump++){
            ArrayList<String> dpaths = getMazePaths(sr+djump, sc+djump, dr, dc);
            for(String dstr: dpaths){
                mypaths.add("d"+djump+dstr);
            }
        }
        
        return mypaths;
    }


}