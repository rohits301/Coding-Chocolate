import java.util.Scanner;

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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        
        return buildTreeHelper(preorder, 0, n - 1, inorder, 0, n - 1);
    }
    
    private static TreeNode buildTreeHelper(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei){
        if(isi > iei || psi > pei){
            return null;
        }
        
        int idx = isi;
        while(inorder[idx] != preorder[psi]){
            idx++;
        } // now idx = rootIndex
        
        int colse = idx - isi; // count of left subtree elements
        
        TreeNode node = new TreeNode(preorder[psi]);
        
        node.left = buildTreeHelper(preorder, psi + 1, psi + colse, inorder, isi, idx - 1);
        node.right = buildTreeHelper(preorder, psi + colse + 1, pei, inorder, idx + 1, iei);
        
        return node;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}