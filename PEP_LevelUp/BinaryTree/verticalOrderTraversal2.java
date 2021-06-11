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

    private static void width(TreeNode node, int hl, int[] minMax) {
        if (node == null) {
            return;
        }

        minMax[0] = Math.min(minMax[0], hl); // min
        minMax[1] = Math.max(minMax[1], hl); // max

        width(node.left, hl - 1, minMax);
        width(node.right, hl + 1, minMax);
    }

    private static class vPair {
        TreeNode node = null;
        int hl = 0; // horizontal level

        vPair(TreeNode node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {

        if (root == null) {
            ArrayList<ArrayList<Integer>> base = new ArrayList<>();
            return base;
        }

        PriorityQueue<vPair> parQue = new PriorityQueue<>((a, b) -> {
            return a.node.val - b.node.val;
        });
        PriorityQueue<vPair> chQue = new PriorityQueue<>((a, b) -> {
            return a.node.val - b.node.val;
        });

        int[] minMax = new int[2];
        width(root, 0, minMax); // minMax is filled
        int len = minMax[1] - minMax[0] + 1;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ans.add(new ArrayList<>());
        }

        parQue.add(new vPair(root, Math.abs(minMax[0])));

        while (parQue.size() > 0) {
            int size = parQue.size();
            while (size-- > 0) {
                // r
                vPair rp = parQue.poll();

                TreeNode node = rp.node;
                int hl = rp.hl;

                // w (work)
                ans.get(hl).add(node.val); // adding to ans list

                // a
                if (node.left != null) {
                    chQue.add(new vPair(node.left, hl - 1));
                }
                if (node.right != null) {
                    chQue.add(new vPair(node.right, hl + 1));
                }
            }

            // swap references
            PriorityQueue<vPair> temp = parQue;
            parQue = chQue;
            chQue = temp;
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