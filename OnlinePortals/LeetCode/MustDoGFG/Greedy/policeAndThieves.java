class Solution {
    // T: O(n), S: O(n)
    static int catchThieves(char arr[], int n, int k) {
        // Code here
        ArrayList<Integer> police = new ArrayList<>();
        ArrayList<Integer> thieves = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') police.add(i);

            else thieves.add(i);
        }

        int i = 0, j = 0;
        int ans = 0;
        while (i < police.size() && j < thieves.size()) {
            int pi = police.get(i); // police index
            int ti = thieves.get(j); // thief index

            if (Math.abs(pi - ti) <= k) {
                i++;
                j++;
                ans++;
            } else if (ti < pi) {
                j++;
            } else {
                i++;
            }
        }

        return ans;
    }
}