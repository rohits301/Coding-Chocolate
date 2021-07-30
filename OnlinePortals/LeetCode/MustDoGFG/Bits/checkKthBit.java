class CheckBit {
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k) {
        // Your code here
        int cmask = (1 << k);
        boolean check = ((n & cmask) == 0) ? false : true;

        return check;
    }

}