import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner input = new Scanner(System.in);
	    int cases = input.nextInt();
	    while(cases-->0) {
	        int N = input.nextInt();
	        TrieNode root = new TrieNode();
	        input.nextLine();
	        String strs[] = input.nextLine().split(" ");
	        for(int i = 0; i < N; i++) {
	         insertKey(strs[i], root);
	        }
	        String word = input.nextLine();
	        
	        if(search(root, word)) 
	         System.out.println(1);
	        else 
	          System.out.println(0);
	    }
	 }
	 
	 static void insertKey(String s, TrieNode root) {
	     TrieNode curr = root;
	     int length = s.length();
	     for(int i = 0; i < length; i++) {
	         int index = s.charAt(i) - 'a';
	         
	         if(curr.child[index] == null) {
	             curr.child[index] = new TrieNode();
	         }
	         curr = curr.child[index];
	     }
	     curr.isEndOfWord = true;
	 }
	 static boolean search(TrieNode root, String s) {
	    TrieNode curr = root; 
	    
	    for(int i = 0 ; i < s.length(); i++) {
	        int index = s.charAt(i) - 'a' ; 
	        
	        if(curr.child[index] == null) 
	            return false;
            curr = curr.child[index];
	    }    
	 
	     return (curr.isEndOfWord && curr != null) ;
	 }
	
	 
	 static class TrieNode {
	     boolean isEndOfWord; 
	     TrieNode child[];
	     TrieNode() {
	         isEndOfWord = false ;
	         child = new TrieNode[26];
	         
	         for(int i = 0; i < 26; i++) {
	             child[i] = null;
	         }
	     }
	 }
}
