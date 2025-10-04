# SEARCH IN ROTATED SORTED ARRAY
# https://leetcode.com/problems/search-in-rotated-sorted-array/description/
class Solution(object):
    def search(self, nums, target):
        """
        Since its a partially rotated array half of array will be sorted out and we will have to do the comparisons and accordingly do binarys search
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        #initialize low and high boundary
        low, high = 0, len(nums)-1
        while (low<=high):
            #get mid index
            mid = (low + high)//2
            if(nums[mid]==target):
                return mid
            ##Left side sorted, check if target lies between low index and mid and accordingly update high index else update low index if target lies on right side
            if(nums[low] <= nums[mid]):
                if(nums[low]<=target < nums[mid]):
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if(nums[mid]<target<=nums[high]):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
