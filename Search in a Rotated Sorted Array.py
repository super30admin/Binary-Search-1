# Assign low to 0 and high to n-1. FInd the mid and check which side of the array 
# is sorted. If array[low]<=array[mid] the left is sorted else the right is sorted. 
# Check which side the target lies by checking the range. If the left is where it lies,
#  decrease high to mid -1 else increase low to mid + 1.

# Time complexity: O(logn)
# Space complexity : O(1)

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = (low+high)//2
            if nums[mid]==target:
                return mid
            else:
                if nums[low]<=nums[mid]:
                    #left sorted
                    if target>=nums[low] and target<nums[mid]:
                        high=mid-1
                    else:
                        low = mid+1

                else:
                    #right sorted
                    if nums[mid]<target and target<=nums[high]:
                        low = mid+1
                    else:
                        high = mid -1
        return -1
            