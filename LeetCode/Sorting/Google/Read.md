With GOOGLE TAG

Pattern:
* 1:- Sorting should be used, if we want to minimize/maximize something.
* 2:- After sorting, we should take care of solution like should we calculate answer from left to right/right to left and why ?
-------

**Binary Search:**
```
while(left <= right) {
	int mid = (left + right) / 2;
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

Matrix Representation as one dimensional array:
Lets say, we have following matrix and try to represent their positions using column and row values.

[0, 1, 2]

[3, 4, 5]

[6. 7, 8]

So lastIndex is 8, right? It means that (currentRow + 1) * (totalColumn) - (totalColumn - currentColumn), because 3*3 is totalNumber of elements, if we do -1 then we will get 8 as lastIndex.

lastIndex = (currentRow + 1) * (totalColumn) - 1

2ndLastIndex = (currentRow + 1) * (totalColumn) - 2

3rdLastIndex/OthIndex = (currentRow + 1) * (totalColumn) - 3

We can formulate it following way:
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
 
