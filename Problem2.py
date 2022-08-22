# Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l,r=0,len(nums)-1
        while l<=r:
            mid = l + (r-l)//2 # Do this to prevent integer overflow
            if nums[mid] == target:
                return mid
            if nums[l] <= nums[mid]: #Check for left sorted 
                if target >= nums[l] and target < nums[mid]: # check if it lies in the left sorted range
                    r = mid -1
                else:
                    l = mid + 1
            else: #right sorted case 
                if target > nums[mid] and target <= nums[r]: # check if it lies in the right sorted range
                    l = mid + 1
                else:
                    r = mid - 1 
        return -1

# Time Complexity -> log(n)
# Space Complexity -> o(1)
    
