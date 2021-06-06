class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            
            while(st.size() > 0 && k > 0 && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        while(k > 0){ // no need to check st.size() > 0, since, k <= num.length
            st.pop();
            k--;
        }
        
        // fill the array
        char[] arr = new char[st.size()];
        for(int i = arr.length - 1; i >= 0; i--){
            arr[i] = st.pop();
        }
        
        // =================handleZeros=================
        int z = 0;
        
        while(z < arr.length && arr[z] == '0'){
            z++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        // put non-zero characters in sb
        while(z < arr.length){
            sb.append(arr[z++]);
        }
        
        // if all are zero, then append one '0'
        if(sb.length() == 0){
            sb.append('0');
        }
        
        return sb.toString();
    }
}