#Leetcode problem: 33
class Solution:
    def search(self, nums, target):
        low=0
        high=len(nums)-1

        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                return mid
            elif nums[low]<=nums[mid]:#Left part of the array is sorted
                if target>=nums[low] and target<nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
            else:#right part of the array is sorted.
                if target>nums[mid] and target<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return -1

#Time complexity: O(log n)
#Space complexity: O(1)
#Leetcode Status: All test cases passed.