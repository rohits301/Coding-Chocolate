class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        /*
         * to handle out of bounds exception for -1 / -2147483648, take long
         */
        long num = numerator;
        long den = denominator;

        if (num == 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        // handleNegative
        if (num < 0 && den < 0) {
            num *= -1;
            den *= -1;
        } else if (den < 0) {
            den *= -1;
            ans.append("-");
        } else if (num < 0) {
            num *= -1;
            ans.append("-");
        }

        long quot = num / den;
        long rem = num % den;

        ans.append(quot);

        if (rem == 0) {
            return ans.toString();
        } else {
            ans.append(".");
            HashMap<Long, Integer> map = new HashMap<>();

            while (rem != 0) {
                if (map.containsKey(rem)) {

                    int len = map.get(rem);
                    ans.insert(len, "(");
                    ans.append(")");
                    break;
                } else {
                    map.put(rem, ans.length());

                    rem *= 10;
                    quot = rem / den;
                    rem = rem % den; // new rem
                    ans.append(quot);
                }
            }
            return ans.toString();
        }
    }
}