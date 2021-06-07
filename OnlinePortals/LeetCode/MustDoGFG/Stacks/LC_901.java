class StockSpanner {
    
    class Pair {
        int price;
        int index;
    }
    
    Stack<Pair> st;
    int entryTime = 0;
    
    public StockSpanner() {
        st = new Stack<>();

        Pair base = new Pair();
        base.price = 1000000; // 10^6
        base.index = -1;

        st.push(base);
    }
    
    public int next(int price) {

        Pair p = new Pair();
        p.price = price;
        p.index = entryTime;

        entryTime++;

        while (st.peek().price <= price) {
            st.pop();
        }

        int ans = p.index - st.peek().index; // i - gi

        st.push(p);

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */