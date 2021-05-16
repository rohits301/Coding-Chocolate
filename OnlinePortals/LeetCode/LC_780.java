class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {

        // basically, Bottom-Up approach
        // modulo is = repeated subtraction till we get, our root of the tree
        // or the while condition fails

        while (sx < tx && sy < ty) {
            if (ty > tx) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }

        // NOW, either sx matches and sy is just a match away
        // or the other way round
        // else false

        if (sx == tx && sy <= ty && (ty - sy) % sx == 0) {
            return true;
        } else if (sy == ty && sx <= tx && (tx - sx) % sy == 0) {
            return true;
        } else {
            return false;
        }
    }
}