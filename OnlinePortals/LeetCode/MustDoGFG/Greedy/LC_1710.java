class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Similar to Fractional Knapsack
        // wts => noOfBoxes [i][0], value/wt => noOfUnitsPerBox [i][1] 
        
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            
            public int compare(int[] a, int[] b){
                
                if(a[1] < b[1]) return 1; // sort desc
                else if(a[1] > b[1]) return -1;
                else return 0;
            }
        });   
        
        
        int cbs = 0; // current box size
        int maxUnits = 0;
        for(int i = 0; i < boxTypes.length; i++){
            
            // take full
            if(cbs + boxTypes[i][0] <= truckSize){
                cbs += boxTypes[i][0];
                maxUnits += (boxTypes[i][1] * boxTypes[i][0]);
            } 
            else { // take fraction
                int rem = truckSize - cbs;//remaining size
                cbs += rem;
                maxUnits += (boxTypes[i][1] * rem);
                break; // since total capacity is achieved now
            }
        }
        return maxUnits;
    }
}