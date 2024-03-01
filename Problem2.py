// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
'''
This is a rotated array, so regular binary search won't work. Instead I divided the array into two parts,
Left Sorted Array and Right Sorted Array.  It compares the lowest value and mid value and then decides 
whether it's left sorted array or right sorted array
'''
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            if nums[mid] == target:
                return mid
    
            #Left sorted
            if nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1

            #Right sorted
            if nums[mid] <= nums[high]:
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
