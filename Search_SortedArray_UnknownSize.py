# Time Complexity : O(logN); 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No, since it needs premium leetcode
# Any problem you faced while coding this : No

# Approach: Binary Search


def search_sorted_unknownsize(self, reader, target):
    """
    :type reader: ArrayReader
    :type target: int
    :rtype: int
    """
    start, end = 0, 1
    while reader.get(end)<target:
        start, end = end+1, end*2
        
    while start<=end:
        mid = (start+(end-start))//2
        if reader.get(mid) == target:
            return mid
        elif reader.get(mid) > target:
            end = mid-1
        elif reader.get(mid) < target:
            start = mid+1
    return -1
            
