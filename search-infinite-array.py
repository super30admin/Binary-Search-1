# Complexity: O(log(n)) + O(log(n))
class Solution(object):
    def searchInfiniteArray(self, nums, target):
        low = 0
        high = 1
       
        while nums[high] != sysmax.size and nums[high] <= target:
            low = high # improvement as nums[high] < target
            high = high * 2
        return binarySearch(nums, target, low, high)
    
    def binarySearch(nums, target, low, high):
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                low = mid + 1
            else
                high = mid - 1
        return -1