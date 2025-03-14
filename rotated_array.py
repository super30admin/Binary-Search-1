# We have roated sorted array in which one is left sorted arry and other is right sorted array
# Need to check if the target == nums[mid], then return that position or check whether the nums[mid] lies in left sorted array or right sorted array
# Based on the nums[mid] need to compare the target in left sorted array or right sorted array and chnage left and right pointer accordingly

# Time Complexity: O(log n) -> As we are always checking one half of the array it is O(log n)
# Space Complexity: O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums)-1

        while l<=r:
            mid = l + (r-l)//2

            if target == nums[mid]:
                return mid
            
            #left sorted array
            if nums[l] <= nums[mid]:
                if target > nums[mid] or target < nums[l]:
                    l = mid + 1
                else:
                    r = mid - 1
            else:
                if target < nums[mid] or target > nums[r]:
                    r = mid - 1
                else:
                    l = mid + 1
        
        return -1

