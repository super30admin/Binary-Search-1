'''
The rotated sorted array will always have one part that is fully sorted.

Finding the mid and then see which side of the mid is sorted.
In the sorted side try to see in the numbers are in the range of target or it contains target by checking the first 
and the last item of the side.

If the target is not in the sorted side, do further binary search in the other side.
If target is in the sorted side, do the further binary search in the sorted side.
'''

class Solution:
    def search_helper(self, nums: List[int], l: int, r: int, target: int):
        if l > r:
            return -1

        m = l + (r-l)//2

        if nums[m] == target:
            return m

        # Left of mid is sorted array
        if nums[l] <= nums[m]:
            # If target lies in the sorted array
            if nums[l] <= target < nums[m]:
                return self.search_helper(nums, l, m-1, target)
            else:
                return self.search_helper(nums, m+1, r, target)

        # Right of mid is sorted array
        else:
            # If target lies in the sorted array
            if nums[m] < target <= nums[r]:
                return self.search_helper(nums, m+1, r, target)
            else:
                return self.search_helper(nums, l, m-1, target)
            

    def search(self, nums: List[int], target: int) -> int:
        return self.search_helper(nums, 0, len(nums)-1, target)