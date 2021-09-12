class Solution {
    public String rankTeams(String[] votes) {
      TreeMap<Character, int[]> map = new TreeMap<>();
      int l = votes[0].length();
      for(String vote : votes){
        for(int i = 0; i < l; i++){
          char c = vote.charAt(i);
          map.putIfAbsent(c, new int[l]);
          map.get(c)[i]++;
        }
      }
      
    char positions[] = new char[l];
        
    List<Character> list = new ArrayList<>(map.keySet());
    Collections.sort(list, (a, b) -> {
              System.out.println(a +" " +b);
        //if value of a and b are equal we will find a point which should have lesser/greater value then can sort
        //if value are equal for all position then sort based on their char
              for (int i = 0; i < l; i++) {
                if(map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                }
              }
              return a - b;  
          });
    
      for (int i = 0 ; i < l;i++)
          positions[i] = list.get(i);
        
      return new String(positions);
    }
}
/**

ABc
ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"

A-> 5 votes for 1st position
B -> 2 votes for 2nd pos and 3rd
C -> 3 vote for 2nd postions and 1 votes for secomd


if all teams got same votes for everyposition

Team A was ranked first by 2 voters, second by 2 voters and third by 2 voters.
Team B was ranked first by 2 voters, second by 3 voters* and third by 2 voters.
Team C was ranked first by 2 voters, second by 2 voters and third by 2 voters.
Team D was ranked first by 1 voters, second by 2 voters and third by 2 voters.*

positon[] 

ABC

*/
