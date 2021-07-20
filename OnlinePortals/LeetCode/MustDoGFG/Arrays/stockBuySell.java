// Question Link: https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1#

class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int prices[], int n) {
        // code here
        
        // ** if no profit, return empty AL
        // ** hence, record profit only when bd and sd are different
        
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        
        // int profit = 0;
        int bd = 0; // buying Day
        int sd = 0; // selling Day
        int idx = 0;
        
        for(int i = 1; i < prices.length; i++){
            // rise, inc. sd
            if(prices[i] >= prices[i - 1]){ 
                sd++;   
            } else {
                // collect profit and bd and sd = i
                // profit += prices[sd] - prices[bd];
                
                if(bd != sd){
                    al.add(idx, new ArrayList<>());
                    ArrayList<Integer> list = al.get(idx);
                    list.add(bd);
                    list.add(sd);
                    idx++;
                }
                
                bd = sd = i;
            }
        }
        
        // collecting the last rise profit
        if(bd != sd){
            al.add(idx, new ArrayList<>());
            ArrayList<Integer> list = al.get(idx);
            list.add(bd);
            list.add(sd);
            idx++;
        }

        return al;
    }
}