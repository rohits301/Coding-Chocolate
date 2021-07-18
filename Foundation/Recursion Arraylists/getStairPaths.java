import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n == 0) {
            ArrayList<String> basepath = new ArrayList<>();
            basepath.add("");
            return basepath;
        }
        
        if(n < 0) {
            return new ArrayList<>();
        }
        
        ArrayList<String> mypaths = new ArrayList<>();
        
        ArrayList<String> path1 = getStairPaths(n-1);
        ArrayList<String> path2 = getStairPaths(n-2);
        ArrayList<String> path3 = getStairPaths(n-3);
            
        for(String s1: path1){
            mypaths.add("1" + s1);
        }
        
        for(String s2: path2){
            mypaths.add("2" + s2);
        }
        
        for(String s3: path3){
            mypaths.add("3" + s3);
        }
        
        return mypaths;
    }

}