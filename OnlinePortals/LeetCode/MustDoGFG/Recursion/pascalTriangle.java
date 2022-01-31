
class Solution {
    
    // T: O(n^2), S: O(n^2)
    
    final long mod = 1000000007;
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        
        if(n==1){
            ArrayList<Long> al = new ArrayList<>();
            al.add((long)(1));
            return al;
        }
        
        ArrayList<Long> al = new ArrayList<>();
        al.add((long)(1));
        
        ArrayList<Long> rl = nthRowOfPascalTriangle(n-1);
        int i=0,j=1;
        
        while(j < rl.size()){
            
            long sum = (rl.get(i) % mod + rl.get(j) % mod) % mod;
            al.add(sum);
            
            j++;
            i++;
        }
        
        al.add((long)(1));
        return al;
    }
}