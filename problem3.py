# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Problem 702 : https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        """
        Approach : In this problem, we are provided with a sorted array, and given a target. 
            But the only challenge is we are not aware of the size of the array.
            The array reader get function will return 2^32-1 if we search for out of bounds.
            Instead we can just keep multiplying our high until it is less than target.

            One simple optimization is that we keep moving our low along with high, because
            we are aware that high is not greater than target previously, so our target does
            not exist in that window, it could be found in the next window.

            Once we found low and high, we apply straight forward binary search to get our
            desired result. if the target is not present in the array, we return -1.

        Time Complexity:
            To find High - O(log(N)), To search target - O(log(N))
            Total - O(log(N))
        Space Complexity:
            O(1) 

        """
        low, high, mid = 0, 1, 0
        while reader.get(high) <= target:
            low = high
            high = high*2
        while(low <= high):
            mid = low + (high - low)//2
            cur = reader.get(mid)
            if cur == target:
                return mid
            elif cur > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

