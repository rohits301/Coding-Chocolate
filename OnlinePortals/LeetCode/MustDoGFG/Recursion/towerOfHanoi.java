// avoid space at the starting of the string in "move disk....."
class Hanoi {

    public long toh(int N, int from, int to, int aux) {
        // Your code here

        if (N == 0) {
            return 0;
        }

        long ans1 = toh(N - 1, from, aux, to);
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        long ans2 = toh(N - 1, aux, to, from);

        return ans1 + ans2 + 1;
    }
}