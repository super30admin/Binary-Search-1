#TC: O(logn) SC: O(1)
#Binary Search

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]

        def binarySearchFirst(self, nums, target):
            L=0
            R=len(nums)-1
            while L<=R:
                mid=(R+L)//2
                if nums[mid]<target:
                    L=mid+1
                elif nums[mid]>target:
                    R=mid-1
                elif nums[mid]==target:
                    if mid>0 and nums[mid-1]==nums[mid]:
                        R=mid-1
                    else:
                        return mid   
            return -1
       
        def binarySearchSecond(self, nums, target):
            L=binarySearchFirst(self, nums, target)
            if L<0:
                return -1
           
            R=len(nums)-1
            while L<=R:
                mid=(R+L)//2
                if nums[mid]>target:
                    R=mid-1
                elif nums[mid]==target:
                    if mid<len(nums)-1 and nums[mid+1]==nums[mid]:
                        L=mid+1
                    else:
                        return mid   
            return -1

        return [binarySearchFirst(self,nums, target), binarySearchSecond(self,nums, target)]
