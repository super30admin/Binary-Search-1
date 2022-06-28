"""
Runtime Complexity:
O(log n)- binary search takes O(log n) time. 
Space Complexity:
O(1) - no new data structure is created to compute the solution.
Yes, the code worked on leetcode
The idea behind the algorithm is to increment low to high and high by twice. In this way we traverse and check where our target range might reside. We increment and update low and high
and find the target's range and perform a binary search in that particular range.
"""


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high)<target:
            low = high
            high = high*2
            
        while (low<=high):
            mid = (low+(high-low)//2)
            if (reader.get(mid)==target):
                return mid
            elif (reader.get(mid)<target):
                low = mid+1
            else:
                high = mid-1
        return -1
