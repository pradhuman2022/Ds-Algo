class TopVotedCandidate {

    HashMap<Integer, Integer> personToVote;
    HashMap<Integer, Integer> timeToLeader;
    int times[];

    public TopVotedCandidate(int[] persons, int[] times) {
        int leader = -1;
        this.times = times;
        personToVote = new HashMap<>();
        timeToLeader = new HashMap<> ();

        for (int i = 0; i < persons.length; i++) {
            
            int person = persons[i];
            int time = times[i];

            int totalVotesOfCurrentPerson = personToVote.getOrDefault(person, 0) + 1;
            int leaderVote = personToVote.getOrDefault(leader, 0);

            personToVote.put(person, totalVotesOfCurrentPerson);

            leader = totalVotesOfCurrentPerson >= leaderVote ? person : leader;
            timeToLeader.put(time, leader);
        }
    
    }
    
    public int q(int t) {
        
        int start = 0;
        int end = times.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (times[mid] > t) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return timeToLeader.get(times[start - 1]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
