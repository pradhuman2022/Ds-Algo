Given a 9*9 sudoku board, in which some entries are filled and others are 0 (0 indicates that the cell is empty), you need to find out whether the Sudoku puzzle can be solved or not i.e. return true or false.
Input Format :
9 Lines where ith line contains ith row elements separated by space
Output Format :
 true or false
Sample Input :
9 0 0 0 2 0 7 5 0 
6 0 0 0 5 0 0 4 0 
0 2 0 4 0 0 0 1 0 
2 0 8 0 0 0 0 0 0 
0 7 0 5 0 9 0 6 0 
0 0 0 0 0 0 4 0 1 
0 1 0 0 0 5 0 8 0 
0 9 0 0 7 0 0 0 4 
0 8 2 0 4 0 0 0 6
Sample Output :
true
Download Test Cases

Main Code

1
​
2
    public class Solution {
3
    
4
    
5
  
6
    
7
    static boolean sudokuSolver(int board[][])
8
    {
9
          
10
       int position[]= new int[2] ; 
11
    if(!findPosition(board, position))
12
    {
13
      return true;  
14
    }
15
     
16
    for(int i = 1 ; i <= 9 ; i++)
17
    {
18
    if(checkValid(board, position[0], position[1], i))
19
    {
20
        board[position[0]][position[1]] = i ;
21
   
22
    if(sudokuSolver(board))
23
    {
24
        return true ;
25
    }
26
   
27
    board[position[0]][position[1]] = 0 ;  
28
  
29
    }
30
    }
31
    
32
    
33
     return false ;   
34
    }
35
    
36
    static boolean findPosition(int board[][], int pos[])
37
    {
38
        for(int i = 0 ; i < 9; i++)
39
        {
40
            for(int j =0 ; j< 9; j++)
41
            {
42
                if(board[i][j] == 0)
43
                {
44
                    pos[0] = i;
45
                    pos[1] = j;
46
                    return true ;
47
                }
48
            }
49
        }
50
            return false ;
51
    }
52
    static boolean checkValid(int board[][],int row, int col, int value)
53
    {
54
       //check for 3x3 matrix
55
        int rowF = row - (row % 3);
56
        int colF = col - (col % 3);
57
        for(int i = 0; i < 3 ; i++ )
58
        {
59
            for(int j = 0;  j < 3; j++)
60
            {
61
                if(board[i + rowF][j + colF] == value)
62
                    return false ;
63
            }
64
        }
65
        //check in row 
66
       for(int i = 0 ; i < 9; i++)
67
       {
68
           if(board[row][i] == value)
69
               return false ;
70
           
71
       }
72
        for(int i = 0; i < 9; i++)
73
        {
74
            if(board[i][col] == value)
75
                return false ;
76
        }
77
                
78
                return true ;
79
    }
80
    
81
    
82
    
83
    
84
}
85
​

CUSTOM INPUT


