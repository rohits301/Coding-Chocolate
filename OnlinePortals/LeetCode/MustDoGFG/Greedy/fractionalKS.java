class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr, new ItemComparator()); //sort desc
        
        int cwt = 0; // curr weight
        double profit = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(cwt + arr[i].weight <= W){
                cwt += arr[i].weight;
                profit += arr[i].value;
            } else {
                int rem = W - cwt;
                profit += ((double)arr[i].value / (double)arr[i].weight) * (double)rem;
                break; // Now since knapsack is filled, hence break
            }
        }
        
        return profit;
    }
    class ItemComparator implements Comparator<Item> {
        @Override
        
        public int compare(Item a, Item b){
            double v1 = (double)a.value / (double)a.weight;
            double v2 = (double)b.value / (double)b.weight;
            
            if(v1 < v2) return 1;
            else if(v1 > v2) return -1;
            else return 0;
        }
    }
}