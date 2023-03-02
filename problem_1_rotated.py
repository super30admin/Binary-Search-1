# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)-1
       

        while left <= right: 
            mid = (left+right)// 2 


            if nums[mid] == target: 
                return mid 
            elif nums[mid] >= nums[left]:  #left sub array is sorted
                if target < nums[mid] and target >= nums[left]: 
                    right = mid -1 
                else : 
                    left = mid+1 
            else : # right sub array is sorted
                if target > nums[mid] and target <= nums[right]: 
                    left = mid + 1 
                else : 
                    right = mid -1 

        return -1 


        