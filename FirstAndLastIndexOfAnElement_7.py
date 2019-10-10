# Time complexity - O(log(N))
# Verifying 3 conditions of binary search but with a twist when the mid is equal to target,
# then check for first and last index of that number
def firstIndex(nums, target):
    # function to calculate firstIndex
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = low + (high - low) // 2
        if target == nums[mid]:
            if mid == low or nums[mid - 1] < nums[mid]:
                # when the target is equal to mid check for previous element if the element is less than target
                # than return mid else assign that previous element as high and repeat the binary search.
                return mid
            else:
                high = mid - 1
        elif target > nums[mid]:
            low = mid + 1
        else:
            high = mid - 1
    return -1


def lastIndex(nums, target):
    # method to calculate last index
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = low + (high - low) // 2
        if target == nums[mid]:
            if mid == high or nums[mid + 1] > nums[mid]:
            # when the target is equal to mid check for next element if the element is greater than target
            # than return mid else assign that next element as low and repeat the binary search.
                return mid
            else:
                low = mid + 1
        elif target > nums[mid]:
            low = mid + 1
        else:
            high = mid - 1
    return -1


def searchRange(nums, target: int):
    first = firstIndex(nums, target)
    last = lastIndex(nums, target)
    # return both indices as a list.
    return [first, last]

sr = searchRange([0,1,1,1,1,2,3], 1)
print(sr)