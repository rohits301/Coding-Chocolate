import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~

    static ArrayList<Integer> sieve(int n) {
        boolean[] arr = new boolean[n + 1]; // ** true-> not prime, false-> prime **

        for (int i = 2; i * i <= arr.length; i++) {
            if (arr[i] == false) { // prime nos.
                for (int j = 2 * i; j < arr.length; j += i) {
                    arr[j] = true; // mark multiples of prime as true
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == false) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void segmentedSieveAlgo(int a, int b) {
        // write your code here

        // 1. find sqrt of b for sieve operation
        int sqrtb = (int) Math.sqrt(b); //

        // 2. generate prime using sieve of eratosthenes algo
        ArrayList<Integer> primes = sieve(sqrtb);

        int len = b - a + 1;
        boolean[] arr = new boolean[len]; // ** true-> not prime, false-> prime **

        // 3. marking prime numbers
        for (int prime : primes) {

            int multiple = (int) Math.ceil((a * 1.0) / prime);

            if (multiple == 1)  multiple++;

            int si = multiple * prime - a; // starting index

            for (int i = si; i < arr.length; i += prime) {
                arr[i] = true;
            }
        }

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == false && i + a != 1) {
                int val = i + a;
                System.out.println(val);
            }
        }
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        segmentedSieveAlgo(a, b);
    }
}
