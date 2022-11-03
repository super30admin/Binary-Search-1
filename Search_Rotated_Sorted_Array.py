# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start:int = 0
        end:int = len(nums) - 1

        while start <= end:
            mid:int = start + ((end - start)//2)

            if nums[mid] == target:
                return mid

            # Left side is sorted
            elif (nums[start] <= nums[mid]):
                # target lies between start and mid
                if((target >= nums[start]) and (target < nums[mid])):
                    end = mid - 1
                else:
                    start = mid + 1

            # Right half is sorted
            else:
                # target lies between start and mid
                if((target > nums[mid]) and (target <= nums[end])):
                    start = mid + 1
                else:
                    end = mid - 1
        return -1