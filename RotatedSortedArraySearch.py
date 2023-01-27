"""
Rasika Sasturkar
Time Complexity: O(logn), just searching half array everytime
Space Complexity: O(1)
"""


def search(nums, target) -> int:
    """
    The optimal solution is to implement binary search on the entire array.
    We use the property of rotated array that either side of mid is sorted,
    i.e. if it is left_sorted, we perform binary search on that part to get
    the target, or of it is right sorted, we search the target using binary
    search in that part.
    It will return -1 if target is not found in the list, or if the list is empty.
    """
    if nums is None or len(nums) == 0:
        return -1
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = low + (high - low) // 2
        if nums[mid] == target:
            return mid
        elif nums[low] <= nums[mid]:  # left-sorted
            if nums[low] <= target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        else:  # right-sorted
            if nums[mid] < target <= nums[high]:
                low = mid + 1
            else:
                high = mid - 1
    return -1


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    nums1 = [4, 5, 6, 7, 0, 1, 2]
    target1 = 0
    print(search(nums1, target1))  # output is 4
    nums2 = [1]
    target2 = 0
    print(search(nums2, target2))  # output is -1


if __name__ == "__main__":
    main()
