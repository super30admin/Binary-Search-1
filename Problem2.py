# Time complexity - O(logn)
# Space complexity - O(1)
# Works on leetcode - yes 

class Solution(object):
    #function to find the target element in sorted array of infinite size
    # to apply binary search, we find the bounds first and then perform binary search within bounds
    # low and high bound start from 0 and 1 respectively. We see if the high element is less than target.
    # if it is, then the high index becomes the low index and we double the high index. 
    def search(self, arr, target):
        """
        :type reader: Array
        :type target: int
        :rtype: int
        """
        low,high, val = 0,1, arr[0]
        while val<target:
            low = high
            high *=2
            val = arr[high]
        while low<=high:
            mid = (low+high)//2
            if arr[mid]==target:
                return mid
            elif arr[mid]>target:
                h = mid -1
            else:
                l = mid +1
        return -1