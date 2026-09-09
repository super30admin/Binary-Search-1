'''
Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach in three sentences only 

Approach: Check whwther the target is in left sorted or right sorted array. If left sorted, check if the target is between low and mid and based onthis move low and high pointers.. 
Similarly check for the right sorted array.
'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:  #left sorted
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1