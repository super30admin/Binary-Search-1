# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/description/

# Secret array - We don't know the size of the array. We can access the element using reader API. It's a sorted array, we need to identify the location of the element.
# If we try to access an element which doesn't exist in the array, then it won't throw error, but will return MAX_VALUE

# reader.get(1) -> 1

# This implementation is done in such a way that it uses array as input inplace of reader API. 

class Solution:

    def search(self, nums, target):
        low, high = 0, 1

        while nums[high] < target:
            low = high
            high = high * 2

        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
    
s = Solution()
result = s.search([-1,0,2,4,5,6,7,8,9], 7)
print(result)
            