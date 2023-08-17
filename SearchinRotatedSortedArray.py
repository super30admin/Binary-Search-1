#Time Complexity : O(logn) where n is the number of elements in nums
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We apply binary search to find the target and return the index. 

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        l = 0
        h = len(nums)-1
        while l <= h:
            mid = (l+h)//2
            if nums[mid] == target:
                return mid
            elif nums[l] <= nums[mid]:
                if ((nums[l] <= target) and (nums[mid] > target)):
                    h = mid - 1
                else:
                    l = mid + 1
            else:
                if ((nums[mid] < target) and (nums[h] >= target)):
                    l = mid + 1
                else:
                    h = mid - 1
        return -1
