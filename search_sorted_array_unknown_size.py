# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# The key here is to identify the range in which we need to perform the Binary Search. Hence, we first use the get method with index 0, 1, 2, 4, 8, 16,.... Increasing the search space by two each time. At each get function, we compare the target with it, If target is less than the current index's value. then we perform the binary search betwen the prev indexe's value and current index's value. As the target probably lies in this range
# The edge cases of reader.get gving index out of bounds, is it will give inf according to the condition. Hence, we will search between 

# TC is O(logn) base 2, and O(logm) base 2

# -1, 0, 3, 5, 9, 12, target = 9, i=0, j=1, 0, 
# 


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0
        i, j = 0, 1
        while reader.get(j) < target:
            i = j
            j = 2*j
        lo, hi = i, j
        while lo<=hi:
            mid = lo+(hi-lo)//2
            num = reader.get(mid)
            if num == target:
                return mid
            elif target < num:
                hi = mid-1
            elif target > num:
                lo = mid+1
        return -1

        