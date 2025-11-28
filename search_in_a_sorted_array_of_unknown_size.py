# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/description/

# In this problem we need to find the target. This is done by doubling the index till we find the range where the target element is present. Once we find the range we apply the binary search. And find the location of the target element. Complexity O(log n)

# implementing own array reader to test locally
class ArrayReader:
    def __init__(self, array = []):
        self.array = array

    def get(self, index: int):
        return self.array[index]

class Solution:
    def search (self, reader : ArrayReader, target :int) -> int:
        low = 0
        high = 1

        # reader.get(high) returns the value the index. we are checking that value with the given target
        while reader.get(high) < target:
            # if the target is greater than the high value double the high index until we find the range of the target
            low = high
            high *= 2
        # dont let low cross the high if it then we have searched already and we didnt get required element
        while low <=  high:
            mid_index = (low + high) // 2
            # check the target is equal to the mid_index
            if reader.get(mid_index) == target:
                return mid_index
            # if the target is less than the mid element change the high
            if reader.get(mid_index) > target:
                high = mid_index - 1
            # if the target is greater than the mid element change the low
            else:
                low = mid_index +1
        return -1
    
op = Solution()

print(op.search(ArrayReader([-1,0,3,5,9,12]),9))
print(op.search(ArrayReader([-1,0,3,5,9,12]),2))




