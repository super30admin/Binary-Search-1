# Leetcode: 702. Search in a Sorted Array of Unknown size
# Time Complexity - if n - no. of elements then time - O(log n)
# Space Complexity - if we exclude the input array we are just using pointers hence, Space - O(1)
# Approach - I used binary search technique with two pointers l and r
# First, I expand the right boundary by doubling idx until reader.get(idx) >= target or idx is out-of-bounds (2^31 - 1)
# Once the boundary is found, I perform binary search in the range [idx//2, idx] using reader.get(mid)
# If reader.get(mid) == target, I return mid; if it's greater or out-of-bounds, I shift r = mid - 1, else l = mid + 1
# This code ran successfully on Leetcode

def search(reader: 'ArrayReader', target: int) -> int:
    idx = 1
    while reader.get(idx) < target and reader.get(idx) != (2**31)-1:
        idx *= 2
    print(idx)
    l, h = idx//2, idx
    while l <= h:
        mid = (l+h)//2
        if reader.get(mid) == target:
            return mid
        if reader.get(mid) > target:
            h = mid - 1
        else:
            l = mid + 1
    return -1