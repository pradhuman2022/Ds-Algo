class Solution {
    public String rearrangeString(String s, int k) {
        int freq[] = new int[26];
        
        for(int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 97]++;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> freq[b] - freq[a]);
        Queue<Integer> kDistantQueue = new LinkedList<>();
        
        for(int i = 0; i < 26; i++)
            if(freq[i] > 0)
                pq.add(i);
        
        StringBuilder ans = new StringBuilder("");
        while(!pq.isEmpty()) {
            Integer currentChar = pq.poll();
            ans.append((char)(currentChar + 97));
            freq[currentChar]--;
            
            kDistantQueue.add(currentChar);
            
            if(kDistantQueue.size() >= k) {
                int frontChar = kDistantQueue.poll();
                
                if(freq[frontChar] > 0)
                    pq.offer(frontChar);
            }
        }
        
        System.out.println(ans);
        return ans.length() == s.length() ? ans.toString() : "";
    }
}
