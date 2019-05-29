public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	   
	   int count1 = 0 ;
	   int count2 = 0 ;
	   int max1 = Integer.MAX_VALUE; 
	   int max2 = Integer.MAX_VALUE ;
	   int i = 0 ;
	   for(int x : a)
	   {
	       if(x == max1)
	       count1++ ;
	       else if(x == max2)
	       count2++ ;
	       else if(count1 == 0)
	       {
	           count1 = 1 ;
	           max1 = x ;
	       }
	       else if(count2 == 0)
	       {
	           count2 = 1 ;
	           max2 = x ;
	       }
	       else
	       {
	           count1-- ;
	           count2-- ;
	       }
	   }
	   int realCount1 = 0; 
	   int realCount2 = 0 ;
	   
	   for(int x : a)
	   {
	       if(max1 == x)
	       realCount1++ ;
	       else if(max2 == x) 
	       realCount2++ ;
	   }
	   if(realCount1 > a.size() / 3)
	   return max1 ;
	   if(realCount2 > a.size()/ 3)
	   return max2 ;
	   
	   return -1 ;
	   
	}
}
