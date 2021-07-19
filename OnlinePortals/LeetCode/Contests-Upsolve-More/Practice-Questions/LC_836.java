class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];
        
        int x3 = rec2[0];
        int y3 = rec2[1];
        int x4 = rec2[2];
        int y4 = rec2[3];
        
        // the line cannot have positive overlap, if any of the rect has 0 area
        if (x1 == x2 || y1 == y2 ||
            x3 == x4 || y3 == y4) {
            return false;
        }
        
        if(y1 >= y4 || y3 >= y2 || x2 <= x3 || x4 <= x1){
            return false;
        }
        
        return true;
    }
}