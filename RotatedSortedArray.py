#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums)-1
        while(start<=end):
            mid = start + (end-start)//2
            if nums[mid] == target:
                return mid
            if nums[start]<=nums[mid]:
#First part is sorted
                if target<nums[mid] and target>=nums[start]:
                    end = mid -1
                else:
                    start = mid+1
            else:
#Second part is sorted
                if nums[mid]<target and nums[end]>=target:
                    start = mid+1
                else:
                    end = mid-1
        return -1