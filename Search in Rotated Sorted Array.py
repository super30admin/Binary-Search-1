# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

def rotatedSorted(nums, target):
    #null
    if nums == None or len(nums) == 0:
        return -1

    low =0
    high = len(nums) - 1
    while(low <= high):
        mid = low + (high - low) // 2
        if nums[mid] == target:
            return mid
        #left sorted
        elif nums[low] <= nums[mid]:
            if nums[low] <= target and nums[mid] >= target:
                high = mid - 1
            else:
                low = mid + 1
        #right sorted
        else:
            if nums[high] >= target and nums[mid] <= target:
                low = mid + 1
            else:
                high = mid - 1
    return -1

nums = [5,1,3]
target = 3
print(rotatedSorted(nums,target))
