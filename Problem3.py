""" 
Time Complexity: O(log(n))

Space Complexity: O(1)

Approach: 
In this problem, the core idea is to extract the range in which the binary search can be performed, binary search because the array is sorted 
in order to extract the range, we use the exponential search to determine the range to perform binary search 
we then perform binary search in the predetermined range

"""


class Solution:
    def search(self, reader: "ArrayReader", target: int) -> int:

        # if the lowest element of the array is greater than the target, which means the array doesn't have the target element
        if target < reader.get(0):
            return -1

        low = 0
        high = 1
        OUT_OF_BOUND = 2**31 - 1


        # exponential search to determine the range to perform binary search 
        while reader.get(high)!=OUT_OF_BOUND and reader.get(high)<target:
            low = high
            high = high*2 

        # performing binary search in a predetermined range 
        while low <= high:

            mid = low + (high - low) // 2

            if reader.get(mid) == target:
                return mid
            if reader.get(mid) < target:
                low = mid + 1
            else:
                 high = mid - 1

        return -1
