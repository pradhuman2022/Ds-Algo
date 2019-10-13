class Compress
{
    static String generateCompressString(String str)
    {
        // add your code here
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < str.length() ;){
            int curr = i ;
            int count = 0 ;
            while(curr < str.length() && str.charAt(i) == str.charAt(curr)){
                curr++; 
                count++ ;
            }
            ans.append(Character.toString(str.charAt(i))+count);
            i = curr ; 
            
        }
        return ans.toString();
    }
}
