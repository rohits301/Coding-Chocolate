import java.util.*;

class Main {
    public static void main(String[] args){
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        
        Node root = createTree(arr);
        display(root);
    } 
    
    public static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    static class Pair {
        Node node;
        int state;
        
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    
    static Node createTree(Integer[] arr){
        
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1); //root pair
        
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        
        int idx = 0;
        
        while(st.size() > 0){
            Pair top = st.peek();
            
            if(top.state == 1){
                idx++;
                
                if(arr[idx] != null){
                    Node ln = new Node(arr[idx], null, null);
                    top.node.left = ln; // joining link
                    
                    Pair lp = new Pair(ln, 1);
                    st.push(lp); // pushing left pair
                } else {
                    top.node.left = null;
                }
                
                top.state++;
            } else if(top.state == 2){
                idx++;
                
                if(arr[idx] != null){
                    Node rn = new Node(arr[idx], null, null);
                    top.node.right = rn; // joining link
                    
                    Pair rp = new Pair(rn, 1);
                    st.push(rp); // pushing right pair
                } else {
                    top.node.right = null;
                }
                
                top.state++;
            } else {
                st.pop();
            }
        }
        
        return root;
    }
    
    static void display(Node node){
        // BaseCase is reqd., otherwise,
        // when node is null, null.left or null.right
        // throws NullPointerException
        if(node == null){
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append((node.left != null)? node.left.data + "" : ".");
        sb.append(" -> " + node.data + " <- ");
        sb.append((node.right != null)? node.right.data + "" : ".");
        
        System.out.println(sb.toString());
        
        display(node.left);
        display(node.right);
    }
}

/*
Output:
25 -> 50 <- 75
12 -> 25 <- 37
. -> 12 <- .
30 -> 37 <- .
. -> 30 <- .
62 -> 75 <- 87
. -> 62 <- 70
. -> 70 <- .
. -> 87 <- .
*/