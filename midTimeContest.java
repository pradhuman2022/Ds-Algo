/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pradhuman
 */
import java.util.*;
public class Contest {
    public static void main(String arp[])
    {
        Scanner sc = new Scanner(System.in) ;
        String startTime = sc.nextLine() ;
        String endTime = sc.nextLine() ;
        String shh[] = startTime.split(":") ;
        String ehh[] = endTime.split(":") ;
    //--------------------------------------------------    
        Integer sh = Integer.parseInt(shh[0]) ;
        Integer sm = Integer.parseInt(shh[1]) ;
   //----------------------------------------------------
        Integer eh = Integer.parseInt(ehh[0]);
        Integer em = Integer.parseInt(ehh[1]) ;
  
        sm += sh *60 ;
        em += eh *60 ;
        int midm = (sm + em) / 2 ;
        System.out.printf("%02d:%02d",midm / 60, midm % 60) ;
        
    }
}
