import java.util.*;

public class Main {

    public static List<Integer> grayCode(int n) {
        // Write your code here

        List<Integer> ans = new ArrayList<>();
        ans.add(0);

        if (n == 0)
            return ans;

        ans.add(1);

        int curr = 1;
        for (int i = 2; i <= n; i++) {
            curr *= 2;
            // traverse the list from back and append curr to all values
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(curr + ans.get(j));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<Integer> ans = grayCode(scn.nextInt());
        Collections.sort(ans);
        System.out.println(ans);
    }
}