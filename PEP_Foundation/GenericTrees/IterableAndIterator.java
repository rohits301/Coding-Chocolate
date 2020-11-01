import java.util.*;
import java.io.*;

public class Main {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static class GenericTree implements Iterable<Integer> {
        Node root;

        GenericTree(Node root) {
            this.root = root;
        }

        public Iterator<Integer> iterator() {
            Iterator<Integer> obj = new GTPreorderIterator(root);
            return obj;
        }
    }

    public static class GTPreorderIterator implements Iterator<Integer> {
        Integer nextVal;
        Stack<Pair> st;

        GTPreorderIterator(Node root) {
            st = new Stack<>();
            st.push(new Pair(root, -1));
            next();
        }

        public boolean hasNext() {
            if (nextVal == null) {
                return false;
            } else {
                return true;
            }
        }

        public Integer next() {
            Integer fr = nextVal; // * the value to be returned

            nextVal = null;
            while (st.size() > 0) {
                Pair top = st.peek();

                if (top.state == -1) {
                    nextVal = top.node.data;
                    top.state++;
                    break;
                } else if (top.state == top.node.children.size()) {
                    st.pop();
                } else { // add children
                    Node child = top.node.children.get(top.state);
                    st.push(new Pair(child, -1));

                    top.state++;
                }
            }

            return fr;
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // display(root);

        GenericTree gt = new GenericTree(root);
        // for (int val: gt) {
        // System.out.println(val);
        // }

        Iterator<Integer> gti = gt.iterator();
        while (gti.hasNext() == true) {
            System.out.println(gti.next());
        }
    }
}