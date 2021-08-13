public static int uniquePairs(int[] nums, int target){
    Set<Integer> uniquePair = new HashSet<Integer>();
    Set<Integer> hs = new HashSet<Integer>();
    int count = 0;

    for(int num : nums){
        if(hs.contains(target-num) && !uniquePair.contains(num)){
            count++;
            uniquePair.add(target-num);
            uniquePair.add(num);
        } 
        else if(!hs.contains(num)){
            hs.add(num);
        }
    }
    return count;
}