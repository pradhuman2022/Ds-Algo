***Binary Search:*** https://www.topcoder.com/thrive/articles/Binary%20Search

0	  5	  13  19	22	41	55  68  72	 81	 98
no	no	no	no	no	no	yes	yes	yes	yes	yes

find just greater than 55
```
binary_search(lo, hi, p):
  while lo < hi:
  mid = lo + (hi - lo) / 2
if p(mid) == true:
  hi = mid
else :
  lo = mid + 1
if p(lo) == false:
  complain // p(x) is false for all x in S!

return lo // lo is the least x for which p(x) is true
```
-----
Binary Search In Detail: https://leetcode.com/discuss/general-discussion/786126/python-powerful-ultimate-binary-search-template-solved-many-problems
