class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // ** taking hash set will automatically remove duplicates **
        HashSet<Integer> hs = new HashSet<>();

        // make all as starting point
        for (int val : nums) {
            hs.add(val);
        }

        // finding maximum out of all possible starting points

        int msp = 0; // maximum length starting point's value
        int ml = 0; // maximum length

        // PRO TIP: loop on hash set to avoid
        // looping thru duplicate values, saves run time
        for (int val : hs) {
            if (hs.contains(val - 1) == false) {
                int tsp = val; // temp starting point
                int tl = 1; // temp length

                while (hs.contains(tsp + tl)) {
                    tl++;
                }

                if (tl > ml) {
                    msp = tsp;
                    ml = tl;
                }
            }
        }

        return ml;
    }
}