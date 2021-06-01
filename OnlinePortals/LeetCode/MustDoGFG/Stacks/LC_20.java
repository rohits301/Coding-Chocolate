class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            } else if(ch == ')'){
                boolean val = handleClosing(st, '(');
                if(val == false){
                    return false;
                }
            } else if(ch == ']'){
                boolean val = handleClosing(st, '[');
                if(val == false){
                    return false;
                }
            } else if(ch == '}'){
                boolean val = handleClosing(st, '{');
                if(val == false){
                    return false;
                }
            }
        }
        
        if(st.size() == 0){
            return true;
        } else {
            return false;
        }
    }
    private boolean handleClosing(Stack<Character> st, char corresOp){
        if(st.size() == 0){
            return false;
        } else if(st.peek() != corresOp){
            return false;
        } else {
            st.pop();
            return true;
        }
    }
}