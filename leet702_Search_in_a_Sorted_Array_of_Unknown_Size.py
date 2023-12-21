
# Solution

# // Time Complexity : O(log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Forgot to update the low variables when applying binary search the second time


# // Your code here along with comments explaining your approach
# Approach is to first find the length of the array and then apply binary search to find target using length-1 as high.
# To find length, since in question it is provided that the interface would give value as 2^31 - 1 if the index is out of bounds
# and we know the size of array is between 1 and 10^4, we can use binary search technique by considering low as 0 and high as 10^4
# if we get out of bound then ignore everything from mid to high, push high one less than mid. If we get a value, ignore everything
# before value by keeping that index in a variable. Take low as mid+1. In the end, index will have the length
# Then using length, perform binary search to find the index of target

class ArrayReader:
    def __init__(self,arr):
        self.arr = arr
        self.length = len(arr)
    
    def get(self,index):
        if index >= self.length:
            return (2**(31) -1 )
        else:
            return self.arr[index]

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        outOfBoundVal = (2**31) - 1

        low = 1
        high = 10**4
        length = 0

        while low<=high:
            mid = (low+high)//2
            if reader.get(mid) == outOfBoundVal:
                high = mid-1
            else:
                length = mid
                low = mid+1
        
        low = 0
        high = length

        while low<=high:
            mid = (low+high)//2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid+1
            else:
                high = mid-1
        
        return -1

if __name__ == "__main__":
    arr = [-1,0,3,5,9,12]
    reader = ArrayReader(arr)

    solution = Solution()
    print(solution.search(reader,9))