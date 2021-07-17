class Trie {
    
    private class Node {
        Node[] children;
        boolean isEndOfWord; // flag to denote end of word
        
        Node(){
            children = new Node[26]; // for 26 english alphabets
        }
    }
    
    final private Node root; // root is a dummy node
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
        }
        
        curr.isEndOfWord = true; 
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root;
        
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.children[ch - 'a'] == null){
                return false; // character not present, hence false
            } 
            curr = curr.children[ch - 'a']; // move to next
        }
        
        // if reached the end of word, then return true
        return curr.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = root;
        
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        
        // if it comes out of loop => search is completed successfully
        return true; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */