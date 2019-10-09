#time:O(logn)
#space:O(1)
#LeetCode: Accepted
#Problem Faced:applying binary search in the region where the array is rotated
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l=0
        r=len(nums)-1
        while l <= r:
            mid=l+(r-l)//2
            
            #if the element at mid is target then return mid
            if nums[mid]==target:
                return mid
            #check in which half is the target element
            elif nums[mid] >= nums[l]:
                #checking weather the target is rotated half or not
                if target >= nums[l] and nums[mid] > target:
                    r = mid - 1
                else:
                    l = mid + 1
            else:
                if target <= nums[r] and target > nums[mid]:
                    l=mid+1
                else:
                    r=mid-1
        #not found the target so returning -1
        return -1