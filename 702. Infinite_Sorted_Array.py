# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Couldn't run without subscription.
# Any problem you faced while coding this : To understand the input, especially Array reader and how it works.

def search(nums, target) :
    """
    Expand the array range exponentially until target found 
    to be within it. After that apply normal binary search 
    within that range.
    """
    low = 0
    high = 1
    while target > nums[high]:
        low = high
        high = high * 2
    
    while low <= high:
        mid = low + (high - low) // 2
        if target == nums[mid]:
            return mid
        elif target > nums[mid]:
            low = mid + 1
        else:
            high = mid - 1
    return -1
        
