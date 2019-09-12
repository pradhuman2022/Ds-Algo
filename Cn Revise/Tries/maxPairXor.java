/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pradhuman
 */
public class trieNode {
    trieNode left ;
    trieNode right ;
    
    public static void main(String arg[])
    {
        trieNode head = new trieNode() ;
        int arr[] = new int[]{1,2,15,8,5,10} ;
        for(int i = 0 ; i < arr.length ; i++)
            insertNode(head, arr[i]) ; 
        
        int max_Xor = Integer.MIN_VALUE ;
        
        for(int i = 0 ; i < arr.length; i++)
        {
            max_Xor = Math.max(max_Xor, findMaxXor(arr[i], head,i)) ;
        }
        System.out.println(max_Xor) ;
    }
    
    static void insertNode(trieNode head, int n)
    {
         trieNode curr = head ;
         for(int i = 31 ; i >= 0 ; i--)
         {
             int bitVal = (n >> i) & 1 ; 
             System.out.println(bitVal) ;
             if(bitVal == 0)
             {
                 if(curr.left == null)
                      curr.left = new trieNode() ;
                // else
                     curr = curr.left ;    
             }else
             {
                 if(curr.right == null)
                      curr.right = new trieNode() ;
                 //else
                     curr = curr.right ;
             }
             
         }
    }
    
    static int findMaxXor(int value, trieNode head, int k)
    {
        int cur_Xor = 0 ;
        trieNode curr = head ;
        for(int i = 31 ; i >= 0; i--)
        {
            int bitVal = (value >> i) & 1 ;            
            
         //   System.out.println(k+" "+k);
            if(bitVal == 0)
            {
                if(curr.right != null)
                {
                    curr = curr.right ;
                    cur_Xor += Math.pow(2,i) ;    
                }else{
                    curr = curr.left;
                }
            }else{
                if(curr.left != null)
                {
                    curr = curr.left ;
                    cur_Xor += Math.pow(2,i);
                }else
                {
                    curr = curr.right ;
                }
            }
            
        }
       return cur_Xor ; 
    }
}
