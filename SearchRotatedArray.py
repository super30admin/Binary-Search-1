# // Time Complexity : O(log(m*n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach in three sentences only
# Standard binary search approach is used. When the array gets rotated, it remains sorted on both sides of the pivot.  
# Find the half where the array is sorted and apply the binary search
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        low, high = 0, len(nums)-1
        while low <= high:
            mid = (low+high)//2
            if nums[mid] == target:
                return mid
            # search in the sorted part of the array 
            if  nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] > target:
                    high = mid -1
                else:
                    low = mid + 1
            else:
                if nums[high] >= target and nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid -1
        return -1