# // Time Complexity : O(log N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : N/A
# Leetcode Link: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/


# // Your code here along with comments explaining your approach
'''
Since we know the length of the "reader" array can be 10^4 at max, 
we can just make a binary search with boundaries (0, 10^4 - 1)
Time complexity = O(1)

def search(self, reader, target):
    """
    :type reader: ArrayReader
    :type target: int
    :rtype: int
    """
    l, r = 0, 10**4
    array_oob = 2**31-1
    while l <= r:
        mid = (l+r)//2
        mid_ele = reader.get(mid)
        if mid_ele == target:
            return mid
        if mid_ele > target:
            r = mid-1
        else:
            l = mid+1
    return -1
'''

'''
Shifting boundaries and results (for an arbitary no-limit length array)
- Start with first element (L, R = 0, 1) 
- Keep expanding boundaries (exponentially) till the target is not contained within the L and R (L = R+1, R *= 2)
- When the target is within the boundaries, perform regular binary search
'''
def search(self, reader, target):
    """
    :type reader: ArrayReader
    :type target: int
    :rtype: int
    """
    l, r = 0, 1
    
    # We increase the right boundary exponentially to maintain logarithmic complexity
    while target > reader.get(r):
        l = r+1
        r *= 2 
    
    while l <= r:
        mid = (l+r)//2
        mid_ele = reader.get(mid)
        if mid_ele == target:
            return mid
        if mid_ele > target:
            r = mid-1
        else:
            l = mid+1
    return -1
                