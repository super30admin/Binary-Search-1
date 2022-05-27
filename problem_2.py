# Time Complexity : O(log*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# first determine which part of the array is sorted, then check whether target falls in that sorted array
# if yes, set start pointer to mid + 1 (if it is left sorted)
# else set end pointer to mid - 1
# if it is right sorted did the other way.

def search(nums, target):
    a = 0
    b = len(nums) - 1
    while a <= b:
        mid = a + (b-a)//2
        if nums[mid] == target:
            return mid
        else:
            if nums[mid] >= nums[a]:
                if nums[a] <= target < nums[mid]:
                    b = mid - 1
                else:
                    a = mid + 1
            else:
                if nums[b] >= target > nums[mid]:
                    a = mid + 1
                else:
                    b = mid - 1


print(search([5, 1, 2, 3, 4], 1))
