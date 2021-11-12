class Solution {
    
    int visited[];
    HashMap<Character, Set<Character>> graph;
    HashSet<Character> set ;
    Stack<Character> st;
    public String alienOrder(String[] words) {
        
        graph = new HashMap<>();
        visited = new int[26];
        set = new HashSet<>();
        if (!buildGraph(words, graph, set))
            return "";
        
        st = new Stack<>();

        for (char c: set) {
            if (visited[c - 'a'] == 0) {
                if (dfs(c))
                    return "";
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(!st.isEmpty())
            ans.append(st.pop());
        
        return ans.toString();
    }
    
    public boolean dfs(char source) {
        
        visited[source - 'a'] = 1;
        System.out.println(source+ " " + graph);
        
        for (char child: graph.getOrDefault(source, new HashSet<>())) {
            if (visited[child - 'a'] == 1 || (visited[child - 'a'] == 0 && dfs(child)))
                return true;   
        }
        
        visited[source - 'a'] = 2;
        st.push(source);
        
        return false;
    }
    
    
    public boolean buildGraph(String [] words, HashMap<Character, Set<Character>> graph, HashSet<Character> set) {
        
        
        for (int i = 0; i < words.length; i++) {
             
            String word1 = words[i];
     
            for (char c: words[i].toCharArray())
                set.add(c);
            
            if (i == words.length - 1) {
                break;
            }
            
            String word2 = words[i + 1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2))
                return false;
        
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    Set<Character> adjList = graph.getOrDefault(word1.charAt(j), new HashSet<>());
                    adjList.add(word2.charAt(j));
                    graph.put(word1.charAt(j), adjList);
                    break;
                }  
            }
        }
        return true;
    }
}
