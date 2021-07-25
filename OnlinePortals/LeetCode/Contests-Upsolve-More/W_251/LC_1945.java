class Solution {
    public int getLucky(String s, int k) {
        
        int num = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            num = (int)(ch - 'a' + 1);
            
            res += (num / 10 + num % 10);
        }
        
        if(k == 1){
            return res;
        }
        
        k = k - 1; // one iteration done in for loop itself
        
        // sum of digits of res
        // can also add res > 9 with k-->0 to avoid unnecessary calc.
        while(k-- > 0){
            int sum = 0;
            while(res > 0){
                sum += res % 10;
                res = res / 10;
            }
            res = sum;
        }
        return res;
    }
}