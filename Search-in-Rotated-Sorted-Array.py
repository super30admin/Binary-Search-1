#Reference video: https://www.youtube.com/watch?v=U8XENwh8Oy8
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        
        while (left <= right):
            mid = (left + right) // 2
            
            if nums[mid] == target:
                return mid
            
            #left sorted portion
            elif nums[left] <= nums[mid]:
                #check if:
                #target is not in the left portion (target > nums[mid]) or
                #target is not in the left portion as it is smaller than the left most element (target < nums[left])
                if target > nums[mid] or target < nums[left]:
                    left = mid + 1
                else:
                    right = mid - 1
            
            #right sorted portion
            else:
                #check if:
                #target is not in the right portion (target < nums[mid]) or
                #target is not in the right portion as it is greater than the right most element (target > nums[right])
                if target < nums[mid] or target > nums[right]:
                    right = mid - 1
                else:
                    left = mid + 1
        return -1