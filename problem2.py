# 33. Search in Rotated Sorted Array
# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Aproach: first find the pivot position then call binarysearch in the two halves.
class Solution:
    def search_pivot(self,nums):
        l = 0
        r = len(nums)-1
        pivot = -1
        while l < r:
            mid = (r+l)//2
            if nums[mid] > nums[mid+1]:
                pivot = mid
                break
            elif nums[mid-1] > nums[mid]:
                pivot =  mid-1
                break
            elif nums[mid] > nums[l]:
                l = mid+1
            else:
                r = mid-1
        return pivot
    
    def b_search(self,nums,left,right,target):
        res = -1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                res =  mid
                break
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return res
    
    def search(self, nums: List[int], target: int) -> int:
        if self.search_pivot(nums) == -1:
            return self.b_search(nums,0,len(nums)-1,target)
        else:
            pivot = self.search_pivot(nums)
            l_res = self.b_search(nums,0,pivot,target)
            r_res = self.b_search(nums,pivot+1,len(nums)-1,target)
            return max(l_res,r_res,-1)
            
        
        