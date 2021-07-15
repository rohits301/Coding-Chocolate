class Solution {
    // T: O(n), S: O(1)
    public String validIPAddress(String IP) {

        // filter(), filters the results from a stream
        // then we can either collect them in StringBuilder
        // or perform operation directly

        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        } else {
            return "Neither";
        }
    }

    private String validateIPv4(String IP) {
        String[] arr = IP.split("\\.", -1);
        // split(regex, limit)

        // if limit < 0 => the split will be done as
        // many times as possible, and the resulting
        // array can be of any size

        // if no limit is given or limit = 0
        // the trailing empty string is discarded

        // in this case. Eg. "1.0.1"
        // Using regex without limit, only 3 items are there
        // with limit, 4 are there (reqd.)

        // int count = 1;
        // for(String str : arr){
        // System.out.print(count + ")" + str + "-");
        // count++;
        // }
        // System.out.println();

        for (String s : arr) {
            // if len of any string is 0 or > 3, so invalid
            if (s.length() == 0 || s.length() > 3) {
                return "Neither";
            }
            // if first character is 0 and length!= 1, so invalid
            if (s.charAt(0) == '0' && s.length() != 1) {
                return "Neither";
            }
            // any character is non-digit, so invalid
            for (char ch : s.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }

            // limit > 255, then also false
            if (Integer.parseInt(s) > 255) {
                return "Neither";
            }
        }

        return "IPv4";
    }

    private String validateIPv6(String IP) {
        String[] arr = IP.split(":", -1);

        String hex = "0123456789abcdefABCDEF"; // all valid IPv6 chars

        for (String s : arr) {
            // if len of any string is 0 or > 4, so invalid
            if (s.length() == 0 || s.length() > 4) {
                return "Neither";
            }

            // if any character is out of those in 'hex' string, then invalid
            for (Character ch : s.toCharArray()) {
                if (hex.indexOf(ch) == -1) {
                    // indexOf() returns index at which a
                    // particular character is found if found, else -1
                    return "Neither";
                }
            }
        }

        return "IPv6";
    }
}