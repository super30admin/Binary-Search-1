# Time Complexity : O(log(n))
# Space Complexity : O(1). No extra auxilary space used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No.

def search(nums: list[int], target: int) -> int:
    if nums == []:
        return -1
    l = 0 
    h = len(nums) - 1
    while l <= h:
        m = l + (h - l)//2
        if nums[m] == target:
            return m
        if nums[m] >= nums[l]:
            # Left part is sorted
            if nums[l] <= target < nums[m]:
                h = m-1
            else:
                l = m+1
        else:
            # Right section is sorted
            if nums[m] < target <= nums[h]:
                l = m+1
            else:
                h = m-1
    return -1