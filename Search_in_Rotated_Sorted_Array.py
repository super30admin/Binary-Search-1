#time complexity: O(log n) for both the methods
#space complexity: O(1) no auxillary data structure used

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        '''if not nums:
            return -1
        y = sorted(nums)
        if target in y:
            return nums.index(target)
        else:
            return -1'''
        def binary_search(array, low, high, target):
            while low<=high:
                mid = (low+high)//2
                if array[mid] == target:
                    return mid
                elif array[mid]>target:
                    high = mid-1
                elif array[mid]<target:
                    low = mid+1
            return -1
        
        def findpivot(array, low, high):
            while low<=high:
                mid = (low+high)//2
                if array[mid]<array[mid-1]:
                    return mid
                if array[0]<=array[mid]:
                    low = mid+1
                else:
                    high = mid-1
            return 0
        
        pivot = findpivot(nums, 0, len(nums)-1)
        if pivot == 0:
            return binary_search(nums, 0, len(nums)-1, target)
        
        if target<nums[0]:
            return binary_search(nums, pivot, len(nums)-1, target)
        else:
            return binary_search(nums, 0, pivot-1, target)