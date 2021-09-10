import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
        }
        
        int ans = maxNonOverlappingSubseq(arr);
        System.out.println(ans);
    } 
    public static int maxNonOverlappingSubseq(int[][] arr){
        
        int n = arr.length;
        
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                if(a1[0] != a2[0]){
                    return a1[0]-a2[0]; // eqv. to return -1 for smaller (asc. order of north banks)
                } else {
                    return a1[1]-a2[1]; // eqv. to when values are same, sort on south bank
                }
            }    
        });
        
        int[] lis = new int[n];
        
        int omax = 0;
        for(int i = 0; i < n; i++){
            int max = 0;
            
            for(int j = 0; j < i; j++){
                if(arr[i][1]>=arr[j][1]){
                    if(max < lis[j]){
                        max = lis[j];
                    }
                }
            }
            
            lis[i] = max + 1;
            
            omax = Math.max(lis[i], omax);
        }
        
        return omax;
    }    

}