class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
        
    }
    
    /** Using Heap 5september 2021
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> b.diff - a.diff);
        ArrayList <Integer> ans = new ArrayList<>(); 
        
        for (int i = 0; i < k; i++) {
            pq.offer(new Pair (arr[i], Math.abs(arr[i] - x)));
        }
        
        //store difference
        for (int i = k ; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < pq.peek().diff) {
                pq.poll();
                pq.offer(new Pair (arr[i], Math.abs(arr[i] - x)));
            } 
        }
        
        while(!pq.isEmpty() && k-- > 0) 
            ans.add(pq.poll().value);
        
        Collections.sort(ans);
        
        return ans;
    }
    
    class Pair {
        int value;
        int diff;
        Pair(int v, int d) {
            this.value = v;
            this.diff = d;
        }
    }
    */
    
}
