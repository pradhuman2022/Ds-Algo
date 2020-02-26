class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set  = new HashSet<String>();
        
        for(String word:wordList)
            set.add(word);
        
        if(!set.contains(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                System.out.println(str);
                for(int j = 0; j < str.length(); j++) {
                    for(char c = 'a' ; c <= 'z'; c++) {
                        if(c == str.charAt(j))
                            continue;
                        String newWord = str.substring(0,j) + c + str.substring(j + 1, str.length());
                        if(newWord.equals(endWord))
                            return level + 1;
                        if(set.contains(newWord))
                        {
                            set.remove(newWord);
                            queue.add(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
