class Solution {
    // Function to return the largest possible number of n digits
    // with sum equal to given sum.
    static String largestNumber(int n, int sum) {
        // add your code here

        // does not handle leading zeros case
        if (sum > 9 * n) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (sum >= 9) {
                sb.append("9");
                sum -= 9;
            } else {
                sb.append(sum + "");
                sum = 0;
            }
        }
        return sb.toString();
    }
}
