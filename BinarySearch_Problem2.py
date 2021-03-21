#brute force - linear search O(n)
#modify binary search to get O(log n)
# constraints
# 1 <= nums.length <= 5000
# all values are unique
# nums is guaranteed to be rotated at some piovt

def findInRotatedSortedArray(nums:List[int], target:int) -> int:
    low, high = 0, len(nums)-1
    while(low <= high):
        mid = low + (high-low)//2
        if(nums[mid] == target):
            return mid
        #left is sorted
        if(nums[low] <= nums[mid]):
            if(nums[low] <= target and nums[mid] > target):
                high = mid -1
            else:
                low = mid + 1
        #else right may be sorted
        else:
            if(nums[high] >= target and nums[mid] < target):
                low = mid + 1
            else:
                high = mid - 1
    return -1