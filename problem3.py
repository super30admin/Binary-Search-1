# Time Complexity : O(log m + log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes 
# Any problem you faced while coding this : No, it was a bit tricky to understand the problem statement and how to approach it, but once I got the idea, it was straightforward.



def search(self, reader: 'ArrayReader', target: int) -> int:
    #this is to understand the range of the array, we will keep doubling the high until we find a value that is greater than the target
    low = 0
    high = 1
    while reader.get(high) < target:
        low = high
        high = high * 2
        #after this we will implement binary search on the range we found
    while low <= high:
         mid = low + (high - low) // 2
    if reader.get(mid) == target:
        return mid
    if reader.get(low) <= reader.get(mid):
        if reader.get(low) <= target < reader.get(mid):
            high = mid - 1
        else:
            low = mid + 1
    else:
        if reader.get(mid) < target <= reader.get(high):
            low = mid + 1
        else:
            high = mid - 1
    return -1
