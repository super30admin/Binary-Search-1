
#Time Complexity :O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Approach: At each step, I checked which half of the array is sorted. If the target lies within the sorted half,
# I narrowed my search to that side. Otherwise, I shifted my search to the unsorted half.

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                #left side is sorted
                if nums[low] <= target and nums[mid] > target: # check if the target lies in the left sorted array range
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                #right side is sorted
                if nums[mid] < target and nums[high] >= target: #Check if the target lies in the right sorted array range
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
    
nums = [4, 5, 6, 7, 0, 1, 2]
target = 0
sol = Solution()
result = sol.search(nums, target)
print(result)  # Expected output: 4








        