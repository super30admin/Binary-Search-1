# Time complexity : O(log(m) + log(k)), m is the pointer where high pointer ends and k is the range in which binary search is performed.
# Space complexity : O(1)

# The code ran on leetcode

def binary_search(target):
    l = 0; h = 1
    if reader.get(l) == target:
        return 0
    
    # Update low and high pointers such that the target lies between them
    while reader.get(h) < target:
        l = h; h = 2*h

    # Once the range is found, perform binary search in that range
    while l <= h:
        mid = l + (h-l)//2

        if reader.get(mid) == target:
            return mid
        # Search left portion of the array
        elif reader.get(mid) > target:
            h = mid - 1
        # Search right portion of the array
        else:
            l = mid - 1