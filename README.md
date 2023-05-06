# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

Time Complexity 0(logn)
Approach:

1. Consider matrix like a 1D sorted list
2. Define 'low' and 'high' ptr's. 
3. low = 0
4. high = m*n - 1 (m*n is number of elements in matrix)
5. Cal mid = (high-low)//2
6. Now get the mid value
    6.1. To get row = mid//(n); where (n) is number of columns
    6.2  To get col = mid%n; where (n) is number of columns
    6.3 midValue = matrix[row][col]
7. If target < midValue
    7.1 Iterate LHS 
    7.2 low will remain same
    7.3 high will be mid-1
8. If target > midValue
    7.1 Iterate RHS 
    7.2 low will be mid+1
    7.3 high will remain same   


## Problem1 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

Approach:
1. Perform binarySearch
2. If target<A[mid]
	2.1. perform recursive binarySearch on the LHS
	2.2. If a MATCH, return the index position
	2.3. If not a MATCH, -1 will be returned
	2.4. If -1 is returned, now perform recursive binarySearch on the RHS
3. If target>A[mid]
	Vic-Versa of step 2 and sub steps
4. We will return index if out target == A[mid]

Follow Up question:
[Binary Search 2] https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

## Problem2
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

Example: [1,2,3,4,5] is provided array of unknown size
1. Our low = 0 and high = 1
2. If target > low; 
	2.1. Height will be updated to 2 time the current high i.e. new (high) = 2* previous (high)
	2.2. Our low = previous (High)
3. If target<high:
	3.1. Perform binarySearch in current low and high range
4. If target == high:
	return the index high which is our result