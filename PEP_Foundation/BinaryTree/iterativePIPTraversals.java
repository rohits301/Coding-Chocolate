import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
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

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    private static class itrPair {
        Node node;
        int state;

        itrPair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void iterativePrePostInTraversal(Node node) {
        // my code
        Stack<itrPair> st = new Stack<>();
        itrPair rtp = new itrPair(node, 1);

        st.push(rtp);

        StringBuilder pre = new StringBuilder();
        StringBuilder post = new StringBuilder();
        StringBuilder in = new StringBuilder();

        while (st.size() > 0) {
            itrPair top = st.peek();

            if (top.state == 1) {
                pre.append(top.node.data).append(" ");
                top.state++;

                if (top.node.left != null) {
                    st.push(new itrPair(top.node.left, 1));
                }
            } else if (top.state == 2) {
                in.append(top.node.data).append(" ");
                top.state++;

                if (top.node.right != null) {
                    st.push(new itrPair(top.node.right, 1));
                }
            } else {
                post.append(top.node.data).append(" ");
                st.pop();
            }
        }
        System.out.println(pre.toString());
        System.out.println(in.toString());
        System.out.println(post.toString());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        iterativePrePostInTraversal(root);
    }

}