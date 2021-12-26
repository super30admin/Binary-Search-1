'''
TC: O(logn)
SC: O(1)
Intuition: when finding pivot / mid, atleast one half is always sorted.
'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # when finding pivot / mid, atleast one half is always sorted.
        
        arr_len = len(nums)
        if not arr_len:
            return -1
        
        start, end = 0, arr_len - 1
        
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == target:
                return mid
            if start == end:
                return -1
            
            if (mid -1 >= start and nums[start] <= nums[mid-1]):
                if nums[start] <= target <= nums[mid-1]:
                    end = mid -1
                else:
                    start = mid + 1
            elif (mid + 1 <= end and nums[mid+1] <= nums[end]):
                if nums[mid + 1] <= target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid -1
            
                
        return -1
        