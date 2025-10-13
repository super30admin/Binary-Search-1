# Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.
class Solution:
	# To seatch for an element using binary search we need to ensure that target would lie in a particular range
    # Here since we are given an infinite array, it is hard to search
    # So we can search in steps.
    # We know array is sorted, so at any given point we know that target would like in a given window if the window's left most element is less than target and right most element is greater than target
    # Considering this we would first find the window.
    # We can start with finding in first element. Then we can find in first 2 elements, then 4 and so on. This way we will be able to search which part of the array the target lies in log(n) time.
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left = 0
        right = 1
        while(reader.get(right) < target):
            left = right
            right = right * 2
        
        while left <= right:
            mid = left + ((right - left)//2)
            if reader.get(mid) == target:
                return mid
            elif target <= reader.get(mid):
                # target lies in the left part
                right = mid - 1
            else:
                left = mid + 1

        return -1