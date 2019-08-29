import java.util.*;
public class Main {
	public static void main(String[] args){
        	int arr[] = new int[]{1,3,4,7,2,1};
			System.out.println(minJumps(0, arr.length -1, arr));
        
	}
	static int minJumps(int idx, int target, int arr[])
   {
   	if(idx == target)
   	  return 1;
   	if(idx > target)
   	 return 0;
   	 
   	 int jumps = Integer.MAX_VALUE ;
   	 for(int i = 1 ; i <= arr[idx]; i++)
   	 {
   	 	jumps = Math.min(1 + minJumps(idx + i , target ,arr), jumps);
        }
        return jumps ;
   }
}
