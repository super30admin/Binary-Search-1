class Solution:
    def search(self, nums: List[int], target: int) -> int:
        """
        Time Complexity: O(log(n))
        Space Complexity: O(1)
        Did this code successfully run on Leetcode: Yes 
        Any problem you faced while coding this:

        I had to refer to the logic taught in the class

        Your code here along with comments explaining your approach:
        The approach: 
            -> if nums[mid] == target return mid 
            -> Check if the left array is sorted or right array is sorted
            -> If it's left sorted array check whether the target lies in that range 
                -> if target lies then high = mid - 1 
                -> else low = mid + 1
            -> If it's right sorted array check whether the target lies in that range 
                -> if target lies then low = mid + 1 
                -> else high = mid - 1
        """
        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = int(low + (high - low)/2)
            if nums[mid] == target:
                return mid
            elif (nums[low] <= nums[mid]):
                # Left Sorted
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else: 
                    low = mid + 1
            else:
                #Right Sorted
                if nums[high] >= target and nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid -1
        return -1