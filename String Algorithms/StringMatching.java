/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pradhuman
 */


public class StringMatching {

public static void main(String ar[])
{
    java.util.Scanner sc = new java.util.Scanner(System.in) ;
    String s = sc.nextLine() ; 
    String p = sc.nextLine() ;
    
    System.out.println(isMatched(s, p) == true ? "Pattern Found" : "Not Found") ;
}
    static boolean isMatched(String s, String p)
    {
        int n = s.length() ;
        int m = p.length() ;
        
        for(int i = 0 ; i <= n - m; i++)
        {
               boolean isFound = true ;
               
               for(int j = 0 ; j <= m ; j++)
               {
                   if(s.charAt(i + j) != p.charAt(j))
                   {
                       isFound = false ;
                       break;
                   }
                   
                   if(isFound)
                   {
                       return true ;
                   }
               }
             
        }
        return false ;
    }
}
    

