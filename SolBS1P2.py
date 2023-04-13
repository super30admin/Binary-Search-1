"""
-Time Complexity : O(logN)
-Space Complexity : O(1)
-Did this code successfully run on Leetcode : Yes

-Any problem you faced while coding this : No
The other approach that I followed was:
1. Find pivot index using Binary search modification (O(logN))
2. Then we have 2 subarrays 
    Left hand side of pivot index
    RHS of pivot index
    Check if which subarray can target lie in by comparing the values with the
    boundaries of the subarray and target. 
3. Using Binary search find out the target in prospective subarray
4. If found return index, else return -1

This approach is also O(logN) but takes mutiple passes. It was more intuitve to me
before today's class. 

-Your code here along with comments explaining your approach in three sentences only
It is single pass O(log(N)) solution. 

It utilizes the fact the in rotated sorted array, one half i.e LHS or RHS 
of the mid point is sorted always.
Check if the target could be in the sorted subarray, if not then move to the 
other subarray and continue diving it into LHS and RHS until target is found.
If target is never found, return -1
-
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                return mid
            #LHS side is sorted
            if nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            #RHS side is sorted
            else:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1