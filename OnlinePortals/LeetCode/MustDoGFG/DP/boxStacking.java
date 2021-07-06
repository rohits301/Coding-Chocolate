class Solution {
    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        // Code here

        // 1. fill box array
        n = height.length;

        Box[] b = new Box[n];
        for (int i = 0; i < n; i++) {
            b[i] = new Box(height[i], width[i], length[i]);
        }

        // 2. generate rotations
        Box[] allBoxes = new Box[3 * n];

        int idx = 0;
        for (int i = 0; i < b.length; i++) {

            allBoxes[idx] = new Box();
            allBoxes[idx].h = b[i].h;
            allBoxes[idx].w = Math.max(b[i].w, b[i].l);
            allBoxes[idx].l = Math.min(b[i].w, b[i].l);
            idx++;

            allBoxes[idx] = new Box();
            allBoxes[idx].h = b[i].l;
            allBoxes[idx].w = Math.max(b[i].w, b[i].h);
            allBoxes[idx].l = Math.min(b[i].w, b[i].h);
            idx++;

            allBoxes[idx] = new Box();
            allBoxes[idx].h = b[i].w;
            allBoxes[idx].w = Math.max(b[i].h, b[i].l);
            allBoxes[idx].l = Math.min(b[i].h, b[i].l);
            idx++;
        }

        for (int i = 0; i < allBoxes.length; i++) {
            allBoxes[i].area = allBoxes[i].l * allBoxes[i].w;
        }

        Arrays.sort(allBoxes); // 3. sort on area

        // for(int i = 0; i < allBoxes.length; i++){
        //     System.out.println(allBoxes[i]);
        // }

        // LDS - Longest Decreasing Subsequence
        int omax = -1; // overall max

        // initialising with heights
        int len = allBoxes.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = allBoxes[i].h;
        }

        for (int i = 1; i < len; i++) {
            Box cb = allBoxes[i]; // current box

            for (int j = 0; j < i; j++) {

                // check for decreasing, fit smaller box in bigger
                if (cb.l < allBoxes[j].l && 
                    cb.w < allBoxes[j].w) {
                    // max for longest ds
                    dp[i] = Math.max(dp[i], dp[j] + cb.h);
                }
            }
            omax = Math.max(omax, dp[i]);
        }
        return omax;
    }

    private static class Box implements Comparable<Box> {
        int h;
        int w;
        int l;
        int area;

        public Box() {

        }

        public Box(int h, int w, int l) {
            this.h = h;
            this.w = w;
            this.l = l;
        }

        @Override
        public int compareTo(Box o) {
            return o.area - this.area; // sort in desc. order
        }

        public String toString() {
            return h + " " + w + " " + l; // for display
        }
    }

}