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
        
        ArrayList<String> hpaths = getMazePaths(sr, sc+1, dr, dc);
        ArrayList<String> vpaths = getMazePaths(sr+1, sc, dr, dc);
        
        ArrayList<String> mypaths = new ArrayList<>();
        
        for(String hstr: hpaths){
            mypaths.add("h"+hstr);
        }
        
        for(String vstr: vpaths){
            mypaths.add("v"+vstr);
        }
        
        return mypaths;
    }

}