"""
time: O(logn)
space: O(1)
Leet : Problem not from leetcode
Problems faced: No problems.
"""
def infiniteBinary(nums,target):
    slow = 0
    fast = 1
    
    while nums[fast] < target:
        slow = fast
        fast *= 2

    if nums[fast] == target:
        return fast
    return binSearch(nums,slow,fast,target)

    def binSearch(arr,low,high,target):

        while low<=high:
            mid = (low+high)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]<target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
