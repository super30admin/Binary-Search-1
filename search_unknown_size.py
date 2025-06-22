# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:


'''
The problem currently says

O(logn)+O(logk)

The reason we are not directly using binary search over this problem to make a
balance between logn and logk, instead of directly applying it all the pressure on the logK

Time Complexity: O(log n)
Space Complexity: O(1)
'''

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:


        low = 0
        high=1

        while(target>reader.get(high)):
            low = high
            high = high*2


        while(low<=high):

            mid = (low+high)//2

            if(target==reader.get(mid)):
                return mid

            elif(reader.get(mid)>target):
                high = mid-1
            else:
                low = mid+1

        return -1



