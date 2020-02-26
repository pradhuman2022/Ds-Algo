class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> setOfWords = new HashSet<String>();
        for(String word : words)
            setOfWords.add(word);
        HashMap<String, Boolean> visited;
        List<String> ans = new ArrayList<String>();
        for(String word : setOfWords) {
             visited = new HashMap<String, Boolean>();
                if(canForm(word, visited, setOfWords)) {
                    ans.add(word);
                }   
            }
        return ans;
    }
    
    boolean canForm(String word, HashMap<String, Boolean> form, Set<String> setOfWords) {
    
        for (int i = 1; i <= word.length(); i++){
          String prefix = word.substring(0, i);
           
           if(setOfWords.contains(prefix)) {
               String suffix = word.substring(i);
               
               if((setOfWords.contains(suffix) || canForm(suffix, form, setOfWords)) && suffix.length() > 0) {
                   form.put(suffix, true);
                   return true;
               }
           } 
        }
        form.put(word, false);
        return false;
    }
}
