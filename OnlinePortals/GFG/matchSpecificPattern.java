// { Driver Code Starts
    import java.util.*;
    public class MSP
    {	
        public static void main(String[] args)
        {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while (t-- != 0)
            {
                int n=sc.nextInt();
                ArrayList<String> s = new ArrayList<String>(n);
                for (int i=0;i<n;i++)
                    s.add(sc.next());
                String tt;
                tt=sc.next();
                GfG g=new GfG();
                ArrayList<String> res =g.findMatchedWords(s, tt);
                Collections.sort(res);
                for (int i = 0;i < res.size();i++)
                    System.out.print(res.get(i)+" ");
                System.out.println();
    
            }
        }
    }// } Driver Code Ends
    
    
    /*Complete the provided function*/
    
    class GfG
    {
    /* The function returns an array of strings 
    present in the dictionary which matches
    the string pattern.
    You are required to complete this method */
    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
        {
            //add code here.
            ArrayList<String> res = new ArrayList<>();
            for(String word : dict){
                if(checkMapping(word, pattern)){
                    res.add(word);
                }
            }
            return res;
        }
        private static boolean checkMapping(String word, String pattern){
            if(pattern.length() != word.length()){
                return false;
            }
            
            int[] arr = new int[256];
            
            //* pattern -> word mapping
            
            for(int i = 0; i < word.length(); i++){
                char ch = pattern.charAt(i);
                
                if(arr[(int)ch] == 0){ // new match
                    arr[(int)ch] = word.charAt(i); // implicit typecasting to int
                } else if(arr[(int)ch] != word.charAt(i)) { // already matched
                    return false;
                }
            }
            return true;
        }
    }