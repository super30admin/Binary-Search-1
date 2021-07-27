#Leet code problem: 162
class Solution:
    def findPeakElement(self, nums):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if (mid==len(nums)-1 or nums[mid]>nums[mid+1]) and (mid==0 or nums[mid]>nums[mid-1]):#both sides of mid are greater than mid
                return mid
            elif mid==len(nums)-1 or nums[mid]<nums[mid+1]: #if right side is greater then go to right side
                low=mid+1
            else:#else left side
                high=mid-1
        return -1

#TC: O(log n)
#SC: O(1)