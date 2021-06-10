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

    private static class Pair {
        TreeNode node = null;
        int hl = 0; // horizontal Level
        
        Pair(TreeNode node, int hl){
            this.node = node;
            this.hl = hl;
        }
    }
    
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        
        LinkedList<Pair> que = new LinkedList<>();
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int minhl = 0, maxhl = 0;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        que.addLast(new Pair(root, 0));
        
        while(que.size() > 0){
            int size = que.size();
            while(size-- > 0){
                // r
                Pair rp = que.removeFirst();
                
                // w
                minhl = Math.min(minhl, rp.hl);
                maxhl = Math.max(maxhl, rp.hl);
                
                map.putIfAbsent(rp.hl, new ArrayList<>());
                ArrayList<Integer> al = map.get(rp.hl);
                al.add(rp.node.val);
                
                // a
                if(rp.node.left != null){
                    que.addLast(new Pair(rp.node.left, rp.hl - 1));
                }
                if(rp.node.right != null){
                    que.addLast(new Pair(rp.node.right, rp.hl + 1));
                }
            }
        }
        // shallow copy the arraylist
        for(int i = minhl; i <= maxhl; i++){
            ans.add(map.get(i));
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
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