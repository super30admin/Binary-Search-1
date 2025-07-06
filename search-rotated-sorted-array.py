"""
https://leetcode.com/problems/search-in-rotated-sorted-array/description/

A classical binary search dies because the array isn’t globally sorted, but one of the two halves around mid always is sorted. At each step we can decide:
Which half is sorted?
If nums[L] <= nums[M], left side is sorted; else the right side is sorted.
Is target inside that sorted half’s range?
If yes, shrink into that half; otherwise dive into the other half.

Same logic is applied when the array is reverse sorted.

Edge cases:
empty array
length 1
target equals 1st, last or mid element

Time Complexity:O(logn)
Space Complexity: O(1)
"""

class Solution:
  def search(self, nums, target):
    if len(nums) == 0:
      return -1
    
    low = 0
    high = len(nums) - 1
    
    while low <= high:
      mid = (high + low)//2
    
      if nums[mid] == target:
        return mid 
      
      if nums[low] <= nums[mid]: #LHS is sorted
        if nums[low] <= target < nums[mid]: #searching in sorted LHS
          high = mid - 1
        else:
          low = mid +  1 #switch to unsorted RHS
      else: 
        if nums[mid] <= nums[high]: #RHS is sorted
          if nums[mid] < target <= nums[high]: #searching in sorted RHS
            low = mid + 1
          else:
            high = mid - 1 #switch to unsorted LHS.
    return -1
  
  
nums = [4,5,6,7,0,1,2]
target = 3
sol = Solution()
print(sol.search(nums, target))