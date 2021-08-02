class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here
        ArrayList<Meeting> al = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            al.add(new Meeting(start[i], end[i], i + 1));
        }

        MeetingComparator c = new MeetingComparator();
        Collections.sort(al, c);

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(al.get(0).pos);
        int et = al.get(0).end; // end time

        for (int i = 1; i < al.size(); i++) {
            if (al.get(i).start > et) {
                // attend
                et = al.get(i).end;
                ans.add(al.get(i).pos);
            }
        }

        // order of meetings
        // for(int val : ans){
        // System.out.println(val + " ");
        // }

        return ans.size();
    }

    static class MeetingComparator implements Comparator<Meeting> {

        @Override
        public int compare(Meeting m1, Meeting m2) {
            if (m1.end < m2.end) {
                return -1; // to keep values same
            } else if (m1.end > m2.end) {
                return 1; // to swap values
            } else if (m1.pos < m2.pos) { // means end time are same
                return -1;
            } else {
                return 1;
            }
        }
    }

    static class Meeting {
        int start;
        int end;
        int pos;

        Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

}