import java.io.*;
import java.util.*;

public class Main {

    static int counter = 1;

    public static void solution(int i, int n, int k, int nos, ArrayList<ArrayList<Integer>> ans) {
        // write your code here

        if (i > n) {
            if (nos == k) {
                System.out.print(counter + ". ");
                counter++;
                for (ArrayList<Integer> al : ans) {
                    System.out.print(al + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j).size() > 0) { // existing set
                ans.get(j).add(i);
                solution(i + 1, n, k, nos, ans);
                ans.get(j).remove(ans.get(j).size() - 1); // removing the last element, since addLast
            } else { // new set
                ans.get(j).add(i);
                solution(i + 1, n, k, nos + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(1, n, k, 0, ans);

    }

}