# involves partitioning the list in 2 halves
# if mid > left , see if target > mid and target < left , reduce left subspace
# if in right sorted portion , reduce subspace accordingly


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left,right=0,len(nums)-1
        
        while left <= right :
            mid = (left + right)//2

            if target == nums[mid]:
                return mid 

            # left sorted position
            if nums[left] <= nums[mid] :
                if target > nums[mid] or target < nums[left]:
                    left = mid + 1
                else :
                    right = mid - 1
            
            # right sorted portion
            else :
                if target < nums[mid] or target > nums[right]:
                    right = mid - 1
                else :
                    left = mid + 1
            

        return -1 
