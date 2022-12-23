# Exercise_2: Search in Rotated Sorted Array
# Time Complexity: O(log(N)), where N is the number of elements in the array
# Space Complexity: O(1)
# Successful Run on Leetcode: Yes (https://leetcode.com/problems/search-in-rotated-sorted-array/)
# Challenges: None

# Coding Approach:
# If the array is empty, return -1
# Set low to 0 and high to len(nums) - 1
# While low is less than or equal to high, compute the mid index
# If the value at the mid index is equal to the target, return mid
# If the value at the low index is less than or equal to the value at the mid index, and if the target is greater than or equal to the value at the low index and less than the value at the mid index, set high to mid - 1 (the target is present in the left half). Otherwise, set low to mid + 1 (the target is present in the right half)
# If the value at the low index is greater than the value at the mid index, and if the target is greater than the value at the mid index and less than or equal to the value at the high index, set low to mid + 1 (the target is present in the right half). Otherwise, set high to mid - 1 (the target is present in the left half)


def search(nums, target):
    if nums == None or len(nums) == 0:
        return -1
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = low + (high - low)//2
        if nums[mid] == target:
            return mid
        elif nums[low] <= nums[mid]:
            if target >= nums[low] and target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        else:
            if target > nums[mid] and target <= nums[high]:
                low = mid + 1
            else:
                high = mid - 1
    return -1

print(search([4,5,6,7,0,1,2], 0))
print(search([4,5,6,7,0,1,2], 3))