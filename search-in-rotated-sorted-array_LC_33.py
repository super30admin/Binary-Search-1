#TC:O(logn) SC:O(1)
#Binary Search

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1

        L=0
        R=len(nums)-1
       
        while L <= R:
            mid=(R+L)//2
            if nums[mid] == target:
                return mid
            if nums[L] <= nums[mid]:
                if (target >= nums[L] and target < nums[mid]):
                    R = mid-1 
                else: L = mid+1
            else:
                 if (target > nums[mid] and target <= nums[R]):
                     L = mid+1
                 else: R = mid-1
           
        return -1
