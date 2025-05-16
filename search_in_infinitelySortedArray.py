# Setting the boundaries and expanding the search range until the high index matches the target or crosses it.
# Then, performed a binary search within the identified low and high bounds.

class Solution:
    def binarySearch(self, arr, l, r, x): 
        while(l<=r):
            # TO find index of mid element
            mid = (l+r) // 2
            # Comparing target wrt middle element
            if arr[mid] == x:
                return mid
            # Search operation on left part of sorted half
            elif arr[mid] > x:
                r = mid - 1
            # Search operation on right part of sorted half
            else:
                l = mid + 1
            # If no target is found 
        return -1
            
    def search(self, arr, key):
        # Setting the lower and upper bounds
        low = 0
        high = 1
        value =  arr[0]
        while value < key:
            # storing previous high and expanding the upper bound
            low = high
            high = 2 * high
            # update new value
            value = arr[high]
        return self.binarySearch(arr, low, high, key)

