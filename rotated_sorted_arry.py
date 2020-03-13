"""
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had some back and forth in trying to 
set the low and high

// Your code here along with comments explaining your approach
Algorithm Explanation
    - Maintaining that one side is always sorted based on check between low and mid and high and mid
    - We try to search for target in opposite end of array
Cases
    - If nums[low] less than or equal nums[mid]
        - Check if target is between low and mid - set high = mid - 1 else low = mid + 1
    - Else
        - Check if target is between mid and low - set low = mid + 1 else high = mid - 1
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        low,high = 0,len(nums) - 1
        mid = (low + high) // 2
        while low <= high:
            mid = (low + high) // 2
            # print(low,high,mid)
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]:
                # search in opposite end of sorted array
                if target in range(nums[low], nums[mid]):
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # search in opposite end of sorted array
                if target in range(nums[mid], nums[low]):
                    low = mid + 1
                else:
                    high = mid - 1
            
            # if nums[mid] < nums[mid-1] and nums[mid] > nums[mid+1]:
            #     break
            # if nums[mid]
        return -1