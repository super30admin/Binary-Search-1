# Time Complexity O(logn)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums)-1
        while start <= end:
            mid = start + (end-start)//2

            if target == nums[mid]:
                return mid

            # find if element is in which half. One half is guarenteed to be sorted.
            if nums[start] <= nums[mid]:
                # if left is sorted. Check if element can fall on the left side.
                if target < nums[mid] and target >= nums[start]:
                    end = mid-1
                else:
                    # go to un-sorted side since element can't be found in sorted side.
                    start = mid+1
            else:
                # if right is sorted check if element can fall in the right side.
                if target > nums[mid] and target<= nums[end]:
                    start = mid+1
                else:
                    # go to un-sorted side since eleemnt can't be found in sorted side.
                    end = mid-1
        # if not found
        return -1