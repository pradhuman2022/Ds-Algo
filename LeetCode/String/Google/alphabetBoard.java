class Solution {
    Map<Character, String> map;
    
    public String alphabetBoardPath(String target) {
    
        map = new HashMap<>();
        
        int row = 1;
        int col = 1;
        int count = 0;
        
        for (char c = 'a'; c <= 'z'; c++) {
            count++;
            if (count < 5)
                map.put(c, row+" "+col++);
            else {
                map.put(c, row++ +" "+col);
                count = 0;
                col = 1;
            }
        }
        
        String ans = "";
        
        for (int i = 0; i < target.length() - 1; i++) {
            char source = target.charAt(i);
            char dest = target.charAt(i + 1);
            
            if (source == 'z') {
                ans = upAndDown(ans, source, dest);
                ans = moveLeftAndRight(ans, source, dest);            
            } else {
                ans = moveLeftAndRight(ans, source, dest); 
                ans = upAndDown(ans, source, dest);
            }
            
            ans += "!";
        }
        
        String t = "";
        char dest = target.charAt(0);
        
        if (dest == 'z') {
            t = upAndDown(t, 'a', dest);
            t = moveLeftAndRight(t, 'a', dest); 
        } else {
            t = upAndDown(t, 'a', dest);
            t = moveLeftAndRight(t, 'a', dest); 
        }
        
        
        t = t +"!" ;
        return t + ans;
    }
    
    
    public String moveLeftAndRight(String ans, char source, char dest) {
        
        //row wise first
        String temp[] = map.get(source).split(" ");
        String temp1[] = map.get(dest).split(" ");
            
        int col1 = Integer.parseInt(temp[1]);
        int col2 = Integer.parseInt(temp1[1]);
            
        int diff = Math.abs(col1 - col2);
        if (col1 > col2) {
            while(diff-- >0)
                ans += "L";
        } else {
            while(diff-- >0)
                ans += "R";
         }
        return ans;
    }
    
    public String upAndDown(String ans, char source, char dest) {
        
        //row wise first
        String temp[] = map.get(source).split(" ");
        String temp1[] = map.get(dest).split(" ");
        
        int row1 = Integer.parseInt(temp[0]);
        int row2 = Integer.parseInt(temp1[0]);
            
        int diff1 = Math.abs(row1 - row2);
            
        if (row1 > row2) {
            while(diff1-->0)
                ans += "U";
        } else {
            while(diff1-->0)
            ans += "D";
        }
        
        return ans;
    }
}
