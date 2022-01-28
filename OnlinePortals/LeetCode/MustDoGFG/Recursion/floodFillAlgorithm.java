class Solution {
    // T: O(n*m), S: O(n*m)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int myColor = image[sr][sc];
        ffHelper(image, sr, sc, myColor, newColor);

        // marking with new color acts like visited[]
        // and we don't go on already marked spots

        return image;
    }

    private void ffHelper(int[][] image, int sr, int sc, int myColor, int newColor) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
            || image[sr][sc] != myColor || image[sr][sc] == newColor) {
            return;
        }

        image[sr][sc] = newColor;
        ffHelper(image, sr - 1, sc, myColor, newColor); // t
        ffHelper(image, sr, sc - 1, myColor, newColor); // l
        ffHelper(image, sr + 1, sc, myColor, newColor); // d
        ffHelper(image, sr, sc + 1, myColor, newColor); // r
    }
}