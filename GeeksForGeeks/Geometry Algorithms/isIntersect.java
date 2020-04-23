import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	  //coder
	    Scanner sc = new Scanner(System.in); 
	    int testCase = sc.nextInt();
	    
	    while(testCase-->0){ 
	        Line line1 = new Line(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()); 
	        Line line2 = new Line(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
	        int o1 = getOrentation(line1, line2.x1, line2.y1); 
	        int o2 = getOrentation(line1, line2.x2, line2.y2);
	        int o3 = getOrentation(line2, line1.x1, line1.y1);
	        int o4 = getOrentation(line2, line1.x2, line1.y2);
	        
	        if(o1 != o2 || o3 != o4)
	            print(1);  
	        else if(o1 == 0 && onSegment(line1, line2.x1, line2.y1))
	            print(1); 
	        else if(o2 == 0 && onSegment(line1, line2.x2, line2.y2))
	            print(1); 
	        else if(o3 == 0 && onSegment(line2, line1.x1, line1.y1))
	            print(1);
	        else if(o4 == 0 && onSegment(line2, line1.x2, line1.y2))
	            print(1); 
	        else
	            print(0); 
	    }
	 }
	 static void print(int value){
	     System.out.println(value) ; 
	 }
	 static int getOrentation(Line l, int qx, int qy) {
	    int oreantation = (l.y2 - l.y1) * (qx - l.x2) - (qy - l.y2) * (l.x2 - l.x1) ;
	    if(oreantation == 0)
	        return 0 ;
	    return oreantation < 0 ? 2 : 1 ;
	 }
	 static boolean onSegment(Line l, int px, int py) {
	     
	     if(px <= Math.max(l.x1, l.x2) && px >= Math.min(l.x1, l.x2) && py <= Math.max(l.y1, l.y2) && py >= Math.min(l.y1, l.y2))
	        return true ;
	     return false ; 
	 }
	 static class Line {
	     int x1, y1, x2, y2 ; 
	     Line(int x1, int y1, int x2, int y2) {
	         this.x1 = x1;
	         this.y1 = y1; 
	         this.x2 = x2;
	         this.y2 = y2;
	     }
	 }
}
