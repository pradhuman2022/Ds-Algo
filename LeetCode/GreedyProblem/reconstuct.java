class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int x[], int y[]) {
                return x[0] == y[0] ? x[1] - y[1] : y[0] - x[0];
            }
        });
        
        List<int[]> ans = new LinkedList<>();
        
        for(int a[]: people)
            ans.add(a[1],a);
        
        return ans.toArray(new int[people.length][2]);
    }
} 
