# Time Complexity: O(log n)
# Space Complexity: O(1)
# we check which half of the array is sorted and then decide which half to continue searching in based on the target value
def search(nums, target):
    start, end = 0, len(nums) - 1
    while start <= end:
        mid = start + (end - start) // 2
        if nums[mid] == target:
            return mid

        # Check if left half is sorted
        if nums[start] <= nums[mid]:
            if nums[start] <= target < nums[mid]:
                end = mid - 1
            else:
                start = mid + 1
        # Right half is sorted
        else:
            if nums[mid] < target <= nums[end]:
                start = mid + 1
            else:
                end = mid - 1

    return -1
