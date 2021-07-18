class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        if(n == 2){
            return "11";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("11");
        
        for(int i = 3; i <= n; i++){
            sb.append("$"); //delimiter
            
            int count = 1;
            StringBuilder temp = new StringBuilder();
            char[] arr = (sb.toString()).toCharArray(); // to ease code writing, no special signifcance
            
            for(int j = 1; j < sb.length(); j++){
                if(arr[j] != arr[j - 1]){
                    temp.append(count);
                    temp.append(arr[j - 1]);
                    
                    count = 1; // reset count for next number
                } else {
                    count++;
                }
            }
            
            sb = temp;
        }
        return sb.toString();
    }
}