"""
    Time Complexity : O(logN)
    Space Complexity : O(1)
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
"""
# code without the class solution 
def search(nums, target):

    l = 0  # start
    r = len(nums)-1  # end
    while l <= r:
        # calculate mid point
        m = l + (r - l) // 2

        if nums[m] == target:
            return m

        # left sorted
        elif nums[m] >= nums[l]:
            # search in left side
            if target >= nums[l] and target < nums[m]:
                r = m-1
            # right side
            else:
                l = m+1
        # right sorted array
        else:
            if target <= nums[r] and target > nums[m]:
                l = m+1
            else:
                r = m-1

    return -1

# driver code to check my code 
arr = [4, 5, 6, 7, 0, 1, 2]
print(search(arr, 0))
