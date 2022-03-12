
class Solution {
    // Function to merge k sorted arrays.

    // T: O(k * klogn), T: O(k)
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        // Write your code here.

        ArrayList<Integer> ans = new ArrayList<>();

        // k = arr.length
        // writing comparator for the list
        PriorityQueue<Pair> pq = new PriorityQueue<>(arr.length, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.val < p2.val)
                    return -1;
                else if (p1.val == p2.val)
                    return 0;
                else
                    return 1;
            }
        });

        // 1. Adding the first k-elements of 1st column to the pq
        for (int i = 0; i < K; i++) {
            pq.add(new Pair(arr[i][0], i, 0));
        }

        while (!pq.isEmpty()) {
            // 2. remove the top-element from MIN HEAP
            Pair rp = pq.poll();
            ans.add(rp.val);
            
            // 3. check if more elements in the list
            if (rp.j + 1 < arr[rp.i].length) {
                pq.add(new Pair(arr[rp.i][rp.j + 1], rp.i, rp.j + 1));
            }
        }

        return ans;
    }

    private static class Pair {
        int val;
        int i;
        int j;

        Pair(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
}