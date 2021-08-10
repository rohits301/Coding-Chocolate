class Solution {
    public boolean isThree(int n) {
        
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        
        for(int i = 2; i * i < isPrime.length; i++){
            if(isPrime[i] == true){
                for(int j = i + i; j < isPrime.length; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        
        // for(int i = 0; i < isPrime.length; i++){
        //     System.out.print(i + " -> " + isPrime[i] +", ");
        // }
        // System.out.println();
        
        int totalDiv = 1;
        for(int i = 2; i < isPrime.length; i++){
            if(isPrime[i] == true){
                
                int count = 0;
                if(n % i == 0){
                    while(n % i == 0){
                        n = n/i;
                        count++;
                    }
                    
                    totalDiv = totalDiv * (count + 1);
                }
            }
        }
        // System.out.println(totalDiv);
        return (totalDiv == 3)? true : false;
    }
}