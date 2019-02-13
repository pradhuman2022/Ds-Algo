There is a company named James Peterson & Co. The company has ‘n’ employees. The employees have skills from 0 to n-1. All the employees have distinct skills. The manager of James Peterson & Co. wants to sort the employees on the basis of their skills in ascending order. He is only allowed to swap two employees with having absolute difference between their skills as 1. He is given the skills of employees in an array of size ‘n’. He can swap the skills as long as the absolute difference between their skills is 1. You need to help the manager out and tell whether it is possible to sort the skills of employees or not.
Input Format:
First Line will have an integer ‘t’ denoting the no. of test cases.
First line of each test case contains an integer ‘n’ denoting the no. of employees in the company.
Second line of each test case contains ‘n’ distinct integers in the range [0, n-1].
Output Format:
For each test case, print “Yes” if it is possible to sort the skills otherwise “No”.
Constraints:
1 <= t <= 10
1 <= n <= 10^5
Sample Input:
2
4
1 0 3 2
3
2 1 0
Sample Output:
Yes
No
Explanation:
In first T.C., [1, 0, 3, 2] -> [0, 1, 3, 2] -> [0, 1, 2, 3]
In second T.C., [2, 1, 0] -> [1, 2, 0]  OR  [2, 1, 0] -> [2, 0, 1] So, it is impossible to sort.
Download Test Cases


1
import java.util.*;
2
​
3
public class Main {
4
  
5
    public static void main(String[] args) {
6
        Scanner in = new Scanner(System.in);
7
        int t = in.nextInt() ;
8
       while(t > 0)
9
       {
10
         int n = in.nextInt() ;
11
         
12
         int skills[] = new int[n] ;
13
         
14
         for(int i = 0 ; i < n ; i++)
15
         {
16
           skills[i] = in.nextInt() ;
17
         }
18
         mergeSort(skills, 0 , skills.length - 1) ;
19
         System.out.println(isSortedArray(skills)) ;
20
         t--;
21
       }
22
      
23
    
24
                          
25
    }
26
 static void mergeSort(int skills[] , int start , int end) 
27
{
28
    if(start >= end) 
29
        return ;
30
    int mid = (start + end) / 2 ;
31
    mergeSort(skills, start, mid) ;
32
    mergeSort(skills, mid + 1 , end) ;
33
    merge(skills, start, end , mid) ;
34
}
35
static  void merge(int skills [], int start, int end , int mid)
36
 {
37
    
38
     int leftPointer = skills[mid];
39
     int rightPointer = skills[mid + 1];
40
    
41
     if(leftPointer > rightPointer)
42
     {
43
         skills[mid + 1] = leftPointer ;
44
         skills[mid] = rightPointer ;
45
     }
}
     static String isSortedArray(int skills[])
  {

    

       for(int i = 0 ; i < skills.length ; i++)
        {

         if(skills[i] != i )

         {
          return "No" ;
59
         }
60
     }
61
    
62
     return "Yes" ;  
63
    }
64
​
65
  }
