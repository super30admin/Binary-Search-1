'''
    Time Complexity:
        O(log(n))

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Follows the Binary Search paradigm.
        -> Find the mid.
        -> If target is at mid: return mid.
        -> Else if left part [low:mid] is sorted:
            -> If target >= val at low and target < val at mid:
                Continue search in [low:mid-1]
            -> Else:
                Continue search in [mid+1:high]
        -> Else:
            -> If target > val at mid and target <= val at high:
                Continue search in [mid+1:high]
            -> Else:
                Continue search in [low:mid-1]
'''
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1

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
