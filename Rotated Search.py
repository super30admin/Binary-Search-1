# Time Complexity :O(log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

#Approach:- Find which portion of array is sorted and using first and last element of that part find weather target lies in that part and update pointer accordingly.


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l=0
        r=len(nums)-1
        while(l<=r):
            mid=l+(r-l)//2
            if(nums[mid]==target):
                return mid
            if(nums[l] <= nums[mid]):
                if target > nums[mid] or target < nums[l]:
                    l = mid + 1
                else:
                    r = mid - 1
            
            else:
                if target < nums[mid] or target > nums[r]:
                    r = mid - 1
                else:
                    l = mid + 1
        return(-1)