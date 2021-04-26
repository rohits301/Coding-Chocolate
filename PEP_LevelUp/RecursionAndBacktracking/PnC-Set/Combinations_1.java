import java.io.*;
import java.util.*;

public class Main {

    public static void combinations(int currentBox, int totalBoxes, int itemsSoFar, int totalItems, String asf) {
        // write your code here

        if (currentBox > totalBoxes) {
            if (itemsSoFar == totalItems) {
                System.out.println(asf);
            }
            return;
        }

        combinations(currentBox + 1, totalBoxes, itemsSoFar + 1, totalItems, asf + "i"); // yes
        combinations(currentBox + 1, totalBoxes, itemsSoFar, totalItems, asf + "-"); // no
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(1, nboxes, 0, ritems, "");
    }

}