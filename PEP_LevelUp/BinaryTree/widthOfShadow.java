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

    // [0] => minHl, [1] => maxHl, hl => horizontal level
    private static void width(TreeNode root, int hl, int[] ans) {
        if (root == null) {
            return;
        }

        ans[0] = Math.min(ans[0], hl);
        ans[1] = Math.max(ans[1], hl);

        width(root.left, hl - 1, ans);
        width(root.right, hl + 1, ans);
    }

    public static int width(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] ans = new int[2];
        width(root, 0, ans);

        return ans[1] - ans[0] + 1;
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

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}