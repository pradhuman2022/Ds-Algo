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
