import java.io.*;
import java.util.*;

public class Main {

	static String max;

	private static String swap(String str, int i, int j) {

		char chi = str.charAt(i);
		char chj = str.charAt(j);

		String left = str.substring(0, i);
		String middle = str.substring(i + 1, j);
		String right = str.substring(j + 1);

		StringBuilder sb = new StringBuilder();
		sb.append(left).append(chj).append(middle).append(chi).append(right);

		return sb.toString();
	}

	public static void findMaximum(String str, int k) {
		// write your code here

		if (Integer.parseInt(str) > Integer.parseInt(max)) {
			max = str;
		}

		if (k == 0) {
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				char chi = str.charAt(i);
				char chj = str.charAt(j);

				if (chj > chi) {
					str = swap(str, i, j);
					findMaximum(str, k - 1);
					str = swap(str, i, j); // restoring the changes while backtracking
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

}