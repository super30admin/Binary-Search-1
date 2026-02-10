# https://leetcode.com/problems/search-in-rotated-sorted-array/description/

# Search in a rotated sorted array

class Solution :

    def rotatedSorted(self, nums, target):
        low, high = 0, len(nums) - 1

        while low <= high:

            mid = (low + high) // 2
            
            if nums[mid] == target:
                return mid
            
            if nums[low] <= nums[mid]: # left sorted
                if nums[low] < target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target and nums[high] > target:
                    low = mid + 1
                else:
                    high = mid - 1
        
        return -1
    
s = Solution()
result = s.rotatedSorted([4,5,6,7,0,1,2], 5)
print(result)
    

            