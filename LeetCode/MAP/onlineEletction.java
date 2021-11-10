class TopVotedCandidate {

    HashMap<Integer, Integer> timeToLeader;
    Map <Integer, Integer> personToVote;
    int []time;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        timeToLeader = new HashMap<>();
        personToVote = new HashMap<>();
        this.time = times;
        
        int leader = -1;
        
        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            int time = times[i];
            
            int leaderVote = personToVote.getOrDefault(leader, 0);
            int currentPersonVote = personToVote.getOrDefault(person, 0) + 1;
            personToVote.put(person, currentPersonVote);
            
            leader = currentPersonVote >= leaderVote ? person : leader ;
            
            timeToLeader.put(time, leader);
        }
    }
    
    public int q(int t) {
        
        int start = 0;
        int end = time.length;
        
       if (timeToLeader.containsKey(t))
           return timeToLeader.get(t);
        
        while (start < end) {
            
            int mid = (start + end) / 2;
            
            if (time[mid] > t) {
                end = mid;
            } else {
                start = mid + 1;
            }  
        }
        
        return timeToLeader.get(time[start - 1]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
