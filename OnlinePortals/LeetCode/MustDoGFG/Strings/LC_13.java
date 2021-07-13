class Solution {
    public int romanToInt(String s) {
        //1. mapping of roman numerals to integer 
    
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int val = map.get(ch);
            
            //2. if i and i-1 are unequal, 
            //undo the effect and then subtract
            if(i > 0 && val > map.get(s.charAt(i - 1))){
                res += val - 2 * map.get(s.charAt(i - 1));
            } else {
                res += val;
            }
        }
        
        return res;
    }
}