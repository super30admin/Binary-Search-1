# Time Complexity : log n
# Space Complexity : n
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No major problems but leetcode has a testcase where the input
# is not rotated [1,3] so I had to code that condition. Again took me around 45 mins.

# Your code here along with comments explaining your approach
# I find the pivot where the array is rotated using binary search but the condition is that the value at mid
# is lesser than start and greater than end moving toward the pivot. Once I have the pivot, I do opposite of
# binary search (plus comparison with one end, line 22) once, to enter the correct pivot and then do regular 
# binary search

import math
class Solution:
    def search(self, nums, target):
        end = len(nums) - 1
        start = 0
        mid = math.floor((end) / 2)
        if nums[mid] < nums[start] or nums[mid] > nums[end]:
            pivot = self.bin_search_pivot(nums, 0, end)
            if nums[pivot] == target:
                return pivot
            if nums[pivot] > target and nums[end] < target:
                return self.bin_search(nums, 0, pivot-1, target)
            else:
                return self.bin_search(nums, pivot+1, end, target)
        else:
            return self.bin_search(nums, 0, end, target)
        
    def bin_search_pivot(self, nums, start, end):
        if start < end:
            mid = start + math.floor((end - start) / 2)
            if nums[mid] > nums[start]:
                return self.bin_search_pivot(nums, mid, end)
            elif nums[mid] < nums[end]:
                return self.bin_search_pivot(nums, start, mid)
            else:
                return mid
        else:
            return start
    
    def bin_search(self, nums, start, end, target):
        if start < end:
            mid = start + math.floor((end - start) / 2)
            if nums[mid] > target:
                return self.bin_search(nums, start, mid-1, target)
            elif nums[mid] < target:
                return  self.bin_search(nums, mid+1, end, target)
            else:
                return mid
        else:
            if start<len(nums) and nums[start] == target:
                return start
            return -1

if __name__ == "__main__":
    s = Solution()
    nums = [6,7,8,9,10, 11, 12, 1,2,3]
    r = s.search(nums, 2)
    print(r)
    r = s.search(nums, 8)
    print(r)
    r = s.search(nums, 4)
    print(r)
    nums = [1,2,3,6,7,8,9]
    r = s.search(nums, 2)
    print(r)
    r = s.search(nums, 6)
    print(r)
    r = s.search(nums, 4)
    print(r)
