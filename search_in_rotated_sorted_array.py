#Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
#working mechanism: we basically first find the sorted space and then we check if the target exists in the sorted space if it exists then we move the pointers to search for the target and return the index if found. if its not found we move the pointers to checkin other space. since the input array is rotated some part of the array is sorted and some part is unsorted, so we use this property to decide which part to search next.
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target: return mid
            if nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] >= target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] <= target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
        
