class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
    }
    
    public int romanToInt(String s) {
        int i = 0;
        int sum = 0;
        
        while(i < s.length()) {
            String currentSymbol = Character.toString(s.charAt(i));
            int currentValue = map.get(currentSymbol);
            int nextValue = 0; 
            
            if(i + 1 < s.length()){
                nextValue = map.get(Character.toString(s.charAt(i + 1)));
            }
            
            if(currentValue < nextValue) {
                sum += nextValue - currentValue;
                i += 2;
            } else {
                sum += currentValue;
                i++;
            } 
        }
        
        return sum;
    }
}
