import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    // T: O(n), S: O(1), passed on LeetCode
    public static int maxChunksToSorted(int[] arr) {
        // write your code here  
        
        /*
        Subtle mistake: initialising max w/ arr[0]
        and then looping from i = 1, THIS WILL GIVE ERROR
        if, i = 0 and arr[0] = 0, i.e., i == max,
        since we do not count this chunk
        HENCE, BETTER TO LOOP FROM i=0 itself and max = 0 (initially)
        */
        
        int max = 0;
        int chunkCount = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            max = Math.max(max, arr[i]);
            
            if(i == max){
                chunkCount++;
            }
        }
        return chunkCount;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted(arr);
        System.out.println(res);
    }
}