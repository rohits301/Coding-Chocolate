class Solution {
    //Function to convert an infix expression to a postfix expression.
	public static String infixToPostfix(String str) 
	{
		Stack<Character> optor = new Stack<>();
        Stack<String> post = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                optor.push(ch);
            } else if (ch == ')') {
                while (optor.peek() != '(') {
                    process(optor, post);
                }
                optor.pop(); // pop '('
            } else if (Character.isDigit(ch) || Character.isLetter(ch)) {
                post.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                while (optor.size() > 0 && 
                       optor.peek() != '(' && 
                       precedence(optor.peek()) >= precedence(ch)) {
                    process(optor, post);
                }
                optor.push(ch); // push the operator
            }
        }

        while(optor.size() > 0){
            process(optor, post);
        }
        return post.pop();
	} 
	private static int precedence(char ch){
        if(ch == '+' || ch == '-'){
            return 1;
        } else if(ch == '*' || ch == '/'){
            return 2;
        } else if(ch == '^'){
            return 3;
        } else {
            return 0; // This case never comes basically
        }
    }

    private static void process(Stack<Character> optor, Stack<String> post){   
        char operator = optor.pop();
        
        String pop1 = post.pop();
        String pop2 = post.pop();
        
        StringBuilder sb = new StringBuilder();
        sb.append(pop2).append(pop1).append(operator);
        post.push(sb.toString());
    }
}