class Solution {
    public int minSwaps(String s) {
        
        int stackSize = 0;
        
        for(char ch : s.toCharArray()){
            
            if(ch == '['){
                stackSize++;
            } else {
                if(stackSize > 0) stackSize--; // balance the brackets
                
                else stackSize++; // counting unbalanced paranthesis
            }
        }
        
        return (stackSize + 1)/2; // total mismatches
    }
}