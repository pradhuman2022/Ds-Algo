class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> paranthesis = new ArrayList<>();
        
        generateAllParanthesis(0, 0, n, "", paranthesis);
        return paranthesis;
    }
    
    public void generateAllParanthesis(int open, int close, int capcity, String s, List<String> paranthesis)      
{
       if (s.length() == 2*capcity) 
	paranthesis.add(s);

       if (open < capcity)
	generateAllParanthesis(open + 1, close, capcity, s + "(", paranthesis);
       if (open > close)
	generateAllParanthesis(open, close + 1, capcity, s + ")", paranthesis);
}
}

