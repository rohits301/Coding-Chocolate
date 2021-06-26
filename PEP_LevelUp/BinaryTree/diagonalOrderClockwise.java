import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        
        while(que.size() > 0){ // traverse a diagonal
            int size = que.size();
            ArrayList<Integer> temp = new ArrayList<>(); 
            
            // traverse all components in 
            // a diagonal starting from remove node
            while(size-- > 0){ 
                // r
                TreeNode rn = que.removeFirst();
                
                // w and a
                while(rn != null){ // traverse a component
                    temp.add(rn.val);
                    
                    if(rn.left != null){
                        que.addLast(rn.left);
                    }
                    rn = rn.right;
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}