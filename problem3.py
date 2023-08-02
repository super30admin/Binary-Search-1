# Time Complexity : O(log(n)) where n is the number of elements in the array, log because each comparison reduces the search space by half
# Space Complexity : O(1) as we do it in constant space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I tried brute force first by using a while loop and incrementing the index by 1 but it would be O(n) time complexity

# Your code here along with comments explaining your approach in three sentences only
# Search in infinite sorted array 
# We use binary search here as we do not know the length of the array, we start with low = 0 and high = 1 and then we keep doubling the high until we find the target in the range of low and high
# Once we find the range, we apply binary search on that range to find the intended target


# Create ArrayReader class
class ArrayReader:
    def __init__(self, arr):
        self.arr = arr

    def get(self, index):
        if index >= len(self.arr):
            return float('inf')
        return self.arr[index]

def search(reader: "ArrayReader", target: int) -> int:
    
    # Setting high and low
    low = 0
    high = 1 # We start with 1 as we do not know the length of the array

    # We keep doubling the high until we find the target in the range of low and high - this is the range in which we apply binary search
    while target > reader.get(high):
        low = high
        high = high * 2

    return bs(reader, target, low, high) # Return the binary search function

def bs(reader: "ArrayReader", target: int, low: int, high: int) -> int:
        while low <= high:
            mid = low + (high - low) // 2 # Prevent integer overflow
            current = reader.get(mid)

            # if the current value which reader fetches is the target, return the index
            if current == target:  
                return mid
            
            # if it is greater than the target, we go left
            elif current > target:
                high = mid - 1

            else:
                # Else go right
                low = mid + 1

        return -1 # If the target is not present
            
    