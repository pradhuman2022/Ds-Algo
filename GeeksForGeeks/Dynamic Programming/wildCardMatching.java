class GfG
{
    String text ;
    String pattern;
    int N;
    int M;
    int wildCard(String pattern, String str)
    {
        // Your code goes here
        this.pattern = pattern; 
        this.text = str;
        N = text.length();
        M = pattern.length();
        return wildCard(text.length(), pattern.length()) == true ?1:0;
    }
    /*
    i was troubled with base cases, baki ignore or include wala krdia tha 
    mne.
    
    */
    boolean wildCard(int n, int m) {
        if(n == 0 && m == 0)
            return true;
        if(n == 0 && m > 0) {
            if(pattern.charAt(m - 1) == '*')
                return wildCard(n, m - 1);
            return false;
        }
        if(n > 0 && m == 0)
            return false;
        if(text.charAt(n - 1) == pattern.charAt(m - 1) || pattern.charAt(m - 1) == '?')
            return wildCard(n - 1, m - 1);
        else if(pattern.charAt(m - 1) == '*')
            return wildCard(n - 1, m) || wildCard(n, m - 1);
        else 
            return false;
    }
    
    
}
