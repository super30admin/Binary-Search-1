## Time complexity : O(log(n)), we search half of the array at every time step
# Space complexity : O(1), space to maintain left and right pointers
# The code ran on github

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        l = 0; h = len(nums) -1

        while l <= h:

            mid = l + (h-l)//2
            if nums[mid] == target: return mid
            # One portion of the array is always sorted. Check if the left sub half is sorted

            elif nums[l] <= nums[mid]:

                # Check if the target falls in the range l, mid
                if nums[l] <= target and nums[mid] > target:
                    h = mid - 1
                else:
                    l = mid + 1
            
            else:
                # The right portion of the array is sorted. Move to right if the target falls in the range mid, h
                if nums[mid] < target and nums[h] >= target:
                    l = mid + 1
                else:
                    h = mid - 1
        return -1