class SnapshotArray {

    HashMap<Integer, TreeMap<Integer, Integer>> snapShotMap = new HashMap<>();
    int currentSnapId = 0;
    
    public SnapshotArray(int length) {
        this.len = length;
        for (int i = 0; i < length; i++) 
            snapShotMap.put(i, new TreeMap<>());
    }
    
    public void set(int index, int val) {
        snapShotMap.get(index).put(currentSnapId, val);
    }
    
    public int snap() {
        return currentSnapId++;
    }
    
    public int get(int index, int snap_id) {
        
        if (snapShotMap.get(index).containsKey(snap_id))
            return snapShotMap.get(index).get(snap_id);
        
        try {
            return snapShotMap.get(index).lowerEntry(snap_id).getValue();
        } catch (Exception e) {
            return 0;
        }
    }
}

