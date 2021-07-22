import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    // write your code here

    // Kernighan's Algo
    // T: O(k), k = number of set bits, since we jump to next set bit
    // S: O(1)

    int counter = 0;
    while (n > 0) {
      int rsbm = n & -n;
      n -= rsbm;
      counter++;
    }

    System.out.println(counter);
  }

}