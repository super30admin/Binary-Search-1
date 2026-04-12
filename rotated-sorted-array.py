# time: O(logn)
# space: O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)-1

        # [6,0,1,2,3]
         # l   m   r    
        # [4,5,6,7,0,1,2] 6
        #  l     m     r
        while left <= right:
            mid = left + (right - left)//2

            if nums[mid] == target:
                return mid

            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1 