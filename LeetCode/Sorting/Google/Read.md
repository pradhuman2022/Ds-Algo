With GOOGLE TAG

Pattern:
* 1:- Sorting should be used, if we want to minimize/maximize something.
* 2:- After sorting, we should take care of solution like should we calculate answer from left to right/right to left and why ?
* 3:- When you do sorting, see advantages and disadvantges as well. like if we do sort in ascending order/decesending order then what will be effect on results.
-------

**Binary Search:**
https://www.topcoder.com/thrive/articles/Binary%20Search
```
Find closest element to x

while(left < right) {
	int mid = (left + right) / 2;
	if (arr[mid] > x) { 
	right = mid;
  } else {
	 left = mid + 1;
   }
}

Find if x is present or not.

Find closest element to x

while(left <= right) {
	int mid = (left + right) / 2;
	if (arr[mid] == x) 
	 	return mid;
	
	if (arr[mid] > x) { 
	right = mid - 1;
  } else {
	  left = mid + 1;
  }
}
```
Here, remember -> answer of binary search will be on always `left`, because `while` will be terminated if `left <= right`, it means we have reached to our findings.
So left can be > than right or equal. Hence when left will be equal to right or vice versa then it will be our anwer.

-------

**Matrix Representation as one dimensional array:**

Lets say, we have following matrix and try to represent their positions using column and row values.

[0, 1, 2]

[3, 4, 5]

[6. 7, 8]

So lastIndex is 8, right? It means that (currentRow + 1) * (totalColumn) - (totalColumn - currentColumn), because 3*3 is totalNumber of elements, if we do -1 then we will get 8 as lastIndex.

lastIndex = (currentRow + 1) * (totalColumn) - 1

2ndLastIndex = (currentRow + 1) * (totalColumn) - 2

3rdLastIndex/OthIndex = (currentRow + 1) * (totalColumn) - 3

We can formulate it following way:

i == currentRow

j == currentColumn

```
position(i, j) := (cureentRow + 1) * (totalColumn) - (totalColumn - currentColumn)
position(i, j) := (currentRow * totalColumn) + totalColumn - totalColumn + currentColumn
position(i, j) := (currentRow * totalColumn) + currentColumn := (i * totalColumn) + j --> eq1
```
Okay, so we have position(i, j), now our task is to find i and j for particular position(i, j)

index 8 := 2 * 3 + 2

index 7 := 2 * 3 + 1

index 6 := 2 * 3 + 0
 p := x + j
 
 p % totalColumn = (x % totalColumn) % + (j % totalColumn) `here x is (totalColumn * i)`
 
 p % totalColumn = j
 
 hence `j = p % totalColumn`
 
 using eq1 `i = (p - j) / totalColumn`
 
 ----
 
 Merge Sort Based Questions: https://leetcode.com/tag/merge-sort/
 
 QuickSelect: https://www.geeksforgeeks.org/quickselect-algorithm/
 
 ```
 /****
    public void QuickSelect(int start, int end, int arr[], int k) {
        
        if (start == end)
            return;
        
        int pivotIndex = partition(start, end, arr);
        
        if(pivotIndex + 1 == k)
            return ;
        else if (pivotIndex + 1 < k)
            QuickSelect(pivotIndex + 1, end, arr, k);
        else
            QuickSelect(start, pivotIndex - 1, arr, k);
    }
    
    public int partition(int start, int end, int arr[]) {
        
        int pivotValue = arr[end];
        int pivotIndex = start;
        for (int i = start; i <= end; i++) {
            if(pivotValue > arr[i]) {
                swap(pivotIndex,i, arr);
                pivotIndex++;
            }   
        }
        
        swap(pivotIndex, end, arr);
        return pivotIndex;
    }
    
    public void swap(int i, int j, int nums[]) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
```
----

Arr[0, 1, 2, 3, 4, 5, 6] n = 7
kth element from last
n - k
7 - 3 = 4index value
7 - 3 + 1 = 5 will be position.

