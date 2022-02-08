# Time: O(logn)
# Space: O(1)
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        while left <= right:
            #print(left, right)
            middle = (left+right)/2
            if nums[middle] == target:
                return middle
            elif nums[left] <= nums[middle]:
                if target < nums[middle] and nums[left] <= target:
                    right = middle - 1
                else:
                    left = middle + 1
            else:
                if target > nums[middle] and nums[len(nums)-1] >= target:
                    left = middle + 1
                else:
                    right = middle - 1
        return -1
                
        
