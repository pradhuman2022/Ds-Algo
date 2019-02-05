/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pradhuman
 */
public class CheckBitSet {
 
    static boolean isBitSetAtPosition(int Num , int position)
    {
        if((Num & (1 << position)) == 0)  
        {
            /*
            here we do bitwise of pow(2,position) as (1 << position) with number 
            suppose 
            we have check 2rd bit of 111011 
            then 
            111011
            000100
            ------
            000000 
            so it gives 0 as answer and it means at 2nd position bit is not set.
            
            111111
            000100
            ------
            000100
            so it will give 1 so it means at 2nd position bit is set;;;
            */
            return false ;
        }
        
        return true ;
    }
    static int doSetBitAtPosition(int Num , int position)
    {
        /*
        so we have to set bit of 1st position so we will do bitwise or with (1 << position)
        11101
        00010
        -----
        11111
        
        */
       return Num | (1 << position) ;
    }
    static int doUnSetBitAtPosition(int Num, int position)
    { 
        /*
        here we check the if at given position bit is 0 so no need to do anything just return 
        else find the no which will be  and to make bit zero ;
        */
        if((Num & (1 << position)) == 0)
            return Num ;
        else
            return Num & (Num - (1 << position )) ;
    }
    static int doFlipBitAtPosition(int Num, int position)
    {
        /*
        here we flip the bit by bitwise xor with 1 it will negate bit  ;
        */
        return Num ^ 1 ;
    }
    static String IsEvenOrOdd(int Num)
    {
     if((Num & 1) == 0)
         return "Even" ;
     return "Odd" ;
    }
  static int NoWithFirstSetBit(int Num)
    {
        int position = 1 ;
     if((Num & 1) != 0)
         return 1 ;
     while(((Num & (1 << position)) == 0))
     {
         position++ ;
     }
     return Num & (1 << position) ;
    }
}
