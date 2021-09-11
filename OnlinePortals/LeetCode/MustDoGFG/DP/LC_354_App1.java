class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        // sort on width
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0]; // sort asc, will return -ve value, eqv. to return -1    
            }
        });

        // lis on height
        int[] lis = new int[n];
        int omax = 0;

        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                // for envelops to fit, height of i > height of j
                // as well as, width of i > width of j
                // since, there might be a case when both envelops have same width
                // and in that case we cannot nest them
                
                if (envelopes[i][1] > envelopes[j][1] && 
                    envelopes[i][0] > envelopes[j][0]) {
                    if (max < lis[j]) {
                        max = lis[j];
                    }
                }
            }
            lis[i] = max + 1;

            omax = Math.max(omax, lis[i]);
        }

        return omax;
    }
}