/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private void width(TreeNode node, int hl, int[] minMax) {
        if (node == null) {
            return;
        }

        minMax[0] = Math.min(minMax[0], hl); // min
        minMax[1] = Math.max(minMax[1], hl); // max

        width(node.left, hl - 1, minMax);
        width(node.right, hl + 1, minMax);
    }

    private class vPair {
        TreeNode node = null;
        int hl = 0; // horizontal level

        vPair(TreeNode node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if (root == null) {
            List<List<Integer>> base = new ArrayList<>();
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

        List<List<Integer>> ans = new ArrayList<>();
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
}