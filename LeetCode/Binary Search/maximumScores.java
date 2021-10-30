class Solution {
    public int maxTwoEvents(int[][] events) {
        List<Pair> p = new ArrayList<>();

        for (int i = 0; i < events.length; i++)
            p.add(new Pair(events[i][0], events[i][1], events[i][2]));
        
        Collections.sort(p, (a, b) -> a.end - b.end);
        Map<Pair, Integer> data = new HashMap<>();
        
        for (int i = 0; i < events.length; i++){
            int start = 0;
            int end = i - 1;
            int startime = p.get(i).start;
            
            while(start < end) {
                int mid = (start + end + 1) / 2;
        
                if (p.get(mid).end >= startime) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }
             
            if (p.get(start).end < startime)
                data.put(p.get(i), start);
            else
                data.put(p.get(i), -1);
        }
        
        int a[] = new int[events.length];
        
        a[0] = p.get(0).value;
        
        for (int i = 1; i < events.length; i++)
            a[i] = Math.max(a[i - 1], p.get(i).value);
        
        int ans = 0;
        for (Map.Entry<Pair, Integer> e: data.entrySet()) {
            if (e.getValue() != -1)
                ans = Math.max(e.getKey().value + a[e.getValue()], ans);
            else
                ans = Math.max(e.getKey().value, ans);
        }
        
        return ans;
    }
    
    class Pair {
        int start;
        int end;
        int value;
        Pair(int s, int e, int v) {
            this.start = s;
            this.end = e;
            this.value = v;
        }
    }
}
