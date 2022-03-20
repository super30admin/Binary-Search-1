#Time Complexity : O(log n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach

#at any given time one side is sorted. Check if the elememnt exists on that side
#and perform binary search.
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while (low <= high):
            middle = low + (high - low) // 2
            if nums[middle] == target:
                return middle
            elif (nums[low] <= nums[middle]):
                if nums[low] <= target and nums[middle] > target:
                    high = middle - 1
                else:
                    low = middle + 1
                    
            else:
                if nums[middle] < target and nums[high] >= target:
                    low = middle + 1
                else:
                    high = middle - 1
        return - 1

