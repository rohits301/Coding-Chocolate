import java.io.*;
import java.util.*;

public class Main {

    public static void solution(char[][] arr, String[] words, int vidx) {
        // write your code here

        if (vidx == words.length) {
            print(arr);
            return;
        }

        String word = words[vidx];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {

                    if (canPlaceWordHorizontally(arr, word, i, j)) {
                        boolean[] wePlaced = placeWordHorizontally(arr, i, j, word);
                        solution(arr, words, vidx + 1);
                        unplaceWordHorizontally(arr, i, j, wePlaced);
                    }

                    if (canPlaceWordVertically(arr, word, i, j)) {
                        boolean[] wePlaced = placeWordVertically(arr, i, j, word);
                        solution(arr, words, vidx + 1);
                        unplaceWordVertically(arr, i, j, wePlaced);
                    }
                }
            }
        }
    }

    private static boolean canPlaceWordHorizontally(char[][] arr, String word, int i, int j) {
        // tight fit
        if (j - 1 >= 0 && arr[i][j - 1] != '+') { // +--------
            return false;
        }
        if (j + word.length() < arr[0].length && arr[i][j + word.length()] != '+') { // --------+
            return false;
        }

        // checked for tight fit
        for (int w = 0; w < word.length(); w++) {
            if (j + w >= arr[0].length) { // out of the board
                return false;
            }

            if (arr[i][j + w] == '-' || arr[i][j + w] == word.charAt(w)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean[] placeWordHorizontally(char[][] arr, int i, int j, String word) {
        boolean[] wePlaced = new boolean[word.length()];

        for (int w = 0; w < word.length(); w++) {
            if (arr[i][j + w] == '-') {
                arr[i][j + w] = word.charAt(w);
                wePlaced[w] = true;
            }
        }
        return wePlaced;
    }

    private static void unplaceWordHorizontally(char[][] arr, int i, int j, boolean[] wePlaced) {

        for (int w = 0; w < wePlaced.length; w++) {
            if (wePlaced[w] == true) {
                arr[i][j + w] = '-';
            }
        }
    }

    private static boolean canPlaceWordVertically(char[][] arr, String word, int i, int j) {
        // tight fit
        if (i - 1 >= 0 && arr[i - 1][j] != '+') { // +--------
            return false;
        }
        if (i + word.length() < arr.length && arr[i + word.length()][j] != '+') { // --------+
            return false;
        }

        // checked for tight fit
        for (int w = 0; w < word.length(); w++) {
            if (i + w >= arr.length) { // out of the board
                return false;
            }

            if (arr[i + w][j] == '-' || arr[i + w][j] == word.charAt(w)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean[] placeWordVertically(char[][] arr, int i, int j, String word) {
        boolean[] wePlaced = new boolean[word.length()];

        for (int w = 0; w < word.length(); w++) {
            if (arr[i + w][j] == '-') {
                arr[i + w][j] = word.charAt(w);
                wePlaced[w] = true;
            }
        }
        return wePlaced;
    }

    private static void unplaceWordVertically(char[][] arr, int i, int j, boolean[] wePlaced) {

        for (int w = 0; w < wePlaced.length; w++) {
            if (wePlaced[w] == true) {
                arr[i + w][j] = '-';
            }
        }
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
    }

}