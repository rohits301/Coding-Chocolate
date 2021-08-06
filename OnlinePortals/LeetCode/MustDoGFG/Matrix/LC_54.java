class Solution {
    public List<Integer> spiralOrder(int[][] arr) {

        List<Integer> al = new ArrayList<>();

        int minc = 0;
        int maxc = arr[0].length - 1;
        int minr = 0;
        int maxr = arr.length - 1;

        int count = 0;
        int tne = (arr.length) * (arr[0].length);

        while (count < tne) {
            for (int j = minc; j <= maxc && count < tne; j++) {
                al.add(arr[minr][j]);
                count++;
            }
            minr++;

            for (int i = minr; i <= maxr && count < tne; i++) {
                al.add(arr[i][maxc]);
                count++;
            }
            maxc--;

            for (int j = maxc; j >= minc && count < tne; j--) {
                al.add(arr[maxr][j]);
                count++;
            }
            maxr--;

            for (int i = maxr; i >= minr && count < tne; i--) {
                al.add(arr[i][minc]);
                count++;
            }
            minc++;
        }

        return al;
    }
}