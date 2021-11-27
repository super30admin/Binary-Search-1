class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right-left)//2
            if nums[mid] == target:   #HAPPY CASE
                return mid
            elif nums[mid] >= nums[left]:   # IF LEFT ARRAY IS SORTED 
                if nums[left] <= target and target < nums[mid]: # SEARCH IN THE LEFT HALF
                    right = mid - 1
                else:
                    left = mid+1             # IF TARGET IS NOT IN LEFT HALF, MOVE TO RIGHT HALF
            elif nums[mid] <= nums[left]:
                if target <= nums[right] and target > nums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1
'''
TIME COMPLEXITY = O(logN)
'''
