class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        TreeMap<Integer, Integer> pq = new TreeMap<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int element[][] = new int[queries.length][2];
        
        for (int i = 0; i < queries.length; i++) {
            element[i][0] = queries[i];
            element[i][1] = i;
        }
        
        Arrays.sort(element, (a, b) -> a[0] - b[0]);
        int ans[] = new int[queries.length];
        
        int j = 0;
        
        for (int i = 0; i < queries.length; i++) {
            while(j < intervals.length && element[i][0] >= intervals[j][0]) {
                pq.put(intervals[j][1] - intervals[j][0] + 1, intervals[j][1]);
                j++;
            }
        
            while (!pq.isEmpty() && pq.firstEntry().getValue() < element[i][0])
                pq.pollFirstEntry();
            
            ans[element[i][1]] = pq.isEmpty() ? -1 : pq.firstKey();
        }
        
        return ans;
    }
}

/***
 [[1,4],[1, 2], [2,4], [3,6],[4,4]], queries = [2,3,4,5,6]
 
 2-> [1, 4] [1, 2] [2, 4] we are looking for start time should be equal or lesser than q[i]
 3-> [1,4] [2, 4] [3, 6]
 4-> [1,4] [2, 4] [3, 6] [4, 4]
 \
 
 4, 4 -> 0
 3, 4 -> 
 
 we can sort intervals with starting time and find a window in which a q[i] can lie using binary search


[1, 3], [2, 5]
3 , 4
1, 2, 3, 5
a  a. d. d

create heap with based on minimum length
then sort queries if X (< X + 1) is not able to be in that interval so all queries greater than x will not be able

if yes then make it current interval then go for and check if 


first need to Z
 
**/
