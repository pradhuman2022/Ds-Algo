/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    static int cards[];
    static boolean visit[] ; 
    static int dp[]; 
	public static void main (String[] args) {
		cards = new int[]{1, 1, 1, 1, 100};
		visit = new boolean[cards.length];
		dp = new int[cards.length]; 
		System.out.println(maxScore(0));
	}
	/*
	 maxScore is about to , if we select ith card then what could be maxScore while having 3choices.
	*/
	/*
	  hum log apporach souch pare the but max score kis tarah sum up krna tha ye ni ho paya.
	  basically oppenent ye dekhega ki hm log ko min value mile 
	  agar hm ith card lere hai toh oppenent ye dekkehega ki i + 2, i + 3, i + 4 aaayga
	  hm log k turn m or hm insme se minimum le paye, or i + 1 to atleast wo lega hi lega.
	  
	*/
	static int maxScore(int card) {
	    
	    if(card >= cards.length)
	        return 0;
	    
	    if(visit[card])
	        return dp[card];
	    int option2 = Integer.MIN_VALUE;
	    int option3 = Integer.MIN_VALUE;
	    
	    int option1 = cards[card] + Math.min(maxScore(card + 2), Math.min(maxScore(card + 3), maxScore(card + 4)));
	    if(card + 1 < cards.length)
	        option2 = cards[card] + cards[card + 1] + Math.min(maxScore(card + 3), Math.min(maxScore(card + 5), maxScore(card + 4)));
	    if(card + 2 < cards.length)
	        option3 = cards[card] + cards[card + 1] + cards[card + 2] + Math.min(maxScore(card + 4), Math.min(maxScore(card + 5), maxScore(card + 6)));
	           visit[card] = true; 
	    return dp[card] = Math.max(option1, Math.max(option2, option3));
	}
	
}
