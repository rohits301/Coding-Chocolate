class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        Stack<Integer> stack = new Stack(); // For storing id
        int[] res = new int[n]; // Final Result
        int prev = 0; // Storing Previous Timestamp

        for (int i = 0; i < logs.size(); i++) {
            // Get the current log details
            Log log = new Log(logs.get(i));

            if (log.isStart) {
                if (!stack.isEmpty())
                    res[stack.peek()] += log.timestamp - prev;
                stack.push(log.id);
                prev = log.timestamp;
            } else {
                res[stack.peek()] += log.timestamp - prev + 1;
                stack.pop();
                prev = log.timestamp + 1;
            }
        }
        return res;
    }

    // Private class to store the details of the log as an object
    private class Log {
        int id; // function id
        boolean isStart;
        int timestamp;

        Log(String str) {
            String[] s = str.split(":");
            this.id = Integer.parseInt(s[0]);
            this.isStart = s[1].equals("start");
            this.timestamp = Integer.parseInt(s[2]);
        }
    }
}