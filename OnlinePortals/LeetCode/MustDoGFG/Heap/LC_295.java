class MedianFinder {
    // T: O(nlogn), S: O(n)
    // keerti pusrwani vid expln -- Awesome

    // Approach->
    // we want maximum value from chhote numbers, so maxPQ is for that
    // also, we want minimum value from bade numbers, so minPQ is for that
    private PriorityQueue<Integer> minPQ;
    private PriorityQueue<Integer> maxPQ;

    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        // pushing the number **CLEVER**
        if (minPQ.isEmpty() || minPQ.peek() < num) {
            minPQ.add(num);
        } else {
            maxPQ.add(num);
        }

        // balancing
        if (minPQ.size() > maxPQ.size() + 1) {
            maxPQ.add(minPQ.poll());
        } else if (maxPQ.size() > minPQ.size() + 1) {
            minPQ.add(maxPQ.poll());
        }
    }

    public double findMedian() {
        double median = 0D; // cool way to write double, use from now onwards

        if (minPQ.size() > maxPQ.size()) {
            median = minPQ.peek();
        } else if (maxPQ.size() > minPQ.size()) {
            median = maxPQ.peek();
        } else {
            median = (minPQ.peek() + maxPQ.peek()) * 1.0 / 2; // this multiplication with 1.0 is unavoidable
        }

        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */