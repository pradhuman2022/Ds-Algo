class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        
        int i = 0, j = 0, k = 0;
        //int minLen = Math.min(arr1.length, Math.min(arr2.length, arr3.length));
        List<Integer> newList = new ArrayList<>();
        
        while(i < arr1.length && j < arr2.length && k < arr3.length) {
            
            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                newList.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
            
            if(arr1[i] < arr2[j]) {
                i++;
            } else if(arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
            }
        } 
        return newList;
    }
}
