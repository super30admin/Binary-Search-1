# // Time Complexity :O(log n)
# // Space Complexity :O(1) as no extra space is used
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
'''
Pattern: No matter mid position atleast one side of it will be sorted
First check if the middle is the target
we check if left side is sorted if num at low position is less than or equal to mid one ; equality because if there's only one element
  check if the num in range of left sorted
 Then check if right sorted 
  check if it is in that right range
'''
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
        
