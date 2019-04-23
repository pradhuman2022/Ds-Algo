import java.util.* ;
public class Hate_A {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner (System.in) ;
        int n = sc.nextInt() ; 
        sc.nextLine() ;
        while(n-- > 0)
        {    
        String s1= sc.nextLine() ;
        int lc = -1 ; 
        int uc = -1;
        int num  = -1 ;
        for(int i = 0; i < s1.length() ; i++)
        {
            if(Character.isDigit(s1.charAt(i)))     num = i ;
            if(Character.isUpperCase(s1.charAt(i))) uc = i ;
            if(Character.isLowerCase(s1.charAt(i))) lc = i ;
        }
        if(num != -1 && uc != -1 && lc != -1)
        {
            System.out.println(s1) ;
            continue ;
        }
         
         else{
             if(lc == -1)
                 for(int i = 0 ; i < s1.length() ;i++)
                     if(uc != i && num != i) {s1 = s1.substring(0, i) + "a" + s1.substring(i + 1, s1.length()); lc = i; break ;} 
             if(uc == -1)
                 for(int i = 0 ; i < s1.length() ;i++)
                     if(lc != i && num != i) {s1 = s1.substring(0, i) + "A" + s1.substring(i + 1, s1.length()) ; uc = i ;break ;}
             if(num == -1)
             for(int i = 0 ; i < s1.length() ;i++)
                     if(uc != i && lc != i) {s1 = s1.substring(0, i) + "1" + s1.substring(i + 1, s1.length()) ; break ;} 
         }
        System.out.println(s1) ;
    }
    }
  
}
