# Leetcode: 33. Search in Rotated Sorted Array
# Time Complexity - if n - no. of elements then time - O(log n)
# Space Complexity - if we exclude the input array we are just using pointers hence, Space - O(1)
# Approach - I used binary search technique using two pointers l, r where l = 0, r = len(array)-1
# after we find mid = (l+r)//2 there are two conditions:
# Condition 1: nums[l] < nums[mid] means the left array is sorted and check if the target:
# nums[l] <= target <= nums[mid] then reduce the r pointer r = mid -1 else l = mid + 1
# Condition 2: if nums[l] > nums[mid] means there are rotated elements present in the left array
# check if target is between nums[mid] and nums[r] if so l = mid + 1 else r = mid - 1
# This code ran successfully on Leetcode

def search(nums, target) -> int:
    l, r = 0, len(nums)-1
    while l <= r:
        mid = (l+r)//2
        if nums[mid] == target:
            return mid
        if nums[l] < nums[mid]:
            if nums[l] <= target <= nums[mid]:
                r = mid - 1
            else:
                l = mid + 1
        else:
            if nums[mid] <= target <= nums[r]:
                l = mid + 1
            else:
                r = mid - 1
    return -1

nums = [4,5,6,7,0,1,2]
target = 0
print(search(nums, target))
nums = [4,5,6,7,0,1,2]
target = 3
print(search(nums, target))