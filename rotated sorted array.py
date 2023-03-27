
# we are using binary search to sort the arrays.

#tc: o(logn)
#sc: o(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        if nums == None or len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low+(high - low)//2
            if nums[mid] == target:
                return mid

            if nums[low] <= nums[high]:
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1