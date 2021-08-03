class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        ArrayList<Integer> al = new ArrayList<>();

        HashSet<Integer> hs1 = new HashSet<>();
        for (int v1 : nums1) {
            hs1.add(v1);
        }

        for (int v : nums2) {
            if (hs1.contains(v)) {
                al.add(v);
                hs1.remove(v); // to avoid duplicates
            }
        }

        int[] arr = new int[al.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = al.get(i);
        }

        return arr;
    }
}