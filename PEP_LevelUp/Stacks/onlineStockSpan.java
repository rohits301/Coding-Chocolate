import java.io.*;
import java.util.*;

public class Main {

    static class StockSpanner {

        static class Pair {
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
            int ans = 0;

            Pair p = new Pair();
            p.price = price;
            p.index = entryTime;

            entryTime++;

            while (st.peek().price <= price) {
                st.pop();
            }

            ans = p.index - st.peek().index; // i - gi

            st.push(p);

            return ans;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StockSpanner obj = new StockSpanner();

        while (read.ready()) {
            int price = Integer.parseInt(read.readLine());
            System.out.println(obj.next(price));
        }
    }
}
