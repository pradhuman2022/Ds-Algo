/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    static String word ; 
    static char mat[][] ; 
    static boolean visited[][] ; 
    static int[] x = {0 , 1, -1, 0};  
    static int[] y = {1 , 0,  0 , -1};  
  
	public static void main(String[] args) {
	char [][]mat1 =  {{'A','B','C','E'},
           {'S','F','C','S'},
           {'A','D','E','E'}};
    mat = mat1 ;
    word = "ABCB" ; 
    visited = new boolean[mat1.length][mat1[0].length] ; 
    
    for(int i = 0 ; i < mat.length ; i++){
        for(int j = 0 ; j < mat[0].length; j++){
            if(isExist(0, i, j)) 
             System.out.println(true) ; 
        } 
       
    }
	    
	    
	    
	    
	}
	
	static boolean isExist(int index, int row, int col){
	    
	    
	    //if word exist 
	    if(index == word.length() - 1)
	      return true ; 
	    
	    if(row < 0 || col < 0 || row >= mat.length || col >= mat[0].length)
	      return false ;
	    
	    if(mat[row][col] != word.charAt(index)) 
	      return false ;
	    
	    visited[row][col] = true ; 
	    
	   if(word.charAt(index) == mat[row][col])  
	    for(int i  = 0 ; i < x.length; i++)
	      if(isExist(index + 1, row + x[i], col + y[i]))
	         return true ; 
	  
	   visited[row][col] = false ;   
	    
	   return false ;  
	}
}
