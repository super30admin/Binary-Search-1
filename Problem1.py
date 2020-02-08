# Time Complexity : O(log n)
# Space Complexity :O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = (low + high) // 2
            # if the mid value is target then return
            if nums[mid] == target:
                return mid

            # if list is left sorted from mid then check if target lies in left sorted list, update low if it doesnt lie and high if it does lie in it
            if nums[low] <= nums[mid]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1

            # else if list is right sorted then  check if  target lies in right sorted list. Update low if it does lie and high if it does not lie in it
            elif nums[mid] <= nums[high]:
                if target >= nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        # return -1 if target is not present
        return -1