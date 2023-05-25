# Time Complexity : O(log(m*n))
# Space Complexity :O(1)
# Failed on leetcode passed 122/195 test cases passed

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def findPivot(nums):
            l = 0
            r = len(nums) - 1

            while l <= r:
                if nums[l] > nums[r]:
                    r -= 1
                    l += 1
                else:
                    return l
            return 0
        
        pivotIndex = findPivot(nums)
        pivotValue = nums[pivotIndex]

        if pivotIndex != 0:
        
            if target > pivotValue:
                l = 0
                r = pivotIndex
            else:
                l = pivotIndex
                r = len(nums) - 1
        else:
            l = 0
            r = len(nums) - 1


        
        while l <= r:
            mid = (l+r)//2
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                r = mid-1
            elif target > nums[mid]:
                l = mid+1
        return -1