class Solution {
    public int trailingZeroes(int n) {
        if(n < 4){
            return 0;
        }
        
        int count = 0;
        
        while(n > 0){
            int temp = n / 5;
            count += temp;
            
            n = n / 5;
        }
        return count;
    }
}
