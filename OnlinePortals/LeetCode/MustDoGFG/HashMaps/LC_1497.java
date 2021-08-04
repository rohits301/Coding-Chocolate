class Solution {
    public boolean canArrange(int[] arr, int k) {
        boolean flag = true;

        // remainder frequency map
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int val : arr) {
            int rem = val % k;

            if (rem < 0) {
                rem += k;
            }
            fmap.put(rem, fmap.getOrDefault(rem, 0) + 1);
        }

        // check freq.

        for (int val : arr) {
            int rem = val % k;

            if (rem < 0) {
                rem += k;
            }

            if (rem == 0) {
                int f = fmap.get(rem);
                if (f % 2 == 1) {
                    flag = false;
                    break;
                }
            } else if (2 * rem == k) { // ** to avoid odd number error
                int f = fmap.get(rem);
                if (f % 2 == 1) {
                    flag = false;
                    break;
                }
            } else {
                int f1 = fmap.get(rem);
                int f2 = fmap.getOrDefault(k - rem, 0); // ** (k-rem) may or may not be present in fmap
                if (f1 != f2) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}