class Solution {
     Map<Character, List<Character>> adjList;
    public String alienOrder(String[] words) {
       
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> charSet = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        
        for(int i = 0; i < words.length; i++)  {
            for(int j = 0 ; j < words[i].length(); j++) 
                charSet.put(words[i].charAt(j), 0);
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    List<Character> list = adjList.getOrDefault(word1.charAt(j), new ArrayList<>());
                    list.add(word2.charAt(j));
                    adjList.put(word1.charAt(j), list);
                    break;
                }
            }
        }
        
        this.adjList = adjList;
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i = 0 ; i < 26; i++) {
            int onStack[] = new int[26];
            if(!visited.contains((char)(i + 97)) && charSet.containsKey((char)(i + 97))) {
               if(topoSort(st, (char) (i + 97), visited, onStack))
                   return "";
            }
        }
        visited = null;
        adjList = null;
        charSet = null;
        System.gc();
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        
        return ans.toString();
    }
    
    public boolean topoSort(Stack<Character> st, Character source, Set<Character> visited, int onStack[]) {
        
        if(onStack[source - 97] == 1)
            return true;
        
        onStack[source - 97] = 1;
        for (Character nextChar: adjList.getOrDefault(source, new ArrayList<>())) {
            if(!visited.contains(nextChar)){
                if(topoSort(st, nextChar, visited, onStack))
                    return true;
                System.out.println(nextChar);
            }
        }
        
        onStack[source - 97] = 0;
        if(!visited.contains(source))
            st.push(source); 
        visited.add(source);
        return false;
    }
}
