// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class GfG { 
        
        public static void main (String[] args) throws IOException  {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while(t-->0){
                String inputLine[] = br.readLine().trim().split(" ");
                int m = Integer.parseInt(inputLine[0]);
                int n = Integer.parseInt(inputLine[1]);
                Solution ob = new Solution();
                System.out.println(ob.numberOfPaths(m, n));
            }
        }
    }
    
    
    
    // } Driver Code Ends
    
    
    class Solution{
        
        long numberOfPaths(int m, int n) {
            // Code Here
            // gmp
            // h and v, 2 calls
            
            long ans = gmp(0, 0, m - 1, n - 1);
            
            return ans;
        }
        
        long gmp(int sr, int sc, int dr, int dc){
            if(sr == dr && sc == dc){
                return 1;
            }
            
            long hpaths = 0;
            long vpaths = 0;
            
            if(sc + 1 <= dc)
                hpaths = gmp(sr, sc + 1, dr, dc);
            
            if(sr + 1 <= dr)
                vpaths = gmp(sr + 1, sc, dr, dc);
            
            return hpaths + vpaths;
        }
    }