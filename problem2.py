"""
Space Complexity: O(1) No extra memory 
Time Complexity: O(log(n)) We perform binary search here, as we divide the search space into halves as we go through our implementation which is to search for the element in the sorted half, if its not present, then we ignore that search space by moving the relevant pointer. 

"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        low = 0
        high = len(nums) - 1

        while low <= high: 

            mid = low + (high - low) // 2

            if nums[mid] == target: 
                return mid

            if nums[low] <= nums[mid]: 
                if nums[low] <= target < nums[mid]: 
                    high = mid - 1
                else: 
                    low = mid + 1

            else:
                if nums[mid] < target <= nums[high]: 
                    low = mid + 1
                else: 
                    high = mid - 1

        return -1


