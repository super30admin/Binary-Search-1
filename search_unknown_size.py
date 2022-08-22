"""
Suppose you are given a sorted array of unknown length and a number to search for, return the index of the number. 
Accessing an element out of bounds throws exception. 
If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1. 

Time Complexity: O(log(n))(Worst case: for an array of size n and target is at the n-1th index)
Space Complexity: O(1)

"""


def search_unknown_size(nums, target):
    l, r = 0, 1

    while(nums[r] < target):
        l = r
        r *= 2

    return bin_search(nums, target, l, r)


def bin_search(nums, target, l, r):
    while l < r:
        mid = (l+r)//2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            l = mid+1
        else:
            r = mid
    return -1
