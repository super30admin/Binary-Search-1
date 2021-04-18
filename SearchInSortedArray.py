'''
// Time Complexity :
 # 1. Find the search scope by using the API to find the lower and upper ends of the array
 # 2. Once we have the lower and upper ends, its mere binary - search

  I am finding it tricky to pen down the time complexity, operation 2 takes O(Log(N)) for sure, but I am not confident about the first operation

// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes while defining the boundaries for the binary search on line 49
'''

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """

        '''
        Apporach 1 - Brute force method O(N), linearly check if the number is target for every                        get method
        k = 0 
        while(reader.get(k) != 2147483647):
            if target == reader.get(k):
                return k 
            k += 1 

        return -1

        '''

        # Binary search - find the most appropriate location in the stream of reader

        # 1. Find the search scope by using the API to find the lower and upper ends of the                   array
        # 2. Once we have the lower and upper ends, its simple binary - search

        # 3. I am finding it tricky to pen down the time complexity, operation 2 takes O(Log(N))              for sure, but I am not confident about the first operation

        start = 0
        end = 1
        while (reader.get(end) < target):
            start = end
            end *= 2
        print(end)
        # simple binary searh
        while (start <= end):
            mid = (start) + (end - start) // 2
            if target == reader.get(mid):
                return mid
            elif target < reader.get(mid):
                end = mid - 1
            else:
                start = mid + 1
        # if the taeget was not found within the range, return -1
        return -1


