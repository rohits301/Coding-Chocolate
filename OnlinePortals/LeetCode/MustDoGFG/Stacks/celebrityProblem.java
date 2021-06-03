class Solution {
    // Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n) {
        n = arr.length;
        int a = 0;
        int b = n - 1;

        while (a < b) {
            if (arr[a][b] == 1) {
                a++; // a cannot be celeb.
            } else {
                b--; // b cannot be celeb.
            }
        }

        int pot = a;

        int ikp = 0; // i knows pot
        int pki = 0; // pot knows i

        for (int i = 0; i < n; i++) {
            if (i != pot) {
                if (arr[i][pot] == 1) {
                    ikp++;
                }
                if (arr[pot][i] == 1) {
                    pki++;
                }
            }
        }
        if (ikp == (n - 1) && pki == 0) {
            return pot;
        } else {
            return -1;
        }
    }
}